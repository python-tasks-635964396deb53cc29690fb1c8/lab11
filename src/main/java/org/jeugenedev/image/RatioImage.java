package org.jeugenedev.image;

import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class RatioImage implements Image {
    private final Image image;

    public RatioImage(Image image) {
        this.image = image;
    }

    @Override
    public ImageView getImage(File imageFile) throws IOException {
        return this.image.getImage(imageFile);
    }

    public ImageView ratioImage(File imageFile, double w, double h) throws IOException {
        try (FileInputStream fis = new FileInputStream(imageFile)) {
            return new ImageView(new javafx.scene.image.Image(fis, w, h, true, true));
        }
    }
}
