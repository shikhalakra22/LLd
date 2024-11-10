package model;

import jakarta.validation.constraints.AssertTrue;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.enums.Status;

import java.util.Arrays;
import java.util.List;

import static model.enums.Status.*;

@Getter
@Setter
@Builder
@ToString
public class SubTrack implements IValidStatus {
    private String title;
    private Status status;

    private final List<Status> allowedStatuses = Arrays.asList(OPEN, IN_PROGRESS, COMPLETED);

    @AssertTrue(message = "Invalid status")
    public boolean isValidStatus() {
        return allowedStatuses.contains(status);
    }

    public void setStatus(Status status) throws Exception {
        if(!allowedStatuses.contains(status)) {
            throw new Exception("Invalid status");
        }
        this.status = status;
    }
}
