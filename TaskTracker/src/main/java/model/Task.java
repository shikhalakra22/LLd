package model;

import jakarta.validation.constraints.AssertTrue;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.enums.Status;
import model.enums.TaskType;

import java.util.Date;

@SuperBuilder
@Getter
@Setter
public class Task implements IValidStatus {
    protected String title;
    protected String creator;
    protected String assignee;
    protected Status status;
    protected TaskType type;
    protected Date dueDate;

    @AssertTrue(message = "Invalid status")
    public boolean isValidStatus() {
        BugTask.BugTaskBuilder<?, ?> builder = BugTask.builder();
        return type.fetchAllowedStatuses().contains(status);
    }

    public void setStatus(Status status) throws Exception {
        if(!type.fetchAllowedStatuses().contains(status)) {
            throw new Exception("Invalid Status");
        }
        this.status = status;
    }
}
