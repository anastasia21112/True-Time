
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
    public static HashMap<String, ArrayList<Double>> allTasks;

    public MasterTaskManager()
    {
        allTasks = new HashMap<String, ArrayList<Double>>();
    }

    public void addTask(String taskName, Double time,String listName)
    {
        if(this.allTasks.containsKey(listName))
        {
            if(this.listManager.containsTask(taskName)) //if the task already exists, add it to the list manager after facotring the newest estimate into the predicted time
            {
                ArrayList<Double> timesForTask = allTasks.get(taskName);
                timesForTask.add(time);
                this.listManager.addTaskToList(taskName, average(timesForTask),listName);
                return;
            }
            else // if the task is new, add it to the allTasks list and then the list manager
            {
                allTasks.put(taskName, new ArrayList<Double>());
                allTasks.get(taskName).add(time);

                this.listManager.addTaskToList(taskName, time,listName);
            }
        }
    }

    public void removeTask(String taskName, String listName)
    {
        if(this.allTasks.containsKey(taskName))
        {
            this.listManager.removeTaskFromList(taskName, listName);

        }
    }

    public Double average(ArrayList<Double> taskTimes)
    {
        Double total = new Double (0);
        for(Double time: taskTimes)
            total += time;

        return total / taskTimes.size();
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

