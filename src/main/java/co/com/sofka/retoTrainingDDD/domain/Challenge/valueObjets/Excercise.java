package co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Map;

public class Excercise implements ValueObject<Excercise.Propiedades> {
    private final int level;
    private final Map<Object,Object> metadata;
    private final String goal;

    public Excercise(int level, Map<Object, Object> metadata, String goal) {
        this.level = level;
        this.metadata = metadata;
        this.goal = goal;
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public int level() {
                return level;
            }

            @Override
            public Map<Object, Object> metadata() {
                return metadata;
            }

            @Override
            public String goal() {
                return goal;
            }
        };
    }

    public interface Propiedades{
        int level();
        Map<Object,Object> metadata();
        String goal();
    }
}
