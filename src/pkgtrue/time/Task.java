
package pkgtrue.time;

public class Task {
    
    private String taskName;
    private Double averageTime;
    public static MasterTaskManager masterManager = new MasterTaskManager();
    
    public Task (String name, Double time)
    {
        masterManager.addMasterTask(name, time);
        this.taskName = name;
        this.averageTime = masterManager.calculateAverageTime(name, time);
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(Double averageTime) {
        this.averageTime = averageTime;
    }
    
    
}
