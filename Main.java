import javax.swing.JFrame;
import src.graphics.Tela;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Boa Sorte :)");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tela tela = new Tela();
        frame.add(tela);
        frame.addKeyListener(tela);
        frame.setVisible(true);
        frame.setResizable(false);

        tela.run();
    }
}
