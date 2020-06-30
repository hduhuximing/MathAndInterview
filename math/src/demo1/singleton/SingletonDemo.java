package demo1.singleton;

public class SingletonDemo {
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println("构造方法应该只执行一次");
    }

    public static SingletonDemo getInstance() {
        synchronized (SingletonDemo.class) {
            if (instance == null) {
                synchronized (SingletonDemo.class) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
//        System.out.println(SingletonDemo.getInstance() == SingletonDemo.getInstance());
        for (int i = 0; i < 10; i++) {
            new Thread(SingletonDemo::getInstance, String.valueOf(i)).start();
        }
    }
}

