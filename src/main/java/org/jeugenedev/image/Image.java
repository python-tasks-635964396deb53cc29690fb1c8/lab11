package org.jeugenedev.image;

import javafx.scene.image.ImageView;

import java.io.File;
import java.io.IOException;

public interface Image {
    ImageView getImage(File imageFile) throws IOException;
}
