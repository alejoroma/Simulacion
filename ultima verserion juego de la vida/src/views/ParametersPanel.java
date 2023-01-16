package views;

import models.Utilities;
import models.StageOfLife;

import javax.swing.*;
import java.awt.*;

public class ParametersPanel extends JPanel {

    private JTextField xNumberTxt;
    private JTextField yNumberTxt;
    private JTextField widthTxt;
    private JTextField heightTxt;
    private JTextField quantityFoodTxt;
    private JTextField foodTimeTxt;
    private StageOfLifeParametersPanel birthPanel;
    private StageOfLifeParametersPanel childhoodPanel;
    private StageOfLifeParametersPanel maturityPanel;

    public ParametersPanel() {
        setLayout(new GridLayout(2,1));
        addXYParameters();
        addDimensionsParameters();
        addFoodParameters();
        addStagesOfLifeParameters();
    }

    private void addXYParameters(){
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.setBackground(Color.PINK);
        panel.add(new JLabel("Ingrese la cantida X: "));
        xNumberTxt = new JTextField();
        panel.add(xNumberTxt);
        panel.add(new JLabel("Ingrese la cantidad Y: "));
        yNumberTxt = new JTextField();
        panel.add(yNumberTxt);
        add(panel);
    }

    private void addDimensionsParameters(){
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.setBackground(Color.PINK);
        panel.add(new JLabel("Alto Del Espacio: "));
        heightTxt = new JTextField();
        panel.add(heightTxt);
        panel.add(new JLabel("Ancho Del Espacio: "));
        widthTxt = new JTextField();
        panel.add(widthTxt);
        add(panel);
    }

    private void addFoodParameters(){
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.setBackground(Color.PINK);
        panel.add(new JLabel("Cantidad inicial De Comida: "));
        quantityFoodTxt = new JTextField();
        panel.add(quantityFoodTxt);
        panel.add(new JLabel("Tiempo de generacion de comida: "));
        foodTimeTxt = new JTextField();
        panel.add(foodTimeTxt);
        add(panel);
    }


    private void addStagesOfLifeParameters(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.PINK);
        JPanel titlesPanel = new JPanel(new GridLayout(1,4, 10, 10));
        titlesPanel.setPreferredSize(new Dimension(Utilities.INITIAL_WIDTH, (int)(Utilities.INITIAL_HEIGHT * 0.07)));
        titlesPanel.setBackground(Color.PINK);
        titlesPanel.add(new JLabel("Nombre", SwingConstants.CENTER));
        titlesPanel.add(new JLabel("Duracion"));
        titlesPanel.add(new JLabel("Velocidad de movimiento"));
        titlesPanel.add(new JLabel("Consumo de energia"));
        panel.add(titlesPanel, BorderLayout.NORTH);
        JPanel stagesPanel = new JPanel(new GridLayout(3,1));
        stagesPanel.setBackground(Color.PINK);
        birthPanel = new StageOfLifeParametersPanel("Infancia");
        stagesPanel.add(birthPanel);
        childhoodPanel = new StageOfLifeParametersPanel("Adultez");
        stagesPanel.add(childhoodPanel);
        maturityPanel = new StageOfLifeParametersPanel("Vejez");
        stagesPanel.add(maturityPanel);
        panel.add(stagesPanel, BorderLayout.CENTER);
        add(panel);
    }

    public int getXNumber(){
        return Integer.parseInt(xNumberTxt.getText());
    }

    public int getYNumber(){
        return Integer.parseInt(yNumberTxt.getText());
    }

    public int getAreaWidth(){
        return Integer.parseInt(widthTxt.getText());
    }

    public int getAreaHeight(){
        return Integer.parseInt(heightTxt.getText());
    }

    public StageOfLife getBirthStage(){
        return new StageOfLife("Nacimiento", birthPanel.getSpeedOfMovement(),birthPanel.getDuration(),
                birthPanel.energyConsumption());
    }

    public StageOfLife getChildhoodStage(){
        return new StageOfLife("Infancia", childhoodPanel.getSpeedOfMovement(),childhoodPanel.getDuration(),
                childhoodPanel.energyConsumption());
    }

    public StageOfLife getMaturityStage(){
        return new StageOfLife("Madurez", maturityPanel.getSpeedOfMovement(),maturityPanel.getDuration(),
                maturityPanel.energyConsumption());
    }

    public int getQuantityFood() {
        return Integer.parseInt(quantityFoodTxt.getText());
    }

    public int getFoodTime() {
        return Integer.parseInt(foodTimeTxt.getText());
    }
}