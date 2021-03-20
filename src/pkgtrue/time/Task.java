
package pkgtrue.time;

public class Task {
    
    private String taskName;
    private Double averageTime;
    
    public Task (String name, Double time)
    {
        this.taskName = name;
        this.averageTime = time;
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
