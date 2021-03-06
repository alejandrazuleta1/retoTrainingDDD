package co.com.sofka.retoTrainingDDD.domain.Dojo.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.retoTrainingDDD.domain.VOShared.GroupGit;
import co.com.sofka.retoTrainingDDD.domain.Dojo.entities.Sensei;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DataInfo;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Location;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.Rule;

import java.util.List;

public class CrearDojo implements Command {
    private final DojoId dojoId;
    private final Sensei sensei;
    private final DataInfo dataInfo;
    private final List<Rule> rules;
    private final GroupGit groupGit;
    private final Location location;

    public CrearDojo(DojoId entityId, Sensei sensei, DataInfo dataInfo, List<Rule> rules, GroupGit groupGit, Location location) {
        this.dojoId = entityId;
        this.sensei = sensei;
        this.dataInfo = dataInfo;
        this.rules = rules;
        this.groupGit = groupGit;
        this.location = location;
    }

    public DojoId getDojoId() {
        return dojoId;
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
