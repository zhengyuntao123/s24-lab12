package AndrewWebServices;

import java.util.HashMap;
import java.util.Map;

/*
 * InMemoryDatabase is a fake for the AndrewWS database which is used to improve test efficiency.
 * Remember, fakes are fully functional classes with simplified implementation.
 * What is the simplest core functionality that we need for a functional database?
 * 
 * Hint: there are two methods you need to implement
 */
public class InMemoryDatabase extends Database {
    // Implement your fake database here
    Map<String,Integer> database;

    public InMemoryDatabase(){
        database=new HashMap<>();
        setPassword("Scotty", 17214);
    }
    public void setPassword(String accountName,int password){
        database.put(accountName,password);
    }

    @Override
    public int getPassword(String accountName){
        return database.get(accountName);
    }
}