
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
    
    public void deleteList(String listName)
    {
       
        listManager.remove(listName);
    }
    
    public void addTask(String listName, String taskName, Double time)
    {
        Task temp = new Task(taskName, time);
        listManager.get(listName).add(temp);
    }
    
    public void deleteTask(String listName, String taskName)
    {
        int indexofRemoval = findTask(listName, taskName);
        listManager.get(listName).remove(indexofRemoval);
    }
    
    public int findTask(String listName, String taskName)
    {
        int index = -2;
        boolean found = false;
        for(int i = 0; i < this.listManager.get(listName).size() && !found; i++)
        {
            Task temp = (Task) this.listManager.get(listName).get(i);
            if(taskName.equals(temp.getTaskName()))
            {
                index = i;
                found = true;
            }
            else
            {
                index = -1;
            }
        }
        
        return index;
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
    
    public double getTotalTime(String listName)
    {
        double totalTime = 0; 
        if(!listManager.get(listName).isEmpty())
        {
            for(int i = 0; i < listManager.get(listName).size(); i++)
            {
                totalTime += listManager.get(listName).get(i).getAverageTime();
            }
        }
        
        return totalTime;
    }
    
    public ArrayList returnContents (String listName)
    {
        ArrayList<String> listContents = new ArrayList<String>();
        
        if(!listManager.get(listName).isEmpty())
        {
            for(int i = 0; i < listManager.get(listName).size(); i++)
            {
                Task temp = (Task)listManager.get(listName).get(i);
                listContents.add(temp.getTaskName() + ", " + temp.getAverageTime());
            }
        }
        
        return listContents;
    }
    
    public ArrayList returnTasks (String listName)
    {
        ArrayList<String> listContents = new ArrayList<String>();
        
        if(!listManager.get(listName).isEmpty())
        {
            for(int i = 0; i < listManager.get(listName).size(); i++)
            {
                Task temp = (Task)listManager.get(listName).get(i);
                listContents.add(temp.getTaskName());
            }
        }
        
        return listContents;
    }
}
