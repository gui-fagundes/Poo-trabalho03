package src.entities;

public class Asteroid extends Movable {
    public int posX;
    public int posY;

    public Asteroid(int posX){
        this.setPosY(1);
        this.setPosX(posX);
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

    public void move(){
        if(this.posY > 600){
            this.setPosY(0);
        }else{
            this.setPosY(this.getPosY() + 1);
        }
        if(this.posX < 0){
            this.setPosX(800);
        }else{
            this.setPosX(this.getPosX() - 1);
        }
    }


}
