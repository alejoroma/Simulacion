package models;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class GameManager {

    private ConcurrentHashMap<Integer, Individual> individuals;
    private ConcurrentHashMap<Integer, Food> food;
    private ArrayList<StageOfLife> stagesOfLife;
    private int individualsCount;
    private int foodDuration;
    private int foodCount;
    private int aux;

    public GameManager() {
        individuals = new ConcurrentHashMap<>();
        food = new ConcurrentHashMap<>();
        stagesOfLife = new ArrayList<>();
    }

    public void moveIndividuals() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1);
                        for (Individual individual : individuals.values()) {
                            individual.move();
                        }
                        verifyCollisions();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
    }

    public void initVerifyIndividualsCollisions() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
    }

    private void verifyFoodCollisions() {
        for (Food food1 : food.values()) {
            if (food1.getState().equals(FoodState.NOT_CONSUMED)) {
                Rectangle foodRec = new Rectangle(food1.getX(), food1.getY(), Utilities.FOOD_SIZE,
                        Utilities.FOOD_SIZE);
                for (Individual individual : individuals.values()) {
                    Rectangle individualRec = new Rectangle(individual.getX(), individual.getY(), Utilities.INDIVIDUAL_SIZE,
                            Utilities.INDIVIDUAL_SIZE);
                    if (individualRec.contains(foodRec)) {
                        individual.eat();
                        food1.consume();
                    }
                }
            }
        }
        deleteFoodConsume();
    }

    private void deleteFoodConsume() {
        ConcurrentHashMap<Integer, Food> aux = food;
        for (Integer key : aux.keySet()) {
            if (aux.get(key).getState().equals(FoodState.CONSUMED)) {
                food.remove(key);
            }
        }
    }

    public void addStageOfLife(StageOfLife stageOfLife) {
        stagesOfLife.add(stageOfLife);
    }

    public void generateInitialIndividuals(int xQuantity, int yQuantity) {
        generateXIndividuals(xQuantity);
        generateYIndividuals(yQuantity);
    }

    private void generateXIndividuals(int quantity) {
        int aux = 10;
        for (int i = 0; i < quantity; i++) {
            int x = (int) (Math.random() * Utilities.width - Utilities.INDIVIDUAL_SIZE);
            int y = (int) (Math.random() * Utilities.height - Utilities.INDIVIDUAL_SIZE);
            individuals.put(individualsCount, new Individual(x, y, individualsCount, Gender.X, aux,
                    stagesOfLife.get(2)));
            individualsCount++;
            aux += 2;
        }
    }

    private void generateYIndividuals(int quantity) {
        for (int i = 0; i < quantity; i++) {
            int x = (int) (Math.random() * Utilities.width);
            int y = (int) (Math.random() * Utilities.height);
            individuals.put(individualsCount, new Individual(x, y, individualsCount, Gender.Y, 30,
                    stagesOfLife.get(2)));
            individualsCount++;
        }
    }

    public void generateInitialFood(int quantity, int duration) {
        this.foodDuration = duration;
        for (int i = 0; i < quantity; i++) {
            int x = (int) (Math.random() * Utilities.width);
            int y = (int) (Math.random() * Utilities.height);
            food.put(foodCount, new Food(foodCount, x, y, duration));
            foodCount++;
        }
    }

    private void generateNewFood() {
        int x = (int) (Math.random() * Utilities.width);
        int y = (int) (Math.random() * Utilities.height);
        food.put(foodCount, new Food(foodCount, x, y, foodDuration));
        foodCount++;
    }

    public void verifyCollisions() {
        for(Integer individualKey : individuals.keySet()){
            for(Integer nextIndividualKey : individuals.keySet()){
                if (individuals.get(individualKey).getId() != individuals.get(nextIndividualKey).getId()) {
                    if (verifyCoordinates(individuals.get(individualKey).getX(), individuals.get(individualKey).getY(),
                            individuals.get(nextIndividualKey).getX(), individuals.get(nextIndividualKey).getY())) {
                        verifyCollisionConditions(individuals.get(individualKey), individuals.get(nextIndividualKey));
                    }
                }
            }
        }

        for (Individual individual : individuals.values()) {
            for (Individual nextIndividual : individuals.values()) {
                if (individual.getId() != nextIndividual.getId()) {
                    if (verifyCoordinates(individual.getX(), individual.getY(), nextIndividual.getX(), nextIndividual.getY())) {
                        verifyCollisionConditions(individual, nextIndividual);
                    }
                }
            }
        }
    }

    private boolean verifyCoordinates(int x1, int y1, int x2, int y2) {
        Rectangle rectangle = new Rectangle(x1, y1, Utilities.INDIVIDUAL_SIZE, Utilities.INDIVIDUAL_SIZE);
        return rectangle.contains(x2, y2) || rectangle.contains(x2 + Utilities.INDIVIDUAL_SIZE, y2)
                || rectangle.contains(x2, y2 + Utilities.INDIVIDUAL_SIZE) ||
                rectangle.contains(x2 + Utilities.INDIVIDUAL_SIZE, y2 + Utilities.INDIVIDUAL_SIZE);
    }

    private void verifyCollisionConditions(Individual individual1, Individual individual2) {
        if (individual1.getGender().equals(individual2.getGender())) {
            if (individual1.getGender().equals(Gender.X)) {
                verifyXCollisions(individual1, individual2);
            }
        } else {
            verifyXYCollisions(individual1, individual2);
        }
    }

    private void verifyXCollisions(Individual individual1, Individual individual2) {
        if (individual1.getEnergy() > individual2.getEnergy()) {
            individual2.setStageOfLife(stagesOfLife.get(3));
        } else {
            individual1.setStageOfLife(stagesOfLife.get(3));
        }
    }

    private void verifyXYCollisions(Individual individual1, Individual individual2) {
        if (individual1.getStageOfLife().getName().equals(stagesOfLife.get(2).getName()) && individual2.getStageOfLife().getName().
                equals(stagesOfLife.get(2).getName())) {
            generateNewIndividual();
            System.out.println("generacion de nuevo individuo");
        }
    }

    private void generateNewIndividual() {
        int x = (int) (Math.random() * Utilities.width);
        int y = (int) (Math.random() * Utilities.height);
        Gender gender = ((Math.random() * 2) + 1) == 1 ? Gender.X : Gender.Y;
        individuals.put(individualsCount, new Individual(x, y, individualsCount, gender, 20,
                stagesOfLife.get(0)));
        individualsCount++;
    }

    public int countIndividuals(Gender gender){
        int count = 0;
        for (Individual individual : individuals.values()){
            if(individual.getGender().equals(gender) && !individual.getStageOfLife().getName().equals(stagesOfLife.get(3).getName())){
                count++;
            }
        }
        return count;
    }

    public int[] generateStatistics(){
        return new int[]{countIndividuals(Gender.X), countIndividuals(Gender.Y), food.size()};
    }

    public ConcurrentHashMap<Integer, Individual> getIndividuals() {
        return individuals;
    }

    public ArrayList<StageOfLife> getStagesOfLife() {
        return stagesOfLife;
    }

    public ConcurrentHashMap<Integer, Food> getFood() {
        return food;
    }
}
