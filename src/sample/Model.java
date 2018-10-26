package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckBox;

public class Model {

    private String inputNewText;
    private String inputDueDateText;
    private ArrayList<String> viewListTexts1;

    Model() {
        inputNewText = "";
        inputDueDateText = "";
        viewListTexts1 = new ArrayList();

        try {
            File savedText = new File(getClass().getResource("NewThing.txt").toURI());
            if (savedText.exists()) {
                BufferedReader input = new BufferedReader(new FileReader(savedText));

                inputNewText = input.readLine();
                System.out.println("Model Read: " + inputNewText);

                inputDueDateText = input.readLine();
                System.out.println("Model Read: " + inputDueDateText);

                String newViewListTexts1 = input.readLine();
                while (newViewListTexts1 != null) {
                    viewListTexts1.add(newViewListTexts1);
                    System.out.println("Model Read: " + viewListTexts1);
                    newViewListTexts1 = input.readLine();
                }

                input.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void save() {
        try {
            File savedText = new File(getClass().getResource("NewThing.txt").toURI());
            BufferedWriter writer = new BufferedWriter(new FileWriter(savedText));
            if (writer != null) {
                if (inputNewText != null) {
                    writer.write(inputNewText);
                } else {
                    writer.write("");
                }
                writer.newLine();
                if (inputDueDateText != null) {
                    writer.write(inputDueDateText);
                } else {
                    writer.write("");
                }
                writer.newLine();
                int length1 = viewListTexts1.size();
                if (length1 > 0) {
                    for (int i = 0; i < length1; i++) {
                        writer.write(viewListTexts1.get(i));
                        writer.newLine();
                    }
                } else {
                    writer.write("");
                    writer.newLine();
                }
            }
            writer.close();
        } catch (Exception e) {
        }
    }

    String getInputNewText() {
        return inputNewText;
    }

    String getInputDueDateText() {
        return inputDueDateText;
    }

    ArrayList<String> getViewListTexts1() {
        return viewListTexts1;
    }

    void setAllData(String updatedInputNewText, String updatedInputDueDateText, List<CheckBox> updatedViewListTexts1) {

        inputNewText = updatedInputNewText;
        inputDueDateText = updatedInputDueDateText;

        int length1 = updatedViewListTexts1.size();
        viewListTexts1.clear();
        for (int i = 0; i < length1; i++) {
            viewListTexts1.add(updatedViewListTexts1.get(i).getText());
        }
    }
}
