package org.jeugenedev;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import org.jeugenedev.image.OriginalImage;
import org.jeugenedev.print.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PreviewPrintController {
    private RadioButton[] positionButtons;
    @FXML
    private RadioButton bottomCenterBtn;
    @FXML
    private RadioButton bottomLeftBtn;
    @FXML
    private RadioButton bottomRightBtn;
    @FXML
    private RadioButton centerCenterBtn;
    @FXML
    private RadioButton centerLeftBtn;
    @FXML
    private RadioButton centerRightBtn;
    @FXML
    private RadioButton topCenterBtn;
    @FXML
    private RadioButton topLeftBtn;
    @FXML
    private RadioButton topRightBtn;
    private ImageView currentImage;
    @FXML
    private GridPane previewScreen;
    @FXML
    private GridPane previewScreenElement;
    private Preview preview;

    @FXML
    void bottomCenterBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.BOTTOM);
        GridPane.setHalignment(this.previewScreenElement, HPos.CENTER);
    }

    @FXML
    void bottomLeftBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.BOTTOM);
        GridPane.setHalignment(this.previewScreenElement, HPos.LEFT);
    }

    @FXML
    void bottomRightBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.BOTTOM);
        GridPane.setHalignment(this.previewScreenElement, HPos.RIGHT);
    }

    @FXML
    void centerCenterBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.CENTER);
        GridPane.setHalignment(this.previewScreenElement, HPos.CENTER);
    }

    @FXML
    void centerLeftBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.CENTER);
        GridPane.setHalignment(this.previewScreenElement, HPos.LEFT);
    }

    @FXML
    void centerRightBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.CENTER);
        GridPane.setHalignment(this.previewScreenElement, HPos.RIGHT);
    }

    @FXML
    void topCenterBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.TOP);
        GridPane.setHalignment(this.previewScreenElement, HPos.CENTER);
    }

    @FXML
    void topLeftBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.TOP);
        GridPane.setHalignment(this.previewScreenElement, HPos.LEFT);
    }

    @FXML
    void topRightBtnAction(ActionEvent event) {
        cancelAllPositionButtons(event);
        GridPane.setValignment(this.previewScreenElement, VPos.TOP);
        GridPane.setHalignment(this.previewScreenElement, HPos.RIGHT);
    }

    private void cancelAllPositionButtons(ActionEvent event) {
        for (RadioButton button : this.positionButtons) {
            if (button.isSelected()) {
                button.setSelected(false);
            }
        }
        ((RadioButton) event.getSource()).setSelected(true);
    }

    @FXML
    void bordersBtnAction(ActionEvent event) {
        this.preview = new BordersPreviewViewer(this.preview.getPreview());
        this.preview.getPreview();
        ((CheckBox) event.getSource()).setDisable(true);
    }

    @FXML
    void dateBtnAction(ActionEvent event) {
        this.preview = new DatePreviewViewer(this.preview.getPreview());
        this.preview.getPreview();
        ((CheckBox) event.getSource()).setDisable(true);
    }

    @FXML
    void fillBtnAction(ActionEvent event) {
        this.preview = new FillGrayPreviewViewer(this.preview.getPreview());
        this.preview.getPreview();
        ((CheckBox) event.getSource()).setDisable(true);
    }

    @FXML
    void marginsBtnAction(ActionEvent event) {
        this.preview = new MarginsPreviewViewer(this.preview.getPreview());
        this.preview.getPreview();
        ((CheckBox) event.getSource()).setDisable(true);
    }

    @FXML
    void initialize() {
        positionButtons = new RadioButton[]{bottomCenterBtn, bottomLeftBtn, bottomRightBtn,
                centerCenterBtn, centerLeftBtn, centerRightBtn, topCenterBtn, topLeftBtn, topRightBtn};
        this.centerLeftBtn.setSelected(true);

        this.preview = new PreviewImpl(this.previewScreen);

        previewScreen.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setSelectedExtensionFilter(
                    new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.jpeg", "*.png"));
            File selectedFile = fileChooser.showOpenDialog(previewScreen.getParent().getScene().getWindow());

            if (selectedFile != null && selectedFile.isFile()) {
                try {
                    this.currentImage = new OriginalImage().getImage(selectedFile);
                    if (!this.previewScreenElement.getChildren().isEmpty()) {
                        this.previewScreenElement.getChildren().remove(0);
                    }
                    previewScreenElement.add(this.currentImage, 0, 0);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}