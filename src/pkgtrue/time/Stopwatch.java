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
    //private long startTime;
    private boolean started;
    private StopwatchActivity stopwatch;
    
    Stopwatch(StopwatchActivity activity)
    {
        stopwatch = activity;
    }
            

    public void startThread()
    {
        //this.startTime = System.currentTimeMillis();
        this.started = true;
        this.start();
    }

    public void run()
    {
        while(!this.stopwatch.isShutdown())
        {
            if (this.stopwatch.isStopwatchRunning())
            {
                this.stopwatch.updateStopwatchTime();
                try
                {
                    //stopwatch.sleep(100);
                    TimeUnit.SECONDS.sleep(1);
                }
                catch(InterruptedException sleepError){System.out.println("exception");}
            }           
        }
    }


    public ArrayList<Integer> getTime(long startTime)
    {
        long milliTime = System.currentTimeMillis() - startTime;
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
        
    }
    
    public void resetThread()
    {
        
    }
}
