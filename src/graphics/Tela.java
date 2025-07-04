package src.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import src.entities.Asteroid;
import src.entities.Elite;
import src.entities.Enemy;
import src.entities.Goal;
import src.entities.Player;

public class Tela extends JPanel implements KeyListener, Runnable {
    String goalsrc = "src/images/moon.png";
    int score = 0;
    boolean gameOver = false;
    boolean up, down, left, right = false;
    Player player = new Player();
    Goal goal = new Goal();
    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Elite> elites = new ArrayList<>();
    ArrayList<Asteroid> asteroids = new ArrayList<>();

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.BLACK);
    }

    @Override
    protected void paintComponent(Graphics p) {
        super.paintComponent(p);
        ImageIcon background = new ImageIcon("src/images/background.jpg", "background image");
        p.drawImage( background.getImage() , 0, 0, 800, 600, null);

        p.setFont(new Font("TimesRoman", Font.ITALIC, 24));
        p.setColor(Color.WHITE);
        p.drawString("Score: " + score, 350, 30);

        if (gameOver) {
            p.setFont(new Font("TimesRoman", Font.BOLD, 40));
            p.setColor(Color.WHITE);
            p.drawString("GAMEOVER", 280, 250);
        }

        ImageIcon goalimage = new ImageIcon(goalsrc, "goal");
        p.drawImage(goalimage.getImage(), goal.getPosX(), goal.getPosY(), goal.getSize(), goal.getSize(), null);

        ImageIcon playerimage = new ImageIcon("src/images/player.png", "player");
        p.drawImage(playerimage.getImage(), player.getCurrentPosX(), player.getCurrentPosY(), player.getSide(),
                player.getSide(), null);

        ImageIcon enemyimage = new ImageIcon("src/images/enemy.png", "enemy");
        for (Enemy enemy : enemies) {
            p.drawImage(enemyimage.getImage(), enemy.getPosX(), enemy.getPosY(), enemy.getSide(), enemy.getSide(),
                    null);
        }

        ImageIcon eliteimage = new ImageIcon("src/images/elite.png", "elite");
        for (Elite elite : elites) {
            p.drawImage(eliteimage.getImage(), elite.getPosX(), elite.getPosY(), elite.getSide(), elite.getSide(),
                    null);
        }

        ImageIcon asteroidimage = new ImageIcon("src/images/asteroid.png", "asteroid");
        for (Asteroid asteroid : asteroids) {
            p.drawImage(asteroidimage.getImage(), asteroid.getPosX(), asteroid.getPosY(), asteroid.getSide(),
                    asteroid.getSide(), null);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyChar() == 'w') {
            up = true;
        }
        if (e.getKeyChar() == 's') {
            down = true;
        }
        if (e.getKeyChar() == 'a') {
            left = true;
        }
        if (e.getKeyChar() == 'd') {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            up = false;
        }
        if (e.getKeyChar() == 's') {
            down = false;
        }
        if (e.getKeyChar() == 'a') {
            left = false;
        }
        if (e.getKeyChar() == 'd') {
            right = false;
        }
    }

    @Override
    public void run() {
        while (!gameOver) {
            try {
                Thread.sleep(16);
            } catch (Exception e) {
            }
            player.move(up, down, left, right);

            for (Enemy enemy : enemies) {
                if ((enemy.getPosX() > player.getCurrentPosX()
                        && enemy.getPosX() < (player.getCurrentPosX() + player.getSide()))
                        && (enemy.getPosY() > player.getCurrentPosY()
                                && enemy.getPosY() < (player.getCurrentPosY() + player.getSide()))) {
                    gameOver = true;
                    break;
                }
                enemy.setDirection((int) Math.floor((Math.random() * 900)));
                enemy.move();
            }
            for (Elite elite : elites) {
                if ((elite.getPosX() > player.getCurrentPosX()
                        && elite.getPosX() < (player.getCurrentPosX() + player.getSide()))
                        && (elite.getPosY() > player.getCurrentPosY()
                                && elite.getPosY() < (player.getCurrentPosY() + player.getSide()))) {
                    gameOver = true;
                    break;
                }
                elite.move(player.getCurrentPosX(), player.getCurrentPosY());
            }
            for (Asteroid asteroid : asteroids) {
                if ((asteroid.getPosX() > player.getCurrentPosX()
                        && asteroid.getPosX() < (player.getCurrentPosX() + player.getSide()))
                        && (asteroid.getPosY() > player.getCurrentPosY()
                                && asteroid.getPosY() < (player.getCurrentPosY() + player.getSide()))) {
                    gameOver = true;
                    break;
                }
                asteroid.move();
            }

            if ((player.getCurrentPosX() >= goal.getPosX()
                    && player.getCurrentPosX() <= goal.getPosX() + goal.getSize())
                    && (player.getCurrentPosY() >= goal.getPosY()
                            && player.getCurrentPosY() <= goal.getPosY() + goal.getSize())) {
                player.setCurrentPosX(player.getStartPosX());
                player.setCurrentPosY(player.getStartPosY());
                goal.reposition();
                for (Enemy enemy : enemies) {
                    enemy.reposition();
                }
                for (Elite elite : elites) {
                    elite.reposition();
                }
                score++;
                if (score > 14) {
                    for (Asteroid asteroid : asteroids) {
                        asteroid.setSpeed(asteroid.getSpeed() + 1);
                    }
                } else if (score > 10) {
                    goalsrc = "src/images/saturn.png";
                    asteroids.add(new Asteroid((int) (Math.random() * 500) + 150));
                } else if (score > 8) {
                    for (Elite elite : elites) {
                        elite.setSpeed(elite.getSpeed() + 1);
                    }
                } else if (score > 5) {
                    goalsrc = "src/images/mars.png";
                    elites.add(new Elite((int) (Math.random() * 100 + 600), (int) (Math.random() * 100 + 450)));
                } else {
                    player.setSpeed(player.getSpeed() + 1);
                    for (Enemy enemy : enemies) {
                        if (enemy.getSpeed() < 10) {
                            enemy.setSpeed(enemy.getSpeed() + 1);
                        }
                    }
                    if (enemies.size() < score) {
                        enemies.add(new Enemy((int) (Math.random() * 300 + 100), (int) (Math.random() * 500)));
                    }
                }

            }

            this.repaint();
        }
    }

}
