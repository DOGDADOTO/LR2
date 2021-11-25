package com.company;

import java.text.NumberFormat;

public class Linear implements Function{

    public static final Linear X = new Linear(1){
        @Override
        public String toPrettyString(NumberFormat nf)
        {
            return "x";
        }
    };

    private double _coef;

    public Linear(double coef)
    {
        _coef=coef;
    }
    
    @Override
    public double calculate(double x)
    {
        return x*_coef;
    }
    @Override
    public Function derivative()
    {
        return new Const(_coef);
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        if(_coef!=1)
            return String.format("%s*x",nf.format(_coef));
        else
            return  String.format("x");
    }
    public static Linear of(double coef)
    {
        return new Linear(coef);
    }

}
