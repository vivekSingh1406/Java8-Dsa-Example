package org.DesignLLD;

public class SingletonDesign {

    public static SingletonDesign singletonDesign;
    private SingletonDesign(){}

    public static SingletonDesign getInstance(){

        if(singletonDesign==null){
            singletonDesign = new SingletonDesign();
        }
        return singletonDesign;
    }

    public static void main(String[] args) {


        SingletonDesign s1 = SingletonDesign.getInstance();
        SingletonDesign s2 = SingletonDesign.getInstance();

        if(s1==s2) System.out.println("true");


    }
}
