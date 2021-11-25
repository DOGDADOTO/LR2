package com.company;

import java.text.NumberFormat;

public class Cosh implements Function{
    private  Function term;
    private  double _coef;

    public Cosh(Function term, double coef) {
        this.term = term;
        _coef = coef;
    }

    @Override
    public double calculate(double x) {
        return _coef*Math.cosh(term.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(
                Sinh.of(term,_coef),
                term.derivative()
        );
    }

    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
            return String.format("%s*cosh(%s)",nf.format(_coef),term.toPrettyString(nf));
        else
            return String.format("cosh(%s)",term.toPrettyString(nf));
    }
    public  static Cosh of(Function term,double coef)
    {
        return new Cosh(term,coef);
    }
}
