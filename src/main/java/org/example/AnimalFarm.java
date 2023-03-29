package org.example;

import java.util.*;

public class AnimalFarm {
    private List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    public Map<Animal, Integer> countedAnimals() {
        Map<Animal, Integer> animalMap = new HashMap<>();

        for (String farmAnimal : farmAnimals) {
            Animal animal;
            try {
                animal = Animal.valueOf(farmAnimal.split(" ")[0].toUpperCase());
                Integer currentNumber = animalMap.get(animal);
                animalMap.put(animal, currentNumber == null ? 1 : currentNumber + 1);
            } catch (Exception e) {
                System.out.printf("Please correct string %s. Incorrect input data. %n", farmAnimal);
            }
        }
        return animalMap;
    }

    public Set<String> uniqueNames() {
        Set<String> uniqueNames = new HashSet<>();

        for (String farmAnimal : farmAnimals) {
            String name;
            try {
                name = farmAnimal.split(" ")[1];
                uniqueNames.add(name);
            } catch (Exception e) {
                System.out.printf("Please correct string %s. Incorrect input data. %n", farmAnimal);
            }
        }
        return uniqueNames;
    }

    public void addFarmAnimal(Animal animal, String name) {
        farmAnimals.add(animal.name() + " " + name);
    }

    public void addFarmAnimal(Animal animal) {
        farmAnimals.add(animal.name() + " N");
    }

    public void addFarmAnimal(String name) {
        farmAnimals.add(Animal.NOT_DEFINED + " " + name);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String farmAnimal : farmAnimals) {
            String printFarmAnimal = farmAnimal.replace(" ", ":");
            stringBuilder.append(printFarmAnimal).append("\n");
        }

        return stringBuilder.toString();
    }

} 