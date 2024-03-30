package org.jeugenedev.print;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MarginsPreviewViewer extends PreviewViewer {
    public MarginsPreviewViewer(Pane preview) {
        super(preview);
    }

    @Override
    public Pane getPreview() {
        Pane pane = super.getPreview();
        GridPane gridPane = (GridPane) pane;
        GridPane.setMargin(gridPane.getChildren().get(0), new Insets(20, 10, 20, 30));
        return pane;
    }
}
