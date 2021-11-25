package com.company;

import java.text.NumberFormat;

public class Const extends  Number implements Function{

    public static final Const ZERO = new Const(0);
    public static  final Const ONE = new Const (1);
    public static final Const NEGATIVE_ONE = new Const(-1);
    private  final double _value;

    public  Const(double value)
    {
        _value=value;
    }
    @Override
    public double calculate(double x)
    {
        return  _value;
    }
    @Override
    public Function derivative()
    {
        return ZERO;
    }
    @Override
    public String toPrettyString(NumberFormat nf)
    {
        return nf.format(_value);
    }
    @Override
    public int intValue()
    {
        return (int)_value;
    }
    @Override
    public long longValue()
    {
        return (long)_value;
    }
    @Override
    public float floatValue()
    {
        return (float)_value;
    }
    @Override
    public double doubleValue()
    {
        return (double)_value;
    }

    public static Const of(double value)
    {
        return new Const(value);
    }

}
