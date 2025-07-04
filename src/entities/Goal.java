package src.entities;

import java.awt.Color;

public class Goal extends Movable {
    private int size = 80;
    private Color color = Color.GREEN;
    private int posX = 700;
    private int posY = 450;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void reposition(){
        this.setPosX((int)(Math.random()*100) + 600);
        this.setPosY((int)(Math.random()*100) + 50);
    }

}
