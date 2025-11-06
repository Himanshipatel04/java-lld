package SingletonPattern;

class DbInstance {

    private static final DbInstance instance = new DbInstance();

    private DbInstance() {
        System.out.println("Database Instance Created (Eager Initialization)");
    }

    public static DbInstance getInstance() {
        return instance;
    }
}

public class EagerInitialization {
    public static void main(String[] args) {
        DbInstance db1 = DbInstance.getInstance();
        DbInstance db2 = DbInstance.getInstance();

        if (db1 == db2) {
            System.out.println("Both instances are the same");
        } else {
            System.out.println("Different instances created");
        }
    }
}
