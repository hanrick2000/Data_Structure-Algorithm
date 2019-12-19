package niuke;

public class Power {
    public double Power(double base, int exponent) {
        boolean flag = false;
        if (exponent == 0){
            return 1.0;
        }else if (exponent < 0){
            flag = true;
            exponent = -exponent;
        }


        if (base == 0.0){
            return 0.0;
        }

        if (base == 1.0){
            return 1.0;
        }

        double res = 1;
        for (int i = 0; i < exponent; i++) {
            res = res*base;
        }

        if (flag){
            return 1/res;
        }else {
            return res;
        }


    }
}
