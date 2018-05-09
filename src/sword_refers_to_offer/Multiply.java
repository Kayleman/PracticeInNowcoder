package sword_refers_to_offer;

/*
* 题目描述:
* 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
* 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
*
* 解题思路：
* 1.题目要求不能使用除法，我为了试一试自己实现的除法能不能通过，
* 就在代码中使用了自己实现的代码，结果真的可以直接通过，哈哈！
* 不过这样做达不到提高自己解题思维，于是又写了另一个解。
*
* 2. B[i]的值可以看做下面矩阵中每行的乘积
*       1  A1 A2 ... An-2 An-1    一行乘积为 B0
*       A0 1  A2 ... An-2 An-1    一行乘积为 B1
*       A0 A1 1  ... An-2 An-1    一行乘积为 B2
*       A0 A1 A2 ... An-2 An-1    一行乘积为 ...
*       A0 A1 A2 ...  1   An-1    一行乘积为 Bn-2
*       A0 A1 A2 ... An-2  1      一行乘积为 Bn-1
*    所以可以先计算下三角的乘积，再倒过来乘以上三角的另一部分乘积，时间复杂度为O(n)
* */



public class Multiply {
    //使用自己实现的除法的方法一
    public int[] multiply(int[] A) {

        int multiply_A = 1;
        for (int i = 0; i < A.length; i++) {
            multiply_A *= A[i];
        }

        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if(A[i] == 0) {
                B[i] = 1;
                for (int j = 0; j < A.length; j++) {
                    if(j == i) {
                        continue;
                    } else {
                        B[i] *= A[j];
                    }
                }
            } else {
                B[i] = divide_optimize(multiply_A, A[i]);
            }
        }

        return B;
    }

    public int[] multiply_2(int[] A){
        int[] B = new int[A.length];
        if(A.length != 0) {
            B[0] = 1; //计算下三角的时候暂时将B[0]赋值为1，方便乘积
            for (int i = 1; i < A.length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }

            int tmp = 1;
            //计算上三角
            //j = A.length - 2 是因为倒数第一行下三角已经计算完毕，只需要从倒数第二行开始乘另一部分
            for (int j = A.length - 2; j >= 0 ; j--) {
                tmp *= A[j + 1];
                B[j] *= tmp;
            }
        }
        return B;
    }
    public static void main(String[] args) {
        Multiply mp = new Multiply();
        int[] A = {1, 2, 0, 4, 5};
        int[] B = mp.multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }

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

    //减法
    public int subtract(int a, int b) {
        int subtrahend = add(~b, 1); //将b的正数变成负数，就转化为加法了。
        //正数的相反数刚好是按位取反+1
        int sub = add(a, subtrahend);
        return sub;
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
}
