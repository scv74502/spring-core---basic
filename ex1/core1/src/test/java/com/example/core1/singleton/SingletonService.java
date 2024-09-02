package com.example.core1.singleton;

import javax.net.ssl.SSLContext;

public class SingletonService {
    // 자기 자신을 내부에 private static으로 가짐, 클래스에 고정된 멤버
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("singleton logic object call");
    }
}
