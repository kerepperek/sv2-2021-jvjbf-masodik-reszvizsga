package city;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public long getReservedArea() {
        long result = 0;
        for (Building building : buildings) {
            result += building.getFullArea();
        }
        return result;
    }

    public void addBuilding(Building building) {
        if (fullArea < getReservedArea() + building.getArea()) {
            throw new IllegalArgumentException("City can't be larger than " + fullArea);
        }
        buildings.add(building);
    }

    public Building findHighestBuilding() {
        int highestLevel = 0;
        Building result = buildings.get(0);

        for (Building building : buildings) {
            if (building.getLevels() > highestLevel) {
                result = building;
                highestLevel = building.getLevels();
            }
        }
        return result;
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building building : buildings) {
            if (building.getAddress().getStreet().equals(street)) {
                result.add(building);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        for (Building building : buildings) {
            if (building.calculateNumberOfPeopleCanFit() > numberOfPeople) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
