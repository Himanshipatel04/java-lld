package SOLID.DIP;

//high level modules should not depend on low level modules. Both should depend on abstractions.
//Abstractions should not depend on details. Details should depend on abstractions.
//(high level modules are those modules which deals with business logic where as low level modules are those which interact with system..api call, system)

//for example: suppose there is an application and 2 classes mongodb and sql. application wants to save the incoming data to both the dbs. now suppose that tomorrow i have to use cassandra in place of mongodb. if application class is directly dependent on mongodb and sql classes then i have to change application class also to replace mongodb with cassandra. this violates DIP. to adhere to DIP we can create an interface DBOperations and let mongodb,sql and cassandra implement that interface. now application class will depend on DBOperations interface rather than concrete classes. so now if we have to replace mongodb with cassandra we just have to change the instantiation part not the application class.

//if open closed principle is followed then also DIP is followed as high level module depends on abstraction and low level module also depends on abstraction.

// Abstraction for DB operations
interface DBOperations {
    void saveData(String data);
}

// MongoDB implementation
class MongoDB implements DBOperations {
    @Override
    public void saveData(String data) {
        System.out.println("Data saved to MongoDB: " + data);
    }
}

// SQL implementation
class SQLDatabase implements DBOperations {
    @Override
    public void saveData(String data) {
        System.out.println("Data saved to SQL Database: " + data);
    }
}   

// Application class depending on abstraction
class Application
{
    private DBOperations dbOperations;

    public Application(DBOperations dbOperations) {
        this.dbOperations = dbOperations;
    }

    public void processData(String data) {
        // Business logic processing
        dbOperations.saveData(data);
    }
}


public class DIP {
    
}
