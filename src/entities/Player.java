package src.entities;

public class Player extends Movable {
    private int startPosX = 50;
    private int startPosY = 50;
    private int currentPosX = startPosX;
    private int currentPosY = startPosY;


    public int getStartPosX() {
        return startPosX;
    }

    public void setStartPosX(int startPosX) {
        this.startPosX = startPosX;
    }

    public int getStartPosY() {
        return startPosY;
    }

    public void setStartPosY(int startPosY) {
        this.startPosY = startPosY;
    }

    public int getCurrentPosX() {
        return currentPosX;
    }

    public void setCurrentPosX(int currentPosX) {
        this.currentPosX = currentPosX;
    }

    public int getCurrentPosY() {
        return currentPosY;
    }

    public void setCurrentPosY(int currentPosY) {
        this.currentPosY = currentPosY;
    }

    public void move(boolean up, boolean down, boolean left, boolean right) {
        if (up) {
            if (this.getCurrentPosY() <= 0)
                return;
            else
                this.setCurrentPosY(this.getCurrentPosY() - this.getSpeed());
        }
        if (down) {
            if (this.getCurrentPosY() >= 530)
                return;
            else
                this.setCurrentPosY(this.getCurrentPosY() + this.getSpeed());
        }
        if (left) {
            if (this.getCurrentPosX() <= 0)
                return;
            else
                this.setCurrentPosX(this.getCurrentPosX() - this.getSpeed());
        }
        if (right) {
            if (this.getCurrentPosX() >= 750)
                return;
            else
                this.setCurrentPosX(this.getCurrentPosX() + this.getSpeed());
        }
    }

}
