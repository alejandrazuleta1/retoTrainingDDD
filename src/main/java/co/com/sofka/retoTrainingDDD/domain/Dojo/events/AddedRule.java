package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Rule;

public class AddedRule extends DomainEvent {
    private final Rule rule;

    public AddedRule(Rule rule) {
        super("Dojo.AddedRule");
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
