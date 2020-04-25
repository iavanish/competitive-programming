public class BouncingBall {

    public double getPosition(int g, int h, int p, int t) {
        double gg = g / 100.0;
        double hh = h;
        double pp = p;
        double tt = t;
        while (true) {
            double s = 0.5 * gg * tt * tt;
            if (s <= hh) {
                return hh - s;
            }
            double tempT = Math.sqrt((2.0 * hh) / gg);
            tt -= tempT;

            hh = hh - (hh * pp) / 100.0;

            tempT = Math.sqrt((2.0 * hh) / gg);
            if (tt <= tempT) {
                return hh - 0.5 * gg * (tempT - tt) * (tempT - tt);
            }
            tt -= tempT;
        }
    }

}
