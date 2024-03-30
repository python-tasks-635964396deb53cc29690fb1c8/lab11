package org.jeugenedev.image;

import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class OriginalImage implements Image {
    @Override
    public ImageView getImage(File imageFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(imageFile)) {
            return new ImageView(new javafx.scene.image.Image(fis));
        }
    }
}
