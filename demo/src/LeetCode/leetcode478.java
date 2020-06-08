package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/5/22 12:45 下午
 * @description
 */
public class leetcode478 {
    double rad, xc, yc;

    public leetcode478(double radius, double x_center, double y_center) {
        this.rad = radius;
        this.xc = x_center;
        this.yc = y_center;
    }

    public double[] randPoint() {
        double xL = xc - rad;
        double yD = yc - rad;
        while (true) {
            double xR = xL + Math.random() * 2 * rad;
            double yR = yD + Math.random() * 2 * rad;
            if (Math.sqrt(Math.pow(xR - xc, 2) + Math.pow(yR - yc, 2)) < rad){
                return new double[]{xR, yR};
            }
        }
    }
}
