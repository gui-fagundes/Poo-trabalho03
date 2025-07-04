package src.entities;

public class Asteroid extends Movable {
    public int posX;
    public int posY;

    public Asteroid(int posX){
        this.setPosY(0);
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
            this.posY = 0;
        }else{
            this.posY++;
        }
        if(this.posX < 0){
            this.posX = 800;
        }else{
            this.posX--;
        }
    }


}
