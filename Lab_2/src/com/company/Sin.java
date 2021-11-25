package com.company;

import java.text.NumberFormat;

public class Sin implements Function{

    private  Function term;
    private  double _coef;

    public  Sin (Function term,double coef)
    {
        _coef=coef;
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return _coef*Math.sin(term.calculate(x));
    }
    @Override
    public Function derivative()
    {
        return new Multiplication(
                Cos.of(term,_coef),
                term.derivative()
        );
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
            return String.format("%s*sin(%s)",nf.format(_coef),term.toPrettyString(nf));
        else
            return String.format("sin(%s)",term.toPrettyString(nf));
    }
    public  static Sin of(Function term,double coef)
    {
        return new Sin(term,coef);
    }

}
