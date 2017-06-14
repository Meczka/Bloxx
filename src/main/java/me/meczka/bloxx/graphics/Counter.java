package me.meczka.bloxx.graphics;

/**
 * Created by Patryk on 14.06.2017.
 */
public class Counter {
    private int number=0,nietrafione=0;
    public void add()
    {
        number++;
    }
    public void addNietrafione()
    {
        nietrafione++;
    }
    public int getNietrafione()
    {
        return nietrafione;
    }
    public int getNumber()
    {
        return number;
    }
}
