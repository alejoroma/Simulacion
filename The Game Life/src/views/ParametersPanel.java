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
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("X: "));
        xNumberTxt = new JTextField();
        panel.add(xNumberTxt);
        panel.add(new JLabel("Y: "));
        yNumberTxt = new JTextField();
        panel.add(yNumberTxt);
        //panel.setBorder(BorderFactory.createTitledBorder("Cantidad de X y Y iniciales"));
        add(panel);
    }

    private void addDimensionsParameters(){
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("Alto: "));
        heightTxt = new JTextField();
        panel.add(heightTxt);
        panel.add(new JLabel("Ancho: "));
        widthTxt = new JTextField();
        panel.add(widthTxt);
        //panel.setBorder(BorderFactory.createTitledBorder("Dimensiones"));
        add(panel);
    }

    private void addFoodParameters(){
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.setBackground(Color.WHITE);
        panel.add(new JLabel("Cantidad inicial: "));
        quantityFoodTxt = new JTextField();
        panel.add(quantityFoodTxt);
        panel.add(new JLabel("Tiempo de generacion: "));
        foodTimeTxt = new JTextField();
        panel.add(foodTimeTxt);
        //panel.setBorder(BorderFactory.createTitledBorder("Alimento"));
        add(panel);
    }


    private void addStagesOfLifeParameters(){
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        JPanel titlesPanel = new JPanel(new GridLayout(1,4, 10, 10));
        titlesPanel.setPreferredSize(new Dimension(Utilities.INITIAL_WIDTH, (int)(Utilities.INITIAL_HEIGHT * 0.07)));
        titlesPanel.setBackground(Color.WHITE);
        titlesPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#76EAC6"), 1, true));
        titlesPanel.add(new JLabel("Nombre", SwingConstants.CENTER));
        titlesPanel.add(new JLabel("Duracion", SwingConstants.CENTER));
        titlesPanel.add(new JLabel("Velocidad de movimiento" ,SwingConstants.CENTER));
        titlesPanel.add(new JLabel("Consumo de energia", SwingConstants.CENTER));
        panel.add(titlesPanel, BorderLayout.NORTH);
        JPanel stagesPanel = new JPanel(new GridLayout(3,1));
        stagesPanel.setBackground(Color.WHITE);
        birthPanel = new StageOfLifeParametersPanel("Nacimiento");
        stagesPanel.add(birthPanel);
        childhoodPanel = new StageOfLifeParametersPanel("Infancia");
        stagesPanel.add(childhoodPanel);
        maturityPanel = new StageOfLifeParametersPanel("Madurez");
        stagesPanel.add(maturityPanel);
        panel.add(stagesPanel, BorderLayout.CENTER);
        //panel.setBorder(BorderFactory.createTitledBorder("Etapas"));
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

