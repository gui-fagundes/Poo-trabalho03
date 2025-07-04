package src.entities;

public class Enemy extends Movable {
    private int posX;
    private int posY;
    private int direction;

    public Enemy(int posX, int posY) {
        this.setPosX(posX);
        this.setPosY(posY);
        this.setSpeed(1);
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

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void move() {
        if (this.posX < 150 && this.posY < 200) {
            this.setPosX(this.getPosX() + this.getSpeed());
            this.setPosY(this.getPosY() - this.getSpeed());
        }
        if (this.getDirection() < 100) {
            if (this.posY >= 530)
                this.setPosY(this.getPosY() - this.getSpeed());
            else
                this.setPosY(this.getPosY() + this.getSpeed());
        } else if (this.getDirection() < 200) {
            if (this.posY <= 0)
                this.setPosY(this.getPosY() + this.getSpeed());
            else
                this.setPosY(this.getPosY() - this.getSpeed());
        } else if (this.getDirection() < 300) {
            if (this.posX >= 750)
                this.setPosX(this.getPosX() - this.getSpeed());
            else
                this.setPosX(this.getPosX() + this.getSpeed());
        } else if (this.getDirection() < 400) {
            if (this.posX <= 0)
                this.setPosX(this.getPosX() + this.getSpeed());
            else
                this.setPosX(this.getPosX() - this.getSpeed());
        } else if (this.getDirection() < 500) {
            if (this.posY >= 530 || this.posX >= 750) {
                this.setPosY(this.getPosY() - this.getSpeed());
                this.setPosX(this.getPosX() - this.getSpeed());
            } else {
                this.setPosY(this.getPosY() + this.getSpeed());
                this.setPosX(this.getPosX() + this.getSpeed());
            }
        } else if (this.getDirection() < 600) {
            if (this.posY <= 0 || this.posX <= 0) {
                this.setPosY(this.getPosY() + this.getSpeed());
                this.setPosX(this.getPosX() + this.getSpeed());
            } else {
                this.setPosY(this.getPosY() - this.getSpeed());
                this.setPosX(this.getPosX() - this.getSpeed());
            }
        } else if (this.getDirection() < 700) {
            if (this.posY >= 530 || this.posX <= 0) {
                this.setPosY(this.getPosY() - this.getSpeed());
                this.setPosX(this.getPosX() + this.getSpeed());
            } else {
                this.setPosY(this.getPosY() + this.getSpeed());
                this.setPosX(this.getPosX() - this.getSpeed());
            }
        } else if (this.getDirection() < 800) {
            if (this.posY <= 0 || this.posX >= 750){
                this.setPosY(this.getPosY() + this.getSpeed());
                this.setPosX(this.getPosX() - this.getSpeed());
            }
            else{
                this.setPosY(this.getPosY() - this.getSpeed());
                this.setPosX(this.getPosX() + this.getSpeed());
            }
        }
    }

}
