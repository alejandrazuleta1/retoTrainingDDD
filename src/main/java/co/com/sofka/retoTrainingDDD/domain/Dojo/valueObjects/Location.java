package co.com.sofka.retoTrainingDDD.domain.Dojo.valueObjects;

import co.com.sofka.domain.generic.ValueObject;

public class Location implements ValueObject<Location.Propiedades> {
    private final String urlMeet;
    private final String location;
    private final String description;
    private final OpeningHours openingHours;

    public Location(String urlMeet, String location, String description, OpeningHours openingHours) {
        this.urlMeet = urlMeet;
        this.location = location;
        this.description = description;
        this.openingHours = openingHours;
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public String urlMeet() {
                return urlMeet;
            }

            @Override
            public String location() {
                return location;
            }

            @Override
            public String description() {
                return description;
            }

            @Override
            public OpeningHours openingHours() {
                return openingHours;
            }
        };
    }

    public interface Propiedades{
        String urlMeet();
        String location();
        String description();
        OpeningHours openingHours();
    }
}
