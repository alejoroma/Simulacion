package models;

public class StageOfLife {

    private String name;
    private int speedOfMovement;
    private int duration;
    private int energyConsumption;

    public StageOfLife(String name, int speedOfMovement, int duration, int energyConsumption){
        this.name = name;
        this.speedOfMovement = speedOfMovement;
        this.duration = duration;
        this.energyConsumption = energyConsumption;
    }

    public String getName() {
        return name;
    }

    public int getSpeedOfMovement() {
        return speedOfMovement;
    }

    public int getDuration() {
        return duration;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }
}
