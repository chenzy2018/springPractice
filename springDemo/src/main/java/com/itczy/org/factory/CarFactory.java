package com.itczy.org.factory;

/**
 * 汽车工厂类
 */
public class CarFactory {

    public static Car getCar(String name) throws Exception {
        if(name.endsWith("audi")){
            return new Audi();
        }else if(name.endsWith("bmw")){
            return new Bmw();
        }else{
            throw new Exception("暂时无法生产这种车");
        }
    }

    public Car getCar1(String name) throws Exception {
        if(name.endsWith("audi")){
            return new Audi();
        }else if(name.endsWith("bmw")){
            return new Bmw();
        }else{
            throw new Exception("暂时无法生产这种车");
        }
    }
}
