package co.com.sofka.retoTrainingDDD.domain.VOShared;

import co.com.sofka.domain.generic.ValueObject;

public class GroupGit implements ValueObject<GroupGit.Propiedades> {
    private final Integer groupId;
    private final Path path;
    private final Name name;

    public GroupGit(Integer groupId, Path path, Name name) {
        this.groupId = groupId;
        this.path = path;
        this.name = name;
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public Integer groupId() {
                return groupId;
            }

            @Override
            public Path path() {
                return path;
            }

            @Override
            public Name name() {
                return name;
            }
        };
    }

    public interface Propiedades{
        Integer groupId();
        Path path();
        Name name();
    }
}
