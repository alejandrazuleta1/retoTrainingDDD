package co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects;

import co.com.sofka.domain.generic.ValueObject;

public class DataInfo implements ValueObject<DataInfo.Propiedades> {
    private final String name;
    private final String legend;

    public DataInfo(String name, String legend) {
        this.name = name;
        this.legend = legend;
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String legend() {
                return legend;
            }
        };
    }

    public interface Propiedades{
        String name();
        String legend();
    }
}
