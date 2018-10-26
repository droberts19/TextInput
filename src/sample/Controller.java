package sample;

import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Controller {

    public TextField inputNew;
    public TextField inputDueDate;
    public ListView<CheckBox> viewList1;
    public CheckBox newCheckBox;

    private Model model;

    public void initialize() {
        model = new Model();
        inputNew.setText(model.getInputNewText());
        inputDueDate.setText(model.getInputDueDateText());

        ArrayList viewListTexts1 = model.getViewListTexts1();
        for (int i = 0; i < viewListTexts1.size(); i++) {
            viewList1.getItems().add(new CheckBox((String)viewListTexts1.get(i)));
        }
    }

    void save() {
        model.setAllData(inputNew.getText(), inputDueDate.getText(), viewList1.getItems());
        model.save();
    }

    public void inputNewReady() {


    }

    public void inputDueDateReady() {
        CheckBox newCheckBox1 = new CheckBox(inputNew.getText() + "    Due By: " + inputDueDate.getText());
        //newCheckBox.setText(inputNew.getText() + "    Due By: " + inputDueDate.getText());
        viewList1.getItems().add(newCheckBox1);
        newCheckBox1.setOnAction(e-> {
            viewList1.getItems().remove(newCheckBox1);
        });

        inputNew.setText("");
        inputDueDate.setText("");
    }


    public void resetViewList() {
        viewList1.getItems().clear();
        inputNew.setText("");
        inputDueDate.setText("");
    }
}
