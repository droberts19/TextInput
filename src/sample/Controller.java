package sample;

import javafx.scene.control.*;
import java.util.ArrayList;

public class Controller {

    public TextField inputNew;
    public ListView viewList;

    private Model model;

    public void initialize() {
        model = new Model();

        inputNew.setText(model.getInputNewText());
        ArrayList viewListTexts = model.getViewListTexts();
        for (int i = 0; i < viewListTexts.size(); i++) {
            viewList.getItems().add(new Label((String)viewListTexts.get(i)));
        }
    }

    void save() {
        model.setAllData(inputNew.getText(), viewList.getItems());
        model.save();
    }

    public void inputNewReady() {
        viewList.getItems().add(new Label(inputNew.getText()));
        inputNew.setText("");
    }
}
