package com.zarek.demo;

/**
 * @author zhao
 * @date 2021/2/27 20:47
 */
public class Main {

    public static void main(String[] args)
    {
        new SubClass().opration();
    }

}


abstract class AbstractClass{

    public void opration(){

        System.out.println("step1");

        System.out.println("step2");

        System.out.println("step3");

        templateMethod();

    }

    abstract protected void templateMethod();


}

class SubClass extends AbstractClass{

    @Override
    protected void templateMethod()
    {
        System.out.println("SubClass executed...");
    }
}