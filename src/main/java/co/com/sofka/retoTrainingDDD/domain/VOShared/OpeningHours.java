package co.com.sofka.retoTrainingDDD.domain.VOShared;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.retoTrainingDDD.domain.Dojo.Frecuency;

public class OpeningHours implements ValueObject<OpeningHours.Propiedades> {
    private final int hourStar;
    private final int hourEnd;
    private final Frecuency frecuency;

    public OpeningHours(int hourStar, int hourEnd, Frecuency frecuency) {
        this.hourStar = hourStar;
        this.hourEnd = hourEnd;
        this.frecuency = frecuency;
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public int hourStar() {
                return hourStar;
            }

            @Override
            public int hourEnd() {
                return hourEnd;
            }

            @Override
            public Frecuency frecuency() {
                return frecuency;
            }
        };
    }

    public interface Propiedades{
        int hourStar();
        int hourEnd();
        Frecuency frecuency();
    }
}
