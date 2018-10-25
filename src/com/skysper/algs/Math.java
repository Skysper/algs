package com.skysper.algs;

public class Math {
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    public static double abs(double x) {
        if (x < 0.0) {
            return -x;
        } else {
            return x;
        }
    }

    public static  boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for(int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 开方求值
     * 牛顿迭代法
     * 正常来说：f(x) = 0 则
     * 假设临近点为(x0,f(x0))
     * 则此点切线方程为：y = f'(x0)(x-x0) + f(x0) 此时与x轴的交点为：
     * x1 = x0 - f(x0)/f'(x0),
     * 参考0点在x轴的抛物线，则 递归x1点一定不断临近0点，小于一定误差值 1e-15则认为是需要求的值
     *
     * sqrt 则求 f(x) = x^2 - c 的根
     * f'(x) = 2x
     * x1 = x0 - f(x0)/f'(x0)
     * => Xn+1 = Xn + (Xn^2-c)/2Xn = 1/2(Xn + c/Xn)
     * 终结条件 Xn+1 - Xn <= 1e-15
     * @param c
     * @return
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double e = 1e-15;
        double x = c;
        double x1 = (c/x + x) / 2.0;
        while(abs(x1 - x) > e) {
            x = x1;
            x1 = (c/x + x) / 2.0;
        }
        return x;
    }

    /**
     * 直角三角形第三条边
     * @param a
     * @param b
     * @return
     */
    public static double hypotenuse(double a, double b) {
        return sqrt(a*a + b*b);
    }

    /**
     * 调和函数 1 + 1/2 + 1/3 + ... + 1/n
     * @param n
     * @return
     */
    public static double harmonic(int n) {
        double sum = 0.0;
        for(int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

}
