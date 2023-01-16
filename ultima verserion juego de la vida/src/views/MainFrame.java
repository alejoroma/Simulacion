package views;

import models.Utilities;
import models.GameManager;
import models.StageOfLife;
import presenters.Events;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainFrame extends JFrame {

    private static final String APP_ICON_PATH = "/resources/icon.png";
    private GamePanel gamePanel;
    private ParametersPanel parametersPanel;

    public MainFrame(ActionListener listener) throws IOException {
        BufferedImage appIcon = ImageIO.read(getClass().getResource(APP_ICON_PATH));
        setIconImage(appIcon);
        getContentPane().setLayout(new BorderLayout());
        setTitle(Utilities.TITLE);
        setSize(Utilities.INITIAL_WIDTH, Utilities.INITIAL_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initParametersPanel();
        addButtonsPanel(listener);
    }

    public void initParametersPanel(){
        parametersPanel = new ParametersPanel();
        add(parametersPanel, BorderLayout.CENTER);
    }

    public void initGamePanel(int width, int height){
        this.getContentPane().removeAll();
        gamePanel = new GamePanel(width, height);
        setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.CENTER);
        getContentPane().repaint();
    }

    private void addButtonsPanel(ActionListener listener){
        JPanel buttonsPanel = new JPanel(new BorderLayout());
        JButton startBtn = new JButton("Iniciar simulacion");
        startBtn.setFont(new Font("Arial", Font.BOLD, 16));
        startBtn.setBackground(Color.decode("#40B64B"));
        startBtn.setForeground(Color.WHITE);
        startBtn.setActionCommand(Events.START_SIMULATION.toString());
        startBtn.addActionListener(listener);
        buttonsPanel.add(startBtn);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public void update(GameManager game){
        gamePanel.update(game);
    }

    public int getXNumber(){
        return parametersPanel.getXNumber();
    }

    public int getYNumber(){
        return parametersPanel.getYNumber();
    }

    public int getAreaWidth(){
        return parametersPanel.getAreaWidth();
    }

    public int getAreaHeight(){
        return parametersPanel.getAreaHeight();
    }

    public StageOfLife getBirthStage(){
        return parametersPanel.getBirthStage();
    }

    public StageOfLife getChildhoodStage(){
        return parametersPanel.getChildhoodStage();
    }

    public StageOfLife getMaturityStage(){
        return parametersPanel.getMaturityStage();
    }

    public int getQuantityFood() {
        return parametersPanel.getQuantityFood();
    }

    public int getFoodTime() {
        return parametersPanel.getFoodTime();
    }
}