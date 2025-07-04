package src.entities;

public class Elite extends Movable {
    private int posX;
    private int posY;

    public Elite(int posX, int posY){
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

    public void move(int x, int y){
        if(x < this.posX){
            this.setPosX(this.getPosX() - this.getSpeed());
        }else{
            this.setPosX(this.getPosX() + this.getSpeed());
        }
        if(y < this.posY){
            this.setPosY(this.getPosY() - this.getSpeed());
        }else{
            this.setPosY(this.getPosY() + this.getSpeed());
        }
    }
}
