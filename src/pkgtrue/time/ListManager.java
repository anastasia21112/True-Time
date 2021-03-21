
package pkgtrue.time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

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
    
    public void addTask(String listName, Double time)
    {
        Task temp = new Task(listName, time);
    }
    
    public ArrayList keySet()
    {
        // Places all keys in an arraylist of type String
        Set<String> keySet = this.listManager.keySet();
        Object[] keyArray = keySet.toArray();
        ArrayList<String> keyArrayList = new ArrayList<String>();
        for(int i = 0; i < keyArray.length; i++)
        {
            keyArrayList.add((String) keyArray[i]);
        }
        
        return keyArrayList;
    }
}
