package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;

public class EvaluatedClan extends DomainEvent {
    //TODO definir los parámetros necesarios
    public EvaluatedClan() {
        super("Dojo.EvaluatedClan");
    }
}
