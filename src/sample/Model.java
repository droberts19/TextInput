package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.CheckBox;

public class Model {

    private String inputNewText;
    private ArrayList<String> viewListTexts;

    Model() {
        inputNewText = "";
        viewListTexts = new ArrayList();

        try {
            File savedText = new File(getClass().getResource("NewThing.txt").toURI());
            if (savedText.exists()) {
                BufferedReader input = new BufferedReader(new FileReader(savedText));

                inputNewText = input.readLine();
                String newViewListText = input.readLine();
                while (newViewListText != null) {
                    viewListTexts.add(newViewListText);
                    newViewListText = input.readLine();
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
                writer.newLine();
                if (inputNewText != null) {
                    writer.write(inputNewText);
                } else {
                    writer.write("");
                }
                writer.newLine();
                int length = viewListTexts.size();
                if (length > 0) {
                    for (int i = 0; i < length; i++) {
                        writer.write(viewListTexts.get(i));
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

    ArrayList<String> getViewListTexts() {
        return viewListTexts;
    }

    void setAllData(String updatedInputNewText, List<CheckBox> updatedViewListTexts) {
        inputNewText = updatedInputNewText;
        int length = updatedViewListTexts.size();
        viewListTexts.clear();
        for (int i = 0; i < length; i++) {
            viewListTexts.add(updatedViewListTexts.get(i).getText());
        }
    }
}
