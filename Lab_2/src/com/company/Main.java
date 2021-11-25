package com.company;

import javax.sound.sampled.Line;
import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {


        double x = -4.1;
        double a = -0.7;
        double b = -0.3;


        final Function exp = Multiplication.of(Linear.of(1), Pow.of(2, Cos.of
                (Pow.of(3, Abs.of(Sum.of(Multiplication.of(Const.of(a), Linear.of(1)), Const.of(b)))
                        , 1), 1), 1));

        final NumberFormat nf = NumberFormat.getInstance();
        System.out.format("f(x)=%s", exp.toPrettyString(nf)).println();
        System.out.format("f'(x)=%s", exp.derivative().toPrettyString(nf)).println();
        System.out.format("f(-4.1)=%s", exp.calculate(x)).println();
        System.out.format("f'(-4.1)=%s", exp.derivative().calculate(x)).println();


    } // dogda
}
