package repository;

import lombok.Getter;
import lombok.NoArgsConstructor;
import model.Sprint;
import model.Task;

import java.util.Map;

@NoArgsConstructor
@Getter
public class Db {
    private Map<String, Sprint> sprintRepository;
    private Map<String, Task> taskRepository;
}
