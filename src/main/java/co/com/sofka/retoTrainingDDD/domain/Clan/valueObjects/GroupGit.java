package co.com.sofka.retoTrainingDDD.domain.Clan.valueObjects;

import co.com.sofka.domain.generic.ValueObject;

public class GroupGit implements ValueObject<String> {
    private final String groupGit;

    public GroupGit(String groupGit) {
        this.groupGit = groupGit;
    }

    @Override
    public String value() {
        return groupGit;
    }
}
