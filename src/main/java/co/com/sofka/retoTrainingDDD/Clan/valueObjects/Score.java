package co.com.sofka.retoTrainingDDD.Clan.valueObjects;

import co.com.sofka.domain.generic.ValueObject;
import co.com.sofka.retoTrainingDDD.Dojo.valueObjects.DojoId;
import co.com.sofka.retoTrainingDDD.VOShared.Date;

public class Score implements ValueObject<Score.Propiedades> {
    private final Integer point;
    private final DojoId dojoId;
    private final Date date;

    public Score(Integer point, DojoId dojoId, Date date) {
        this.point = point;
        this.dojoId = dojoId;
        this.date = date;
    }

    @Override
    public Score.Propiedades value() {
        return new Propiedades() {
            @Override
            public Integer point() {
                return point;
            }

            @Override
            public DojoId dojoId() {
                return dojoId;
            }

            @Override
            public Date date() {
                return date;
            }
        };
    }

    public interface Propiedades{
        Integer point();
        DojoId dojoId();
        Date date();
    }
}
