

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class MainDZ {
    private static final int ARRAY_CAPACITY = 100_000;


    public static final int MAX_VALUE = 100_000;

    public static void main(String[] args) throws InterruptedException {

        Supplier<Array> constructor = SortedArrayImpl::new;

        Array<Integer> arr1 = createArray(constructor);

        Array arr2 = createArray(constructor);
        Array arr3 = createArray(constructor);

        randomInitialize(arr1, arr2, arr3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Runnable> tasks = new ArrayList<>();
        tasks.add(measureTime(arr1::sortBubble, "Sort Bubble"));
        tasks.add(measureTime(arr2::sortSelect, "Sort Select"));
        tasks.add(measureTime(arr3::sortInsert, "Sort Insert"));

        tasks.forEach(executorService::execute);

        for (Runnable task : tasks) {
            executorService.execute(task);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static void randomInitialize(Array... arrays) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            int value = random.nextInt(MAX_VALUE);
            for (Array array : arrays) {
                array.add(value);
            }
        }
    }

    private static Runnable measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.println(String.format("%s took time: %d micros.",
                    actionName,
                    TimeUnit.NANOSECONDS.toMicros(duration)));
        };
    }

    private static <T> Array<T> createArray(Supplier<Array> factory) {
        return factory.<T>get();//new ArrayImpl()
    }
}