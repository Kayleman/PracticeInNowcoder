package kayle.practice.nowcoder;

/*
 * 利用位运算来实现加减乘除，有时候编写程序中遇到不允许使用加减乘除的时候能用上。
 * */
public class Arithmetic {

    //非递归实现的加法
    public int add(int a, int b) {
        int sum = a;
        int carry = b;
        while (carry != 0) {      //进位如果不为0就一直加
            int tmp = sum;

            sum = tmp ^ carry;
            carry = (tmp & carry) << 1;
        }
        return sum;
    }

    //递归实现的加法
    public int add_recursion(int a, int b) {
        if (b == 0)
            return b;

        int sum = a ^ b;
        int carry = (a & b) << 1;

        return add_recursion(sum, carry);
    }

    //减法
    public int subtract(int a, int b) {
        int subtrahend = add(~b, 1); //将b的正数变成负数，就转化为加法了。
        //正数的相反数刚好是按位取反+1
        int sub = add(a, subtrahend);
        return sub;
    }

    //累加的乘法
    public int multiply(int a, int b) {
        //将乘数和被乘数都取绝对值
        int multiplier = a < 0 ? add(~a, 1) : a;
        int multiplicand = b < 0 ? add(~b, 1) : b;

        //计算绝对值的乘积，乘法转化为多次加法
        int product = 0;
        int count = 0;

        while (count < multiplier) {
            product = add(product, multiplicand);
            count = add(count, 1); // count++
        }

        //计算乘积的符号
        if ((a ^ b) < 0) {
            product = add(~product, 1); // 如果相与小于0，说明是负号，则要按位取反+1求相反数。
        }

        return product;
    }

    //优化后的乘法
    public int multiply_optimize(int a, int b) {
        //将乘数和被乘数都取绝对值
        int multiplier = a < 0 ? add(~a, 1) : a;
        int multiplicand = b < 0 ? add(~b, 1) : b;

        //计算绝对值的乘积，乘法转化为多次加法
        int product = 0;

        while (multiplier != 0) {
            if ((multiplier & 0x1) != 0) { //0x1表示的就是00000001，用来判断最后一位是否为1，是的话就加
                product = add(product, multiplicand);
            }

            multiplicand = multiplicand << 1; //不管加没加，都左移一次
            multiplier = multiplier >> 1;     //最右一位判断完了，右移，准备判断下一位
        }

        //计算乘积的符号
        if ((a ^ b) < 0) {
            product = add(~product, 1); // 如果相与小于0，说明是负号，则要按位取反+1求相反数。
        }

        return product;
    }

    //求商
    public int divide(int a, int b) {
        //对被除数和除数取绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;

        //对被除数和除数的绝对值求商
        int remainder = dividend;
        int quotient = 0;
        while (remainder >= divisor) {
            remainder = subtract(remainder, divisor);
            quotient = add(quotient, 1);
        }

        //求商的符号
        if ((a ^ b) < 0) {
            quotient = add(~quotient, 1);
        }

        return quotient;
    }

    //求余
    public int remainder(int a, int b) {
        //对被除数和除数取绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;

        //对被除数和除数的绝对值求商
        int remainder = dividend;
        int quotient = 0;
        while (remainder >= divisor) {
            remainder = subtract(remainder, divisor);
            quotient = add(quotient, 1);
        }

        //求余的符号
        if (a < 0) {
            remainder = add(~remainder, 1);
        }

        return remainder;
    }


    //优化后的求商
    public int divide_optimize(int a, int b) {
        //对被除数和除数取绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : b;

        //获得被除数的反序 比如dividend=101011 invert=1110101,invert最高位会多一个1,
        // 这是为了防止dividend=1010,则直接反转为0101,这个时候原来的最低位的0就会丢失
        int invert = 2;
        while (dividend != 0) {
            invert |= dividend & 0x1;
            invert = invert << 1;
            dividend = dividend >> 1;
        }

        int quotient = 0;
        int remainder = 0;
        //排除最高位为1
        while (invert > 1) {
            remainder = remainder << 1;
            remainder |= invert & 0x1;
            invert = invert >> 1;
            quotient = quotient << 1;

            if (remainder >= divisor) {
                quotient |= 0x1;
                remainder = subtract(remainder, divisor);
            }
        }

        //求商的符号
        if ((a ^ b) < 0) {
            quotient = add(~quotient, 1);
        }

        return quotient;
    }

    //优化后的求余
    public int remainder_optimize(int a, int b) {
        //对被除数和除数取绝对值
        int dividend = a < 0 ? add(~a, 1) : a;
        int divisor = b < 0 ? add(~b, 1) : a;

        //获得被除数的反序 比如dividend=101011 invert=1110101,invert最高位会多一个1,
        //这是为了防止dividend=1010,则直接反转为0101,这个时候原来的最低位的0就会丢失
        int invert = 2;
        while (dividend != 0) {
            invert |= dividend & 0x1;
            invert = invert << 1;
            dividend = dividend >> 1;
        }

        int quotient = 0;
        int remainder = 0;

        //排除最高位为1
        while (invert > 1) {
            remainder = remainder << 1;
            remainder |= invert & 0x1;
            invert = invert >> 1;
            quotient = quotient << 1;

            if (remainder >= divisor) {
                quotient |= 0x1;
                remainder = subtract(remainder, divisor);
            }
        }
        //求余的符号
        if (a < 0) {
            remainder = add(~remainder, 1);
        }

        return remainder;
    }
}
