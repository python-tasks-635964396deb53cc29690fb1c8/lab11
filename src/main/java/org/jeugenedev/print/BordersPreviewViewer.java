package org.jeugenedev.print;

import javafx.scene.layout.Pane;

public class BordersPreviewViewer extends PreviewViewer {
    public BordersPreviewViewer(Pane preview) {
        super(preview);
    }

    @Override
    public Pane getPreview() {
        Pane pane = super.getPreview();
        pane.setStyle(pane.getStyle() + "-fx-border-color: black;");
        return pane;
    }
}
