package cn.bt.btdemo.test;

public class Test03 {
    public static void main(String[] args) {
        short s1 = 1;
        short s2 = 2;
        s1 += 2;

        float f1 = 1f;
        float f2 = 2f;
        float f3 = f1 + f2;

        int i = -66;
        System.out.println(Integer.toBinaryString(127));
        System.out.println(Integer.toBinaryString(0b01111111*2));
        System.out.println(Integer.parseInt("11101011",2));

        System.out.println(Integer.MAX_VALUE * 2);
    }
}
