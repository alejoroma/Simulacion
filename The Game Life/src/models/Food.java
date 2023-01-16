package models;

public class Food {

    private int id;
    private int x;
    private int y;
    private int duration;
    private FoodState state;

    public Food(int id, int x, int y, int duration) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.duration = duration;
        this.state = FoodState.NOT_CONSUMED;
    }

    public void verifyDuration(){
        duration--;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDuration() {
        return duration;
    }

    public void consume() {
        this.state = FoodState.CONSUMED;
    }

    public FoodState getState() {
        return state;
    }
}

