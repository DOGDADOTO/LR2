package com.company;

import java.text.NumberFormat;

public class Cos implements Function{
    private  Function term;
    private  double _coef;

    public  Cos (Function term,double coef)
    {
        _coef=coef;
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return _coef*Math.cos(term.calculate(x));
    }
    @Override
    public Function derivative()
    {
        return new Multiplication(
                Sin.of(term,-_coef),
                term.derivative()
        );
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
            return String.format("%s*cos(%s)",nf.format(_coef),term.toPrettyString(nf));
        else
            return String.format("cos(%s)",term.toPrettyString(nf));
    }
    public  static Cos of(Function term,double coef)
    {
        return new Cos(term,coef);
    }

}
