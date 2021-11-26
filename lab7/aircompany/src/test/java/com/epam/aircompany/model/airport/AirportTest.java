package com.epam.aircompany.model.airport;

import com.epam.aircompany.model.plane.ExperimentalPlane;
import com.epam.aircompany.model.plane.ClassificationLevel;
import com.epam.aircompany.model.plane.ExperimentalType;
import com.epam.aircompany.model.plane.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.aircompany.model.plane.MilitaryPlane;
import com.epam.aircompany.model.plane.PassengerPlane;
import com.epam.aircompany.model.plane.Plane;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AirportTest {
    private static final int NUMBER_OF_MILITARY_PLANES = 6;
    private static final int NUMBER_OF_BOMBER_MILITARY_PLANES = 3;

    private static final PassengerPlane PASSENGER_PLANE_WITH_MAX_PASSENGER_CAPACITY =
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

    private static final List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    private static final Airport airport = new Airport(planes);


    @Test
    public void takeMilitaryPlanes_shouldReturnListOfAllMilitaryPlanesFromPlanes_always() {
        Assert.assertTrue(airport.takeMilitaryPlanes().size() == NUMBER_OF_MILITARY_PLANES);
    }

    @Test
    public void takePassengerPlaneWithMaxPassengersCapacity_shouldReturnPassengerPlaneWithMaxPassengersCapacity_ifItPresents()
    {
        Assert.assertEquals(airport.takePassengerPlaneWithMaxPassengersCapacity(),
                PASSENGER_PLANE_WITH_MAX_PASSENGER_CAPACITY);
    }

    @Test
    public void sortPlanesByMaxLoadCapacity_shouldSortPlanesByMaxLoadCapacity_always() {
        Airport airport1 = new Airport(planes);
        Airport airport2 = new Airport(planes);
        airport1.sortPlanesByMaxLoadCapacity();
        airport2.getPlanes().sort(Comparator.comparing(Plane::getMaxLoadCapacity));
        Assert.assertEquals(airport1.getPlanes(), airport2.getPlanes());
    }

    @Test
    public void takeMilitaryPlanesByCertainType_shouldReturnListOfAllBombersFromPlanes_always() {
        Assert.assertTrue(airport.takeMilitaryPlanesByCertainType(MilitaryType.BOMBER).size()
                == NUMBER_OF_BOMBER_MILITARY_PLANES);

    }

    @Test
    public void takeExperimentalPlanesByCertainClassificationLevel_shouldReturnEmptyList_whenNoUnclassifiedPlanes() {
        Assert.assertTrue(new Airport(planes)
                .takeExperimentalPlanesByCertainClassificationLevel(ClassificationLevel.UNCLASSIFIED)
                .isEmpty());
    }
}
