package com.chapter6_3;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Action obj1 = new Action();
        try {
            obj1.set_data();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
