package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Status;
import co.com.sofka.retoTrainingDDD.domain.Dojo.entities.Sensei;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DataInfo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Location;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Rule;

import java.util.List;

public class CreatedDojo extends DomainEvent {
    private final Sensei sensei;
    private final DataInfo dataInfo;
    private final List<Rule> rules;
    private final GroupGit groupGit;
    private final Location location;

    public CreatedDojo(Sensei sensei, DataInfo dataInfo, List<Rule> rules, GroupGit groupGit, Location location) {
        super("Dojo.CreatedDojo");
        this.sensei = sensei;
        this.dataInfo = dataInfo;
        this.rules = rules;
        this.groupGit = groupGit;
        this.location = location;
    }

    public Sensei getSensei() {
        return sensei;
    }

    public DataInfo getDataInfo() {
        return dataInfo;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public GroupGit getGroupGit() {
        return groupGit;
    }

    public Location getLocation() {
        return location;
    }
}
