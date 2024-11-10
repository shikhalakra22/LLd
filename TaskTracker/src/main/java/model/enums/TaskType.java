package model.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static model.enums.Status.*;
import static model.enums.Status.COMPLETED;

public enum TaskType {
    FEATURE, BUG, STORY;

    public List<Status> fetchAllowedStatuses() {
        switch (this) {
            case FEATURE:
                return Arrays.asList(OPEN, IN_PROGRESS, TESTING, DEPLOYED);
            case BUG:
                return Arrays.asList(OPEN, IN_PROGRESS, FIXED);
            case STORY:
                return Arrays.asList(OPEN, IN_PROGRESS, COMPLETED);
            default:
                return Collections.emptyList();
        }
    }
}
