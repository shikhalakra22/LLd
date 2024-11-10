package model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class Sprint {
    private String name;
    private List<Task> tasks;

    public void displaySprintSnapshot() {
        System.out.println("Sprint: " + name);
        for (Task task : tasks) {
            System.out.println("Task: " + task.getTitle() + ", Status: " + task.getStatus() + ", On Track: " + (new Date().before(task.getDueDate())));
        }
    }
}
