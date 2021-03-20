
package pkgtrue.time;

import java.util.ArrayList;
import java.util.HashMap;

public class ListManager {
    
    //HashMap<String, ArrayList<Task>>
    //HashMap<listName, arrayList of Tasks> 
    public static HashMap<String, ArrayList<Task>> listManager = new HashMap<String, ArrayList<Task>>();
    
    public ListManager()
    {
          
    }
    
    public void addList(String listName)
    {
        ArrayList<Task> empty = new ArrayList<Task>();
        listManager.put(listName, empty);
    }
    
    public void addTask(String listName, String taskName)
    {
        
    }
}
