package co.com.sofka.retoTrainingDDD.domain.Clan.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.Color;

public class AppliedColor extends DomainEvent {
    private final Color color;

    public AppliedColor(Color color) {
        super("Clan.AppliedColor");
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
