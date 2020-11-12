package co.com.sofka.retoTrainingDDD.domain.Challenge.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets.Assessment;

public class AssignedAssessment extends DomainEvent {
    private final Assessment assessment;

    public AssignedAssessment(Assessment assessment) {
        super("Challenge.AssignedAssessment");
        this.assessment = assessment;
    }

    public Assessment getAssessment() {
        return assessment;
    }
}
