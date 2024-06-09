package loginform;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.junit.jupiter.api.Test;

class TaskPageTest {

    @Test
    public void testTaskDescriptionLength_AboveLimit() {
        // Simulate user input with a description exceeding 50 characters
        String longDescription = "This is a task description that is longer than 50 characters.";

        // Mock an ActionEvent for the addTaskButton
        ActionEvent mockEvent = new ActionEvent(new JButton(), 0, "");

        // Create a TaskPage instance (partially mocked for testing)
        TaskPage taskPage = new TaskPage() {
            @Override
            public String getTaskDescription() {
                return longDescription;
            }
        };

        // Simulate button click and task creation
        taskPage.actionPerformed(mockEvent);

        // Assert that an error message is displayed for exceeding description length
        String expectedMessage = "Please enter a task description of less than 50 characters";
        assertTrue(JOptionPane.containsMessage(expectedMessage));
    }

    @Test
    public void testTaskDescriptionLength_Valid() {
        // Simulate user input with a valid description (less than 50 characters)
        String validDescription = "This is a valid description.";

        // Mock an ActionEvent for the addTaskButton
        ActionEvent mockEvent = new ActionEvent(new JButton(), 0, "");

        // Create a TaskPage instance (partially mocked for testing)
        TaskPage taskPage = new TaskPage() {
            @Override
            public String getTaskDescription() {
                return validDescription;
            }
        };

        // Simulate button click and task creation
        taskPage.actionPerformed(mockEvent);

        // No assertion needed here, as no error messages are expected
    }

    @Test
    public void testTotalTaskDuration_Accumulation() {
        // Set up task data with durations
        double task1Duration = 2.5;
        double task2Duration = 1.75;

        // Mock ActionEvents for adding two tasks
        ActionEvent mockEvent1 = new ActionEvent(new JButton(), 0, "");
        ActionEvent mockEvent2 = new ActionEvent(new JButton(), 0, "");

        // Create a TaskPage instance (partially mocked for testing)
        TaskPage taskPage = new TaskPage() {
            @Override
            public double getTaskDuration() {
                if (taskCount == 0) {
                    return task1Duration;
                } else {
                    return task2Duration;
                }
            }
        };

        // Simulate adding two tasks
        taskPage.actionPerformed(mockEvent1);
        taskPage.actionPerformed(mockEvent2);

        // Calculate expected total duration
        double expectedTotalDuration = task1Duration + task2Duration;

        // Assert that the total duration is accumulated correctly
        assertEquals(expectedTotalDuration, taskPage.returnTotalHours(), 0.01);
    }

    @Test
    public void testTaskId_Format() {
        // Simulate task data for creating a Task object
        String taskName = "SampleTask";
        String developerDetails = "John Doe";
        String expectedTaskId = "SA:0:DOE"; // Based on the logic in createTaskId

        // Create a Task object
        Task task = new Task(taskName, "", developerDetails, 0, "");

        // Assert that the generated task ID matches the expected format
        assertEquals(expectedTaskId, task.getTaskId());
    }
}
