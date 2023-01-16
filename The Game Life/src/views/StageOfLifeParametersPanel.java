package views;

import javax.swing.*;
import java.awt.*;

public class StageOfLifeParametersPanel extends JPanel {

    private JTextField durationTxt;
    private JTextField speedOfMovementTxt;
    private JTextField energyConsumptionTxt;

    public StageOfLifeParametersPanel(String name) {
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1,4));
        JLabel nameLb = new JLabel(name + " : ");
        add(nameLb);
        durationTxt = new JTextField();
        add(durationTxt);
        speedOfMovementTxt = new JTextField();
        add(speedOfMovementTxt);
        energyConsumptionTxt = new JTextField();
        add(energyConsumptionTxt);
    }

    public int getDuration(){
        return Integer.parseInt(durationTxt.getText());
    }

    public int getSpeedOfMovement(){
        return Integer.parseInt(speedOfMovementTxt.getText());
    }

    public int energyConsumption(){
        return Integer.parseInt(energyConsumptionTxt.getText());
    }
}
