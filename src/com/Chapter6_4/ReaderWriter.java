package com.Chapter6_4;

import java.io.*;
import java.util.Scanner;

public class ReaderWriter {
    private byte[] arr;
    Scanner in = new Scanner(System.in);
    private String text;

    public void set_value(){
        System.out.println("Enter your phrase:");
        text = in.nextLine();
        arr = new byte[text.length()];
        arr = text.getBytes();
    }
    public void read_value(){
        ByteArrayInputStream bais = new ByteArrayInputStream(arr);
        try(BufferedInputStream bis = new BufferedInputStream(bais)) {
            int x;
            while ((x = bis.read()) != -1){
                System.out.print((char)x + "\t");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write_value() {
        System.out.println("\nFrom write method");
        for (byte x: arr) {
            System.out.print((char)x +" ");
        }
        try(FileOutputStream fos = new FileOutputStream("/Users/stanislavderkach/Documents/Java/savedText3.txt")){
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(arr, 0, arr.length -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

