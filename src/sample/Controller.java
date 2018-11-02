package sample;

import javafx.scene.control.*;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public TextField inputNew;
    public TextField inputDueDate;
    public ListView<CheckBox> viewList1;
    public DatePicker chooseDate;
    public MenuButton chooseHowDue;
    public MenuItem byDate;
    public MenuItem byText;
    private boolean a = true;

    private Model model;

    public void initialize() {
        model = new Model();
        inputNew.setText(model.getInputNewText());
        inputDueDate.setText(model.getInputDueDateText());

        ArrayList viewListTexts1 = model.getViewListTexts1();
        for (int i = 0; i < viewListTexts1.size(); i++) {
            CheckBox newCheckBox1 = new CheckBox((String)viewListTexts1.get(i));
            newCheckBox1.setOnAction(e-> {
                viewList1.getItems().remove(newCheckBox1);
            });

            viewList1.getItems().add(newCheckBox1);
        }
        inputNew.requestFocus();
        chooseDate.setValue(null);
    }

    void save() {
        model.setAllData(inputNew.getText(), inputDueDate.getText(), viewList1.getItems(), chooseDate.getAccessibleText());
        model.save();
    }

    public void byDateChosen() {
        a = true;
        inputDueDate.toBack();
        chooseDate.toFront();
    }

    public void byTextChosen() {
        a = false;
        inputDueDate.toFront();
        chooseDate.toBack();
    }

    public void inputNewReady() {
        CheckBox newCheckBox1 = new CheckBox(inputNew.getText());
        viewList1.getItems().add(newCheckBox1);
        newCheckBox1.setOnAction(e-> {
            viewList1.getItems().remove(newCheckBox1);
        });
        if (a == true) {
            chooseDate.requestFocus();
        }
        if (a == false) {
            inputDueDate.requestFocus();
        }
    }

    public void inputDueDateReady() {
        //CheckBox newCheckBox1 = new CheckBox(inputNew.getText() + "    Due By: " + inputDueDate.getText());
        //newCheckBox.setText(inputNew.getText() + "    Due By: " + inputDueDate.getText());
        //viewList1.getItems().add(newCheckBox1);

        viewList1.getItems().remove(viewList1.getItems().size()-1);
        CheckBox newCheckBox1 = new CheckBox(inputNew.getText() + "      Due By: " + inputDueDate.getText());
        viewList1.getItems().add(newCheckBox1);
        newCheckBox1.setOnAction(e-> {
            viewList1.getItems().remove(newCheckBox1);
        });

        inputDueDate.setText("");
        inputNew.setText("");
        inputNew.requestFocus();
    }

    public void chooseDateReady() {
        viewList1.getItems().remove(viewList1.getItems().size() - 1);
        CheckBox newCheckBox1 = new CheckBox(inputNew.getText() + "      Due By: " + chooseDate.getValue());
        viewList1.getItems().add(newCheckBox1);
        newCheckBox1.setOnAction(e -> {
            viewList1.getItems().remove(newCheckBox1);
        });

        chooseDate.setValue(chooseDate.getValue());
        inputNew.setText("");
        inputNew.requestFocus();
    }

    public void resetViewList() {
        viewList1.getItems().clear();
        inputNew.setText("");
        inputDueDate.setText("");
        try {
            new PrintWriter("NewThing.txt").close();
        } catch (Exception e) {
        }
    }
}

