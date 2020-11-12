package co.com.sofka.retoTrainingDDD.domain.Dojo.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects.DataInfo;

public class ChangedDataInfo extends DomainEvent {
    private final DataInfo dataInfo;

    public ChangedDataInfo(DataInfo dataInfo) {
        super("Dojo.ChangedDataInfo");
        this.dataInfo = dataInfo;
    }

    public DataInfo getDataInfo() {
        return dataInfo;
    }
}
