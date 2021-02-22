import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GamebookViewForm extends JFrame {

    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GamebookViewForm");
        frame.setContentPane(new GamebookViewForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public GamebookViewForm(){
        Story s = new Story(1);
        setStory(s);
    }

    public void choices(Story story){
        for (int i = 0; i < story.getChoices().length; i++){
            if (i == 0){
                this.button1.setVisible(true);
                this.button1.setText(story.getChoice(i));
            }
            if (i == 1) {
                this.button2.setVisible(true);
                this.button2.setText(story.getChoice(i));
            }
        }
    }

    public void disableButton(){
        this.button1.setVisible(false);
        this.button2.setVisible(false);
    }

    public void setStory(Story story){
        this.disableButton();

        this.textArea1.setText(story.getText());
        //this.choices(story);
    }

    public Story getStory(){
        String story = this.textArea1.getText();
        ArrayList<String> choices = new ArrayList<String>();


        if (this.button1.isVisible()){
            choices.add(this.button1.getText());

            if (this.button2.isVisible()){
                choices.add(this.button2.getText());

                }
            }

        String[] choice = getStringArray(choices);

        return new Story(story, choice);
    }

    public static String[] getStringArray(ArrayList<String> arr)
    {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }

        return str;
    }
}