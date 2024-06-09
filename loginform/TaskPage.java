package loginform;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class TaskPage implements ActionListener {

    private JFrame frame;
    private JLabel welcomeMessage;
    private JButton addTaskButton, showReportButton, quitButton;
    private int taskLimit, taskCount = 0;
    private int totalTaskDuration = 0;

    public TaskPage() {
        // Welcome message
        welcomeMessage = new JLabel("Welcome to EasyKanban");
        welcomeMessage.setBounds(150, 50, 200, 25);


        // Menu buttons
        addTaskButton = new JButton("1. Add Tasks");
        addTaskButton.setBounds(50, 150, 200, 25);
        addTaskButton.addActionListener(this);

        showReportButton = new JButton("2. Show Report");
        showReportButton.setBounds(250, 150, 200, 25);
        showReportButton.addActionListener(this);

        quitButton = new JButton("3. Quit");
        quitButton.setBounds(150, 200, 150, 25);
        quitButton.addActionListener(this);

        // Frame setup
        frame = new JFrame("EasyKanban");
        frame.add(welcomeMessage);
        frame.add(addTaskButton);
        frame.add(showReportButton);
        frame.add(quitButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addTaskButton) {
            taskLimit = getNumberOfTasks();
            if (taskCount >= taskLimit) {
                JOptionPane.showMessageDialog(frame,
                        "Task limit reached. No more tasks can be added.");
                return;
            }
            while (taskCount < taskLimit) {


                String taskName = getTaskName();
                String taskDescription = getTaskDescription();
                String developerDetails = getDeveloperDetails();
                double taskDuration = getTaskDuration();
                String taskStatus = getTaskStatus();
                Task latestTask = new Task(taskName, taskDescription, developerDetails,
                        taskDuration, taskStatus);
                taskCount++;
                totalTaskDuration += taskDuration;
                latestTask.printTaskDetails();
            }
            displayTotalTaskDuration(returnTotalHours());
        } else if (e.getSource() == showReportButton) {
            JOptionPane.showMessageDialog(frame, "Coming Soon");
            return;

        } else if (e.getSource() == quitButton) {
            frame.dispose();
        }
    }


    private String getTaskStatus() {
        String[] taskStatusOptions = {"To Do", "Done", "Doing"};
        JComboBox<String> statusComboBox = new JComboBox<>(taskStatusOptions);
        statusComboBox.setSelectedIndex(0); // Default selection "To Do"

        int selection = JOptionPane.showConfirmDialog(frame, statusComboBox, "Select Task Status",
                JOptionPane.OK_CANCEL_OPTION);
        if (selection == JOptionPane.OK_OPTION) {
            return (String) statusComboBox.getSelectedItem();
        } else {
            return null;
        }
    }

    private int getNumberOfTasks() {
        String numberTasksStr = JOptionPane.showInputDialog(frame, "Enter the number of tasks: ");
        return Integer.parseInt(numberTasksStr);
    }


    private String getTaskName() {
        String taskName = JOptionPane.showInputDialog(frame, "Enter task name:");
        return taskName;
    }

    private String getTaskDescription() {
        String taskDescription =
                JOptionPane.showInputDialog(frame, "Enter task description (max 50 characters):");
        if (!Task.checkTaskDescription(taskDescription)) {
            JOptionPane.showMessageDialog(frame,
                    "Please enter a task description of less than 50 characters");
            return getTaskDescription();
        } else {
            JOptionPane.showMessageDialog(frame, "Task successfully captured");
        }
        return taskDescription;
    }

    private int returnTotalHours() {
        return totalTaskDuration;
    }

    private String getDeveloperDetails() {
        String developerDetails = JOptionPane.showInputDialog(frame,
                "Enter developer details (First and Last Name):");
        return developerDetails;
    }

    private double getTaskDuration() {
        String durationStr = JOptionPane.showInputDialog(frame, "Enter task duration (hours):");
        try {
            return Double.parseDouble(durationStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input: Please enter a number");
            return getTaskDuration();
        }
    }


    private void displayTotalTaskDuration(double totalDuration) {
        String message = String.format("Total Duration: %.2f hours\n", totalDuration);
        JOptionPane.showMessageDialog(frame, message, "Total Task Duration",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
