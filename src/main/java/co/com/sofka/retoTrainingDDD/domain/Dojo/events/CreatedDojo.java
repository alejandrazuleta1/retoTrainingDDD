package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DataInfo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Location;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Rule;

import java.util.List;

public class CreatedDojo extends DomainEvent {
    private final DojoId dojoId;
    private final DataInfo dataInfo;
    private final List<Rule> rules;
    private final GroupGit groupGit;
    private final Location location;

    public CreatedDojo(DojoId dojoId, DataInfo dataInfo, List<Rule> rules, GroupGit groupGit, Location location) {
        super("Dojo.CreatedDojo");
        this.dojoId = dojoId;
        this.dataInfo = dataInfo;
        this.rules = rules;
        this.groupGit = groupGit;
        this.location = location;
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
