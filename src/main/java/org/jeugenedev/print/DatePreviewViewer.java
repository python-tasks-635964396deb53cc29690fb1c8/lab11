package org.jeugenedev.print;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePreviewViewer extends PreviewViewer {
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public DatePreviewViewer(Pane preview) {
        super(preview);
    }

    @Override
    public Pane getPreview() {
        Pane pane = super.getPreview();
        GridPane gridPane = (GridPane) pane;
        if (gridPane.getChildren().size() > 1) {
            gridPane.getChildren().remove(1);
        }
        gridPane.addRow(1, new Text(this.format.format(new Date())));
        return pane;
    }
}
