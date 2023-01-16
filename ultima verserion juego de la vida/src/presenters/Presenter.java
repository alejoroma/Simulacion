package presenters;

import models.Utilities;
import models.GameManager;
import models.StageOfLife;
import views.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Presenter implements ActionListener{

    private GameManager gameManager;
    private MainFrame mainFrame;
    private Timer gameLoop;

    public Presenter() {
        gameManager = new GameManager();
        try {
            mainFrame = new MainFrame(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Events.valueOf(e.getActionCommand())){
            case START_SIMULATION:
                manageStartSimulationEvent();
                break;
        }
    }

    private void manageStartSimulationEvent() {
        Utilities.width = mainFrame.getAreaWidth();
        Utilities.height = mainFrame.getAreaHeight();
        gameManager.addStageOfLife(mainFrame.getBirthStage());
        gameManager.addStageOfLife(mainFrame.getChildhoodStage());
        gameManager.addStageOfLife(mainFrame.getMaturityStage());
        gameManager.addStageOfLife(new StageOfLife("Muerte",0,0,0));
        gameManager.generateInitialIndividuals(mainFrame.getXNumber(), mainFrame.getYNumber());
        gameManager.generateInitialFood(mainFrame.getQuantityFood(), mainFrame.getFoodTime());
        mainFrame.initGamePanel(Utilities.width, Utilities.height);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initGame();
    }

    private void initGame(){
        gameManager.moveIndividuals();
        gameManager.generateFootsxDD(mainFrame.getFoodTime());
        gameLoop = new Timer(Utilities.DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainFrame.update(gameManager);
            }
        });
        gameLoop.start();
    }
}