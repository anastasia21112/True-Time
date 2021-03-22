/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgtrue.time;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author angel
 */
public class Stopwatch extends Thread 
{
    //private long originalStartTime;
    private boolean started;
    private StopwatchActivity stopwatch;
    long originalStartTime; // first
    long recentStopTime;
    
    Stopwatch(StopwatchActivity activity)
    {
        stopwatch = activity;
        this.originalStartTime = System.currentTimeMillis();
        this.recentStopTime = 0;
        
    }
     Stopwatch(StopwatchActivity activity, long originalStartTime)
    {
        this(activity);
        this.originalStartTime = originalStartTime;
    }
            

    public void startThread()
    {
        //this.originalStartTime = System.currentTimeMillis();
        this.started = true;
        this.start();
    }

    public void run()
    {
        
        while(!this.stopwatch.isShutdown() && this.started)
        {
            if (this.stopwatch.isStopwatchRunning())
            {
                this.stopwatch.updateStopwatchTime();
                try
                {
                   
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(InterruptedException sleepError){System.out.println("exception"); break;}
            }  
            else
            {
                this.stopwatch.setStopwatchRunning(false);
            }
            
         
        }
    }


    public ArrayList<Integer> getTime()
    {
        long milliTime = System.currentTimeMillis() - originalStartTime;
        
        System.out.println(recentStopTime);
            
        ArrayList<Integer> time = new ArrayList<Integer>();
        
        time.add((int)(milliTime / 3600000      ));
        time.add((int)(milliTime / 60000        ) % 60);
        time.add((int)(milliTime / 1000         ) % 60);
        //time.add((int)(milliTime)                 % 1000);

        return time;
    }
    
    

    public void stopThread()
    {
        this.started = false;
        this.recentStopTime = System.currentTimeMillis();
        this.interrupt();
        
    }
    
    public long getStartTime()
    {
        return originalStartTime;
    }
    public void resetThread()
    {
        
    }
}
