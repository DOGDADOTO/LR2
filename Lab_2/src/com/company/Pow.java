package com.company;

import java.text.NumberFormat;

public class Pow implements Function{

    private  Function term;
    private  double _coef;
    private  double power;
    public  Pow (double pow,Function term,double coef)
    {
        _coef=coef;
        this.term=term;
        power = pow;
    }

    @Override
    public double calculate(double x)
    {
            return _coef*Math.pow(term.calculate(x),power);
    }
    @Override
    public Function derivative()
    {
        if(power==1)
            return new Multiplication(Const.of(_coef),term,term.derivative());
        if(power==2)
            return new Multiplication(Pow.of(1,term,_coef*power),term.derivative());
        else
           return new Multiplication( Pow.of(power-1,term,power*_coef),term.derivative());
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
           return String.format("%s*(%s)^%s",nf.format(_coef),term.toPrettyString(nf),nf.format(power));
        else
            return String.format("(%s)^%s",term.toPrettyString(nf),nf.format(power));
    }
    public  static Pow of(double pow,Function term,double coef)
    {
        return new Pow(pow,term,coef);
    }

}
