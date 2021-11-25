package com.company;

import java.text.NumberFormat;

public class Exp implements Function{

    private  Function term;
    private  double _coef;

    public  Exp (Function term,double coef)
    {
        _coef=coef;
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return _coef*Math.exp(term.calculate(x));
    }
    @Override
    public Function derivative()
    {
        return new Multiplication(
                Exp.of(term,_coef),
                term.derivative()
        );
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
            return String.format("%s*e^(%s)",nf.format(_coef),term.toPrettyString(nf));
        else
            return String.format("e^(%s)",term.toPrettyString(nf));
    }
    public  static Exp of(Function term,double coef)
    {
        return new Exp(term,coef);
    }

}
