package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Accomplishment;

public class AddedAccomplishmentToSensei extends DomainEvent {
    private final Accomplishment accomplishment;

    public AddedAccomplishmentToSensei(Accomplishment accomplishment) {
        super("Dojo.AddedAccomplishmentToSensei");
        this.accomplishment = accomplishment;
    }

    public Accomplishment getAccomplishment() {
        return accomplishment;
    }
}
