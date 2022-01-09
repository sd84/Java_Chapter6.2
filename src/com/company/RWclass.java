package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class RWclass {
    private String text;
    private byte[] arr;
    Scanner in = new Scanner(System.in);
    
    public void write_text(){
        try(FileOutputStream fout = new FileOutputStream("/Users/stanislavderkach/Documents/Java/savedText.txt")) {
            System.out.println("Enter your text to store:");
            text = in.next();
            arr = new byte[text.toCharArray().length];
            arr = text.getBytes();
            fout.write(arr, 0, arr.length);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void read_text(){
        try(FileInputStream fin = new FileInputStream("/Users/stanislavderkach/Documents/Java/savedText.txt")) {
            arr =  new byte[fin.available()];
            fin.read(arr,0, fin.available());
            for (byte x: arr) {
                System.out.print((char)x );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
