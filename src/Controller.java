import javafx.scene.control.TableView;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;

public class Controller {
    private ViewModel viewmodel;
    private Timer timer;
    private boolean running;
    private Database database;

    public Controller(){
        viewmodel= new ViewModel();
        timer = new Timer();
        running = true;
        database = new Database();
        ViewModel.ExitButton(new exit());
        ViewModel.topscore(new score());
        update();
    }
    public void update(){
        while (running){
            ViewModel.setTime(counter.time());
        }
    }
    private class exit implements ActionListener{
        public void actionPerformed(ActionEvent e){
            running = false;
            try {
                database.dbStore(JOptionPane.showInputDialog(null, "Type in your initials"), Integer.parseInt(view.getTime()));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            ViewModel.dispose();
        }
    }

    private class score implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                ViewModel.scoreboard(database.dbShow());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}