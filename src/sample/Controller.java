package sample;

import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import java.util.ArrayList;

public class Controller {

    public TextField inputNew;
    public ListView<CheckBox> viewList;

    private Model model;

    public void initialize() {
        model = new Model();
        inputNew.setText(model.getInputNewText());
        ArrayList viewListTexts = model.getViewListTexts();
        for (int i = 0; i < viewListTexts.size(); i++) {
            viewList.getItems().add(new CheckBox((String)viewListTexts.get(i)));
        }
    }

    void save() {
        model.setAllData(inputNew.getText(), viewList.getItems());
        model.save();
    }

    public void inputNewReady() {
        CheckBox newCheckBox = new CheckBox(inputNew.getText());
        newCheckBox.setOnAction(e -> {
            viewList.getItems().remove(newCheckBox);
        });
        viewList.getItems().add(newCheckBox);
        inputNew.setText("");
    }


    public void resetViewList() {
        viewList.getItems().clear();
    }
}
