package SingletonPattern;

class DbInstance {

    private static DbInstance instance;

    private DbInstance() {
        System.out.println("Database Instance Created");
    }

    public static synchronized DbInstance getInstance() {
        if (instance == null) {
            instance = new DbInstance();
        }
        return instance;
    }
}

public class Singleton {
    public static void main(String[] args) throws InterruptedException {

        final DbInstance[] db1 = new DbInstance[1];
        final DbInstance[] db2 = new DbInstance[1];

        Thread t1 = new Thread(() -> db1[0] = DbInstance.getInstance());
        Thread t2 = new Thread(() -> db2[0] = DbInstance.getInstance());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        if (db1[0] == db2[0]) {
            System.out.println("Both instances are the same");
        } else {
            System.out.println("Different instances created");
        }
    }
}
