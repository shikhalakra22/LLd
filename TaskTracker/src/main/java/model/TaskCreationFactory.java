package model;

import model.enums.TaskType;

public class TaskCreationFactory {

    public Task.TaskBuilder<?, ?> generateTask(TaskType taskType) throws Exception {
        switch (taskType) {
            case BUG:
                return BugTask.builder().type(TaskType.BUG);
            case FEATURE:
                return FeatureTask.builder().type(TaskType.FEATURE);
            case STORY:
                return StoryTask.builder().type(TaskType.STORY);
            default:
                throw new Exception("Invalid taskType provided");
        }
    }
}
