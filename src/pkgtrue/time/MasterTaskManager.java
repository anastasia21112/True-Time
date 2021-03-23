
 /* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;
import java.util.ArrayList;
import java.util.HashMap;

public class MasterTaskManager
{
    //Todo: discuss having reading and writing in this class, and use list manager to just add stuff to UI
    public static ListManager listManager;
    public static HashMap<String, ArrayList<Double>> allTasks = new HashMap<String, ArrayList<Double>>();
   

    public MasterTaskManager()
    {
        
        
    }

 
    public void addMasterTask(String taskName, Double time)
    {
        if(this.allTasks.containsKey(taskName))
        {
            ArrayList<Double> durations = getDurations(taskName);
            durations.add(time);
            this.allTasks.put(taskName, durations);
        }
        else
        {
            ArrayList<Double> durations = new ArrayList<>();
            durations.add(time);
            this.allTasks.put(taskName, durations);
        }
    }
    
   public ArrayList<Double> getDurations(String taskName)
   {
       
       for(HashMap.Entry entry : allTasks.entrySet())
        {
            String key = (String) entry.getKey();
            ArrayList<Double> value = (ArrayList<Double>) entry.getValue();
            if(taskName.equals(key))
            {
                return value; 
            }
        }
       return new ArrayList<Double>();
   }
   
   
   
   public double calculateAverageTime(String taskName, Double taskTime)
   {
        ArrayList<Double> temp = getDurations(taskName);

        double sum = 0.0;
        double average = 0.0;

        if(!temp.isEmpty())
        {
            for(int i = 0; i < temp.size(); i++)
            {
                sum += temp.get(i);
            }
            
            average = sum/temp.size();
        }
        else
        {
            average = taskTime;
        }
            
        average = (double)Math.round(average * Math.pow(10, 2)) / Math.pow(10, 2);

        return average;
   }
   
   

    public String toString()
    {
        String str = "";

        for(String taskName: allTasks.keySet())
        {
            str += taskName + " : " + allTasks.get(taskName) + ",\n";

        }

        return str;
    }
}

