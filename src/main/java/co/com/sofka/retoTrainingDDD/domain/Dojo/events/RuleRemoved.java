package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Rule;

public class RuleRemoved extends DomainEvent {
    private final Rule rule;

    public RuleRemoved(Rule rule) {
        super("Dojo.RuleRemoved");
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
