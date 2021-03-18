package sample.Model.Sources;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ImageViewSprite {
    private final ImageView imageView;

    private final int rows;

    private final int frameWidth;
    private final int frameHeight;


    public ImageViewSprite(ImageView imageView, Image image, int rows, int frameWidth, int frameHeight) {
        this.imageView = imageView;
        this.imageView.setImage(image); // Loads spritesheet
        this.imageView.setViewport(new Rectangle2D(0, 0, frameWidth, frameHeight)); // Initiatiates viewport

        this.rows = rows;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public void directionOfImage(String direction) {
        switch (direction) {
            case "N" -> imageView.setViewport(new Rectangle2D(0, 0, frameWidth, frameHeight));
            case "W" -> imageView.setViewport(new Rectangle2D(0, frameHeight, frameWidth, frameHeight));
            case "S" -> imageView.setViewport(new Rectangle2D(0, frameHeight * 2, frameWidth, frameHeight));
            case "E" -> imageView.setViewport(new Rectangle2D(0, frameHeight * 3, frameWidth, frameHeight));
        }
    }


    public int getRows() {
        return rows;
    }

    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }
}
