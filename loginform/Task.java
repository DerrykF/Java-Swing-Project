package loginform;

public class Task {

    private String taskName;
    private String taskDescription;
    private String developerDetails;
    private double taskDuration;
    private String taskStatus = "To Do"; // Default status
    private int taskNumber;
    private String taskId;

    public Task(String taskName, String taskDescription, String developerDetails,
            double taskDuration, String taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskId = createTaskId();
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getTaskId() {
        return taskId;
    }

    public double getTaskDuration() {
        return taskDuration;
    }

    private String createTaskId() {
        String id = taskName.substring(0, 2).toUpperCase() + ":";
        id += taskNumber + ":";
        id += developerDetails.substring(developerDetails.length() - 3).toUpperCase();
        return id;
    }

    // if description is correct length return true
    public static boolean checkTaskDescription(String taskDesc) {
        if (taskDesc.length() <= 50) {
            return true;
        } else
            return false;
    }

    public String printTaskDetails() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Task Status: %s\n", getTaskStatus()))
                .append(String.format("Developer Details: %s\n", getDeveloperDetails()))
                .append(String.format("Task Number: %d\n", getTaskNumber()))
                .append(String.format("Task Name: %s\n", getTaskName()))
                .append(String.format("Task Description: %s\n", getTaskDescription()))
                .append(String.format("Task ID: %s\n", getTaskId()))
                .append(String.format("Task Duration: %.2f hours\n", getTaskDuration()));
        return sb.toString();
    }
}
