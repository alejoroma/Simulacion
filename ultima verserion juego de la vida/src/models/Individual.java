package models;

public class Individual {

    private int id;
    private Gender gender;
    private int energy;
    private StageOfLife stageOfLife;
    private int x;
    private int y;
    private int stepsToGo;
    private int direction;
    private int count;

    public Individual(int x, int y, int id, Gender gender, int energy, StageOfLife stageOfLife) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.gender = gender;
        this.energy = energy;
        this.stageOfLife = stageOfLife;
        count = 0;
        stepsToGo = 50;
        direction = (int)(Math.random() * 4) + 1;
    }

    public void move(){
        if(stageOfLife.getSpeedOfMovement() > 0){
            if(count >= (1000/(stageOfLife.getSpeedOfMovement() * 10))){
                if(stepsToGo == 0){
                    stepsToGo = 50;
                    direction = (int)(Math.random() * 4) + 1;
                }
                switch (direction){
                    case 1/*up*/:
                        moveUP();
                        break;
                    case 2/*down*/:
                        moveDown();
                        break;
                    case 3/*right*/:
                        moveRight();
                        break;
                    case 4/*left*/:
                        moveLeft();
                        break;
                }
            count = 0;
            }
        }
        count++;
    }

    public void moveRight(){
        x += 1;
        stepsToGo -= 1;
        verifyXCoordinates();
    }

    public void moveLeft(){
        x -= 1;
        stepsToGo -= 1;
        verifyXCoordinates();
    }

    public void moveUP(){
        y -= 1;
        stepsToGo -= 1;
        verifyYCoordinates();
    }

    public void moveDown(){
        y += 1;
        stepsToGo -= 1;
        verifyYCoordinates();
    }

    private void verifyXCoordinates(){
        if(x + Utilities.INDIVIDUAL_SIZE > Utilities.width){
            x = Utilities.width - Utilities.INDIVIDUAL_SIZE;
            direction = (int)(Math.random() * 4) + 1;
        }else if(x < 0){
            x = 0;
            direction = (int)(Math.random() * 4) + 1;
        }
    }

    private void verifyYCoordinates(){
        if(y + Utilities.INDIVIDUAL_SIZE > Utilities.height){
            y = Utilities.height - Utilities.INDIVIDUAL_SIZE;
            direction = (int)(Math.random() * 4) + 1;
        }else if(y < 0){
            y = 0;
            direction = (int)(Math.random() * 4) + 1;
        }
    }

    public void eat(){
        energy += 10;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public int getEnergy() {
        return energy;
    }

    public StageOfLife getStageOfLife() {
        return stageOfLife;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setStageOfLife(StageOfLife stageOfLife) {
        this.stageOfLife = stageOfLife;
    }
}
