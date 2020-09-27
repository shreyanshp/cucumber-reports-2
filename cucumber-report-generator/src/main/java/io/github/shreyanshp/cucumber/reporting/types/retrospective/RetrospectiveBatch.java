package io.github.shreyanshp.cucumber.reporting.types.retrospective;

public class RetrospectiveBatch {
    private RetrospectiveModel[] models;

    public RetrospectiveBatch(RetrospectiveModel[] modelsValue) {
        super();
        this.models = modelsValue;
    }

    public RetrospectiveModel[] getModels() {
        return models;
    }
}
