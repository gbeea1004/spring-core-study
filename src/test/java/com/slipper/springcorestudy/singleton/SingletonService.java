package com.slipper.springcorestudy.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    private SingletonService() {}

    public void logic() {
        System.out.println("로직");
    }

    public static SingletonService getInstance() {
        return instance;
    }
}
