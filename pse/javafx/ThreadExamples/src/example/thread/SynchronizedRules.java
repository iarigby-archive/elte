package example.thread;

public class SynchronizedRules {
    
    public synchronized void instanceMethod() {
        // ...
    }
    // is equal to
    public void instanceMethod2() {
        synchronized (this) {
            // ...
        }
    }
    
    
    
    public static synchronized void staticMethod() {
        // ...
    }
    // is equal to
    public static void staticMethod2() {
        synchronized (SynchronizedRules.class) {
            // ...
        }
    }

}

