package demo1.singleton;

public class Single {
    public static void main(String[] args) {
        Singleton.getInstance();
    }
}

class Singleton {
    private Singleton() {
    }

    ;

    private static class LazyHolder {
        private static final Singleton singleton = new Singleton();

        static {
            System.out.println("初始化");
        }
    }

    public static Singleton getInstance() {
        return LazyHolder.singleton;
    }
}

