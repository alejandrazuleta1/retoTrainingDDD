package co.com.sofka.retoTrainingDDD.domain.Dojo;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.retoTrainingDDD.domain.Dojo.entities.Sensei;
import co.com.sofka.retoTrainingDDD.domain.Dojo.events.*;

public class DojoEventChange extends EventChange {
    public DojoEventChange(Dojo dojo) {
        apply((AddedAccomplishmentToSensei addedAccomplishmentToSensei) -> {
            dojo.sensei.addAccomplishment(addedAccomplishmentToSensei.getAccomplishment());
        });

        apply((AddedRule addedRule) -> {
            dojo.rules.add(addedRule.getRule());
        });

        apply((AssignedSensei assignedSensei) -> {
            dojo.sensei = new Sensei(assignedSensei.getSenseiId(), assignedSensei.getName(), assignedSensei.getPersonId(), assignedSensei.getSpecialty(), assignedSensei.getMemberGit(), assignedSensei.getAccomplishmentList());
        });

        apply((ChangedDataInfo changedDataInfo) -> {
            dojo.dataInfo = changedDataInfo.getDataInfo();
        });

        apply((CreatedDojo createdDojo) -> {
            dojo.status = Status.CLOSED;
            dojo.dataInfo = createdDojo.getDataInfo();
            dojo.rules = createdDojo.getRules();
            dojo.groupGit = createdDojo.getGroupGit();
            dojo.location = createdDojo.getLocation();
        });

        apply((DojoStatusChanged dojoStatusChanged) -> {
            dojo.status = dojoStatusChanged.getStatus();
        });

        apply((RuleRemoved ruleRemoved)->{
            dojo.rules.removeIf(rule -> rule.equals(ruleRemoved.getRule()));
        });

        apply((UpdatedDataSensei updatedDataSensei)->{
            dojo.sensei.update(updatedDataSensei.getName(), updatedDataSensei.getPersonId(), updatedDataSensei.getSpecialty(), updatedDataSensei.getMemberGit(), updatedDataSensei.getAccomplishmentList());
        });
    }
}
