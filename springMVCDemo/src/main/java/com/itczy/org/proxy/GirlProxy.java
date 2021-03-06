package com.itczy.org.proxy;

/**
 * 静态代理(代理了Girl类)
 * 1.可以修改方法的返回值
 * 2.可以在方法前后加修饰
 *
 * 这种代理方式非常死板，被代理类中的private方法不能被代理
 */
public class GirlProxy implements Human{

    private Human human;

    public GirlProxy() {
        super();
    }

    public GirlProxy(Human human) {
        this.human = human;
    }

    @Override
    public void eat() {
        System.out.println("吃前");
        human.eat();
        System.out.println("吃后");
    }
}
