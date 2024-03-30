package org.jeugenedev.print;

import javafx.scene.layout.Pane;

public abstract class PreviewViewer implements Preview {
    private final Pane preview;

    public PreviewViewer(Pane preview) {
        this.preview = preview;
    }

    @Override
    public Pane getPreview() {
        return preview;
    }
}
