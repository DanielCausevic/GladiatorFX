package sample.Model.Sources;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * @Author: Rasmus Skovbo
 * This is the mother class to all game entities, e.g. weapons on the ground, gladiators, hexes etc.
 * Cannot be instantied, must be inherited.
 */

public abstract class Sprite {
    private Image image;
    private double width;
    private double height;
    private double x;
    private double y;

    public Sprite(Image image, double width, double height) {
        this.image = image;
        this.width = width;
        this.height = height;
    }

    // Set image via Image object
    public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    // Set image via filename
    public void setImage(String filename)
    {
        Image i = new Image(filename);
        setImage(i);
    }

    // Reposition sprite
    public void setPosition(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    // Render sprite in a graphics context
    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, x, y );
    }


}
