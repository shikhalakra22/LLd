package model;

import exceptions.BadRequestException;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import model.enums.Status;

import java.util.List;
import java.util.Objects;

@SuperBuilder
@Getter
@Setter
public class StoryTask extends Task {
    private String storySummary;
    private List<SubTrack> subTrackList;
    public void addSubTrack(SubTrack subTrack) {
        if (Objects.equals(status, Status.COMPLETED)) {
            throw new BadRequestException("Cannot add subTrack to a completed story");
        }
        subTrackList.add(subTrack);
    }
}
