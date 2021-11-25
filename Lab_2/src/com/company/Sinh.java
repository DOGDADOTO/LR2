package com.company;

import java.text.NumberFormat;

public class Sinh implements Function {
    private  Function term;
    private  double _coef;

    public Sinh(Function term, double coef) {
        this.term = term;
        _coef = coef;
    }

    @Override
    public double calculate(double x) {
        return _coef*Math.sinh(term.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(
                Cosh.of(term,_coef),
                term.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
            return String.format("%s*sinh(%s)",nf.format(_coef),term.toPrettyString(nf));
        else
            return String.format("sinh(%s)",term.toPrettyString(nf));
    }
    public  static Sinh of(Function term,double coef)
    {
        return new Sinh(term,coef);
    }
}
