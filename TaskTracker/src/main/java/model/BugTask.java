package model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.enums.Severity;
@SuperBuilder
@Getter
@Setter
public class BugTask extends Task {
    private Severity severity;
}
