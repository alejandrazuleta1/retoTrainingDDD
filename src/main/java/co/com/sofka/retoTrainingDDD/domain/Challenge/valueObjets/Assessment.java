package co.com.sofka.retoTrainingDDD.domain.Challenge.valueObjets;

import co.com.sofka.domain.generic.ValueObject;

public class Assessment implements ValueObject<Assessment.Propiedades> {
    private final int degreeOfDifficulty;
    private final String repoUrl;
    private final String summary;

    public Assessment(int degreeOfDifficulty, String repoUrl, String summary) {
        this.degreeOfDifficulty = degreeOfDifficulty;
        this.repoUrl = repoUrl;
        this.summary = summary;
    }

    @Override
    public Propiedades value() {
        return new Propiedades() {
            @Override
            public int degreeOfDifficulty() {
                return degreeOfDifficulty;
            }

            @Override
            public String repoUrl() {
                return repoUrl;
            }

            @Override
            public String summary() {
                return summary;
            }
        };
    }

    public interface Propiedades{
        int degreeOfDifficulty();
        String repoUrl();
        String summary();
    }
}
