import java.util.ArrayList;
import java.util.List;
import java.lang.ref.WeakReference;

public class Main {
    private static List<Object> memoryLeakList = new ArrayList<>();
    private static List<WeakReference<Object>> weakRefList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Simulating memory leak...");
        simulateMemoryLeak();
        System.out.println("Memory leak simulation completed.");
        
        detectMemoryLeak();
        
        System.out.println("Number of objects remaining in memoryLeakList: " + memoryLeakList.size());
        
        suggestSolution();
    }

    private static void simulateMemoryLeak() {
        for (int i = 0; i < 100000; i++) {
            Object obj = new Object();
            memoryLeakList.add(obj);
            weakRefList.add(new WeakReference<>(obj));
            
            if (i % 10 == 0) {
                memoryLeakList.remove(memoryLeakList.size() - 1);
            }
        }
    }

    private static void detectMemoryLeak() {
        System.gc(); // Request garbage collection
        
        int leakedObjects = 0;
        for (WeakReference<Object> weakRef : weakRefList) {
            if (weakRef.get() != null) {
                leakedObjects++;
            }
        }
        
        System.out.println("Detected " + leakedObjects + " leaked objects.");
    }

    private static void suggestSolution() {
        System.out.println("\nSuggested solution to fix the memory leak:");
        System.out.println("1. Clear the memoryLeakList when objects are no longer needed:");
        System.out.println("   memoryLeakList.clear();");
        System.out.println("2. Set individual elements to null if partial clearing is needed:");
        System.out.println("   memoryLeakList.set(index, null);");
        System.out.println("3. Use WeakReference or SoftReference for caching scenarios.");
        System.out.println("4. Implement a custom cache with size limits and eviction policies.");
    }
}