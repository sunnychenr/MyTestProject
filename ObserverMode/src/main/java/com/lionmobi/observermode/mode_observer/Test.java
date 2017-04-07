package com.lionmobi.observermode.mode_observer;

import com.lionmobi.observermode.mode_observer.mode_impl.ObservableImpl;
import com.lionmobi.observermode.mode_observer.mode_impl.ObserverImpl;

/**
 * Created by ChenR on 2017/4/7.
 */

public class Test {

    public static void main (String [] args) {
        System.out.println("this a 语句");

        ObservableImpl observable = new ObservableImpl();

        ObserverImpl observer1 = new ObserverImpl();
        ObserverImpl observer2 = new ObserverImpl();
        ObserverImpl observer3 = new ObserverImpl();
        ObserverImpl observer4 = new ObserverImpl();
        ObserverImpl observer5 = new ObserverImpl();

        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.addObserver(observer3);
        observable.addObserver(observer4);
        observable.addObserver(observer5);

        observable.setData("China");
        observable.setData("Cananda");
        observable.setData("How do you do ???");
        observable.setData("How do you do ???");
        observable.setData("Fuck your one by one !!!");
    }
}
