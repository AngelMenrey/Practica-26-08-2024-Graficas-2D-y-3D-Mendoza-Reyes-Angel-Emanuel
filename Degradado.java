import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.MultipleGradientPaint.CycleMethod;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Degradado extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Degradado frame = new Degradado();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Degradado() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Degradado");
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                g2d.setColor(new Color(51, 200, 255));
                g2d.fillRect(0, 0, getWidth(), getHeight());

                g2d.setColor(Color.WHITE);
                g2d.drawString("--Tipos de lineas--", 50, 50);

                g2d.setColor(Color.BLACK);
                float[] guiones1 = {10, 10};
                float[] guiones2 = {21, 9, 3, 9};
                float[] guiones3 = {25, 25};
                float[] guiones4 = {5};

                g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, guiones1, 0));
                g2d.drawLine(50, 80, 150, 180);
                g2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, guiones2, 0));
                g2d.drawLine(150, 80, 250, 180);
                g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 0, guiones3, 0));
                g2d.drawLine(250, 80, 350, 180);
                g2d.setStroke(new BasicStroke(5, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND, 0, guiones4, 0));
                g2d.drawLine(350, 80, 450, 180);
                g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, guiones1, 0));
                g2d.drawRect(500, 80, 100, 100);
                g2d.drawOval(650, 80, 100, 100);

                g2d.setColor(Color.WHITE);
                g2d.drawString("--Imagenes--", 50, 240);
                ImageIcon react1 = new ImageIcon(getClass().getResource("/java.png"));
                g2d.drawImage(react1.getImage(), 50, 250, 100, 80, this);
                ImageIcon react2 = new ImageIcon(getClass().getResource("/mano.png"));
                g2d.drawImage(react2.getImage(), 180, 240, 100, 80, this);

                g2d.setColor(Color.WHITE);
                g2d.drawString("--Degradado--", 50, 350);
                GradientPaint degradado = new GradientPaint(0, 0, Color.BLUE, 150, 180, Color.CYAN, true);
                g2d.setPaint(degradado);
                g2d.fillRect(50, 360, 150, 180);

                GradientPaint degradado2 = new GradientPaint(0, 0, Color.BLACK, 0, 180, Color.YELLOW, true);
                g2d.setPaint(degradado2);
                g2d.fillOval(230, 360, 180, 180);

                g2d.setColor(Color.WHITE);
                g2d.drawString("--Degradado radial--", 430, 350);

                Point2D puntoCentral = new Point2D.Float(360, 360);
                float radio = 150;
                Point2D foco = new Point2D.Float(360, 360);
                float[] distribucionColor = {0.0f, 0.5f, 1.0f};
                Color[] colores = {Color.RED, Color.WHITE, Color.ORANGE};
                RadialGradientPaint degradadoR = new RadialGradientPaint(puntoCentral, radio, foco, distribucionColor, colores, CycleMethod.REPEAT);
                g2d.setPaint(degradadoR);
                g2d.fillOval(430, 360, 120, 100);

                g.setColor(Color.WHITE);
                g.drawString("--Texturizado--", 550, 240);
                BufferedImage buffer = new BufferedImage(80, 80, BufferedImage.TYPE_INT_RGB);
                Graphics2D textura = buffer.createGraphics();
                textura.setColor(Color.DARK_GRAY);
                textura.fillRect(0, 0, 80, 80);
                textura.setColor(Color.GREEN);
                textura.fillRect(20, 20, 20, 20);
                textura.fillRect(40, 40, 20, 20);
                textura.setColor(Color.BLACK);
                textura.fillRect(40, 20, 20, 20);
                textura.fillRect(20, 40, 20, 20);

                TexturePaint texturaImage = new TexturePaint(buffer, new Rectangle(80, 80));
                g2d.setPaint(texturaImage);
                g2d.fillOval(550, 250, 200, 200);

                try {
                    BufferedImage buffer1 = ImageIO.read(this.getClass().getResource("/ladrillos.png"));
                    TexturePaint texturaLadrillo = new TexturePaint(buffer1, new Rectangle(30, 30));
                    g2d.setPaint(texturaLadrillo);
                    g2d.fillOval(600, 460, 120, 100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);
    }
}