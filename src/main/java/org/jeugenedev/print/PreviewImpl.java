package org.jeugenedev.print;

import javafx.scene.layout.GridPane;

public class PreviewImpl implements Preview {
    private final GridPane preview;

    public PreviewImpl(GridPane preview) {
        this.preview = preview;
    }

    @Override
    public GridPane getPreview() {
        return this.preview;
    }
}
