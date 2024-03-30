package org.jeugenedev.print;

import javafx.scene.layout.Pane;

public class FillGrayPreviewViewer extends PreviewViewer {
    public FillGrayPreviewViewer(Pane preview) {
        super(preview);
    }

    @Override
    public Pane getPreview() {
        Pane pane = super.getPreview();
        pane.setStyle(pane.getStyle() + "-fx-background-color: gray;");
        return pane;
    }
}
