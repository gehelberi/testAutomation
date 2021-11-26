package com.epam.aircompany.model.airport;

import com.epam.aircompany.model.plane.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Airport {
    private final List<Plane> planes;

    public Airport(List<Plane> planes) {
        this.planes = planes;
    }

    public List<Plane> getPlanes() {
        return planes;
    }

    public List<PassengerPlane> takePassengerPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof PassengerPlane)
                .map(plane -> (PassengerPlane) plane)
                .collect(Collectors.toList());
    }

    public PassengerPlane takePassengerPlaneWithMaxPassengersCapacity() {
        return Collections.max(takePassengerPlanes(), Comparator.comparing(PassengerPlane::getPassengersCapacity));
    }

    public List<MilitaryPlane> takeMilitaryPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof MilitaryPlane)
                .map(plane -> (MilitaryPlane) plane)
                .collect(Collectors.toList());
    }

    public List<MilitaryPlane> takeMilitaryPlanesByCertainType(MilitaryType militaryType) {
        return takeMilitaryPlanes().stream()
                .filter(plane -> plane.getType().equals(militaryType))
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> takeExperimentalPlanes() {
        return planes.stream()
                .filter(plane -> plane instanceof ExperimentalPlane)
                .map(plane -> (ExperimentalPlane) plane)
                .collect(Collectors.toList());
    }

    public List<ExperimentalPlane> takeExperimentalPlanesByCertainClassificationLevel(ClassificationLevel classificationLevel) {
        return takeExperimentalPlanes().stream()
                .filter(plane -> plane.getClassificationLevel().equals(classificationLevel))
                .collect(Collectors.toList());
    }

    public void sortPlanesByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMaxLoadCapacity));
    }


}
