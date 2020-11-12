package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;

public class ChangedDurationDays extends DomainEvent {
    private final Integer durationDays;

    public ChangedDurationDays(Integer durationDays) {
        super("Challenge.ChangedDurationDays");
        this.durationDays = durationDays;
    }

    public Integer getDurationDays() {
        return durationDays;
    }
}
