package co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.retoTrainingDDD.domain.VOShared.Date;

public class Accomplishment implements ValueObject<Accomplishment.Propiedades> {
    private final String label;
    private final Integer point;
    private final Date date;

    public Accomplishment(String label, Integer point, Date date) {
        this.label = label;
        this.point = point;
        this.date = date;
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public String label() {
                return label;
            }

            @Override
            public Integer point() {
                return point;
            }

            @Override
            public Date date() {
                return date;
            }
        };
    }

    public interface Propiedades{
        String label();
        Integer point();
        Date date();
    }
}
