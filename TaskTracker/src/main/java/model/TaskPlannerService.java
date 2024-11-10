package model;

import model.enums.Status;
import model.enums.TaskType;

import java.util.Date;

public interface TaskPlannerService {
    Task createTask(TaskType type, String title, String creator, Date dueDate, String assignee) throws Exception;
    SubTrack createSubTrack(String title, Status status, StoryTask storyTask) throws Exception;
    <T extends IValidStatus> void changeStatus(T ticket, Status newStatus) throws Exception;
    void changeAssignee(Task task, String assignee);
    void displayUserTasks(String assignee);

}
