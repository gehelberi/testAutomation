package com.epam.aircompany.model.plane;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType type;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getType() {
        return type;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }
}
