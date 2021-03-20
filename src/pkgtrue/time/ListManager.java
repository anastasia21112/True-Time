/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class ListManager {


    public static HashMap<String, HashMap<String, Double>> listManager;

    public ListManager(String fileName)
    {

        // TODO: if there is a file with all of information, use it to repopulate the lust
        //this.listManager = this.parseListManager(this.getJSON(context, fileName));
        //this.allTasks = this.parseAllTasks(this.getJSON(context, fileName));
        this();
    }
    public ListManager()
    {
        listManager = new HashMap<String, HashMap<String, Double>>();
    }
    //TODO: figure out how to parse information to list
    /*
        Structure:
        HashMap for each list
            list: HashMap with each task and it's average time of completion

        Example:
        {
            "list 1": {
                {
                    "eat breakfast": 30,
                    "clean room": 45
                }
            },

            "list 2": {

            }

        }

    */

    public boolean containsTask(String taskName)
    {
        for(String list: this.listManager.keySet())
        {
            if(this.listManager.get(list).containsKey(taskName)) //if a list has a task, return true
                return true;
        }
        return false;
    }
    public void addTaskToList(String taskName, double averagedTime, String listName)
    {

         if(this.listManager.containsKey(listName)) //if the list exists
            {
                this.listManager.get(listName).put(taskName, averagedTime); // then find the list and add a new task with the averaged time
            }

    }
    public void removeTaskFromList(String taskName, String listName)
    {

        if(this.listManager.containsKey(listName)) //if the list exists
        {
            this.listManager.get(listName).remove(taskName); // then find the list and remove the desired task
        }

    }
    public Double getTaskTime(String listName, String taskName)
    {
        if(this.listManager.containsKey(listName)) //if the list exists
            {
               if(this.listManager.get(listName).containsKey(taskName))
               {
                   return this.listManager.get(listName).get(taskName);
               }
            }


        return null;
    }



    // Write to list manager file
    // Writes to file in this format
    // listName1 \t taskName1 \t taskTime1 \t taskName2 \t taskTime2 \t \n
    // listName2 \t taskName1 \t taskTime1 \t taskName2 \t taskTime2 \t \n
    public void saveToTaskFile(String filePath) throws IOException
    {
        FileWriter writer = new FileWriter(filePath);

        writer.write(tabSeparateListManager());

        writer.close();
    }

    public String tabSeparateListManager()
    {
        String contents = "";
        Set<String> listNames = this.listManager.keySet();
        Object[] keyArray = listNames.toArray();
        ArrayList<String> keyArrayList = new ArrayList<String>();
        for(int i = 0; i < keyArray.length; i++)
        {
            keyArrayList.add((String) keyArray[i]);
        }

        for(int i = 0; i < keyArrayList.size(); i++)
        {
            String keyName = keyArrayList.get(i);

            contents = contents + keyName + "\t";

            for(int j = 0; j < listManager.get(keyName).size(); j++)
            {
                Set<String> taskNames = this.listManager.get(keyName).keySet();
                Object[] taskKeyArray = taskNames.toArray();
                ArrayList<String> taskKeyArrayList = new ArrayList<String>();
                for(int k = 0; k < taskKeyArray.length; k++)
                {
                    taskKeyArrayList.add((String) keyArray[k]);
                }

                for(int m = 0; m < taskKeyArrayList.size(); m++)
                {
                    String taskName = taskKeyArrayList.get(m);

                    contents = contents + taskName + "\t";
                    contents = contents + listManager.get(taskName).get(m) + "\t";
                }
            }
            contents = contents + "\n";
        }

        return contents;
    }

    // Reads information from the tab file
    // Inputs information into the hashmaps to be displayed when application opens
    public void readfromListManagerFile(String filePath) throws FileNotFoundException
    {
        File myFile = new File(filePath);
        Scanner reader = new Scanner(myFile);

        while(reader.hasNextLine())
        {
            String nextLine = reader.nextLine();
            try
            {
                readListManagerLine(nextLine);
            }
            catch (Exception e) {}
        }

        reader.close();
    }

    // Reads tab separated information and inputs information into correct hashmap
    public void readListManagerLine(String singleFileLine) throws IOException
    {
        // The first item in the list is always the name of the list
        int firstTabIndex = singleFileLine.indexOf("\t");
        String listName = singleFileLine.substring(0,firstTabIndex);
        HashMap<String,Double> taskInformation = new HashMap<String,Double>();

        String remainingInfo = singleFileLine.substring(firstTabIndex + 1);

        //Turn string into char array to be read one at a time
        char[] stringCharacters = new char[remainingInfo.length()];

        for (int i = 0; i < remainingInfo.length(); i++) {
            stringCharacters[i] = remainingInfo.charAt(i);
        }

        // Tab counter counts how many time a tab has been read in the file
        // When the second tab is reached this indicates all information for a single task and can be put in the hashmap
        int tabCounter = 0;
        String taskString = "";

        for(int i = 0; i < stringCharacters.length; i++)
        {
            Character character = stringCharacters[i];
            taskString = taskString + character;

            if (character.equals('\t'))
            {
                tabCounter++;
                if (tabCounter % 2 == 0)
                {
                    String delimiter = "[\t]";
                    String[] tokens = taskString.split(delimiter, 2);
                    String taskName = tokens[0];
                    Double averageTime = Double.parseDouble(tokens[1]);

                    taskInformation.put(taskName, averageTime);
                    taskString = "";
                }

            }
        }

        listManager.put(listName, taskInformation);
    }

}