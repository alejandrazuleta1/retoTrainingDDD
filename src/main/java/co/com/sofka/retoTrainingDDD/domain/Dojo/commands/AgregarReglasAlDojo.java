package co.com.sofka.retoTrainingDDD.domain.Dojo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Rule;

import java.util.List;

public class AgregarReglasAlDojo implements Command {
    private final DojoId dojoId;
    private final List<Rule> rules;

    public AgregarReglasAlDojo(DojoId dojoId, List<Rule> rules) {
        this.dojoId = dojoId;
        this.rules = rules;
    }

    public DojoId getDojoId() {
        return dojoId;
    }

    public List<Rule> getRules() {
        return rules;
    }
}
