package com.company;

import java.text.NumberFormat;

public class Ln implements Function{


    private  Function term;
    private  double _coef;
    public  Ln (Function term,double coef)
    {
        _coef=coef;
        this.term=term;
    }

    @Override
    public double calculate(double x)
    {
        return Math.log(term.calculate(x))*_coef;
    }
    @Override
    public Function derivative()
    {
            return new Multiplication(Pow.of(-1,term,_coef),term.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
            return String.format("%s*ln|%s|",nf.format(_coef),term.toPrettyString(nf));
        else
            return String.format("ln|%s|",term.toPrettyString(nf));
    }
    public  static Ln of(Function term,double coef)
    {
        return new Ln(term,coef);
    }

}
