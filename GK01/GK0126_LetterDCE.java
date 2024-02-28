import java.awt.*;
import java.awt.geom.*;
import java.util.Date;

public class GK0126_LetterDCE extends Frame {

  public GK0126_LetterDCE() {
    addWindowListener(new MyFinishWindow());
  }

  public void paint(Graphics g) {

    Graphics2D g2d = (Graphics2D) g;
    g2d.drawString("Exercise 2.6", 50, 500);
    g2d.drawString("Evi Fitriya / 1201222005", 50, 550);

    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    BasicStroke bs = new BasicStroke(5.0f);
    g2d.setStroke(bs);

    // titik C
    int[] xc = { 0, 50, 250, 50, 250, 50 };
    int[] yc = { 0, 250, 50, 50, 450, 450 };

    // titik D
    int[] xd = { 0, 50, 50, 400, 50, 50 };
    int[] yd = { 0, 50, 450, 250, 450, 250 };

    // titik E
    int[] xe = { 0, 250, 250, 50, 250, 50 };
    int[] ye = { 0, 250, 50, 50, 450, 450 };

    QuadCurve2D.Double q1, q2;

    // gambar D
    q1 = new QuadCurve2D.Double(xd[1], yd[1], xd[3], yd[3], xd[2], yd[2]);
    q2 = new QuadCurve2D.Double(xd[1], yd[1], xd[5], yd[5], xd[4], yd[4]);
    g2d.draw(q1);
    g2d.draw(q2);

    sustain(1000);

    // Gambar C
    double x[] = new double[xc.length];
    double y[] = new double[x.length];
    double alpha;

    int steps = 500;
    double stepsDouble = steps;
    for (int i = 1; i <= steps; i++) {
      g2d.drawString("Exercise 2.6", 50, 500);
      g2d.drawString("Evi Fitriya / 1201222005", 50, 550);
      alpha = i / stepsDouble;

      for (int j = 1; j < x.length; j++) {
        x[j] = (1 - alpha) * xd[j] + alpha * xc[j];
        y[j] = (1 - alpha) * yd[j] + alpha * yc[j];
      }

      q1 = new QuadCurve2D.Double(x[1], y[1], x[3], y[3], x[2], y[2]);
      q2 = new QuadCurve2D.Double(x[1], y[1], x[5], y[5], x[4], y[4]);

      // clear
      clearWindow(g2d);

      // Draw the two quadratic curves.
      g2d.draw(q1);
      g2d.draw(q2);
      sustain(10);
    }

    // gambar E
    for (int i = 1; i <= steps; i++) {
      alpha = i / stepsDouble;

      for (int j = 1; j < x.length; j++) {
        x[j] = (1 - alpha) * xc[j] + alpha * xe[j];
        y[j] = (1 - alpha) * yc[j] + alpha * ye[j];
      }

      q1 = new QuadCurve2D.Double(x[1], y[1], x[3], y[3], x[2], y[2]);
      q2 = new QuadCurve2D.Double(x[1], y[1], x[5], y[5], x[4], y[4]);

      // clear
      clearWindow(g2d);

      g2d.draw(q1);
      g2d.draw(q2);

      sustain(10);
    }
  }

  public static void clearWindow(Graphics2D g) {
    g.setPaint(Color.white);
    g.fill(new Rectangle(0, 0, 270, 470));
    g.setPaint(Color.black);
  }

  public static void sustain(long t) {
    long finish = (new Date()).getTime() + t;
    while ((new Date()).getTime() < finish) {
    }
  }

  public static void main(String[] argv) {
    GK0126_LetterDCE f = new GK0126_LetterDCE();
    f.setTitle("Morph D-C-E");
    f.setSize(270, 470);
    f.setVisible(true);
  }
}
