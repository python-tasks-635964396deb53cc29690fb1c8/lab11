package org.jeugenedev.image;

import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;

public interface RatioImage extends Image {
    ImageView ratioImage(File imageFile, double w, double h) throws IOException;
}
