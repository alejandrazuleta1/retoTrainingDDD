package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.entities.Kata;

public class AddedKata extends DomainEvent {
    private final Kata kata;

    public AddedKata(Kata kata) {
        super("Challenge.AddedKata");
        this.kata = kata;
    }

    public Kata getKata() {
        return kata;
    }
}
