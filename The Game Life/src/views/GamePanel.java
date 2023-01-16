package views;

import models.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private GameManager game;
    private int width;
    private int height;

    public GamePanel(int width, int height) {
        this.width = width;
        this.height = height;
        setBackground(Color.WHITE);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        paintFood(g2);
        paintIndividuals(g2);
        paintStatistics(g2);
    }

    private void paintIndividuals(Graphics2D g2){
            g2.drawRect(0,0,width, height);
        if(game != null){
            for(Individual individual : game.getIndividuals().values()){
               if(!individual.getStageOfLife().getName().equals(game.getStagesOfLife().get(3).getName())){
                   Color color = individual.getGender().equals(Gender.X) ? Color.BLUE : Color.MAGENTA;
                   g2.setColor(color);
                   g2.fillRect(individual.getX(), individual.getY(), Utilities.INDIVIDUAL_SIZE, Utilities.INDIVIDUAL_SIZE);
                   g2.setColor(Color.BLACK);
               }
            }
        }
    }

    private void paintFood(Graphics2D g2){
        if(game != null){
            for(Food food : game.getFood().values()){
                if(food.getState().equals(FoodState.NOT_CONSUMED)){
                    g2.setColor(Color.GREEN);
                    g2.fillRect(food.getX(), food.getY(), Utilities.FOOD_SIZE, Utilities.FOOD_SIZE);
                    g2.setColor(Color.BLACK);
                }
            }
        }
    }

    private void paintStatistics(Graphics2D g2){
        int x = (int)(Toolkit.getDefaultToolkit().getScreenSize().width * 0.9);
        int y = (int)(Toolkit.getDefaultToolkit().getScreenSize().height * 0.3);
        if(game != null){
            int[] statistics = game.generateStatistics();
            g2.drawString("Cantidad X: " + statistics[0], x, y);
            y += 10;
            g2.drawString("Cantidad Y: " + statistics[1], x, y);
            y += 10;
            g2.drawString("Cantidad comida: " + statistics[2], x, y);
        }
    }

    public void update(GameManager game){
        this.game = game;
        repaint();
    }
}
