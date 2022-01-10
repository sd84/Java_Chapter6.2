package com.chapter6_3;

import java.io.*;
import java.util.Scanner;

public class Action {
    private byte[]arr;
    private byte[]buffer;
    private String temp;
    private int x;
    Scanner in = new Scanner(System.in);

    public void set_data() throws IOException {
        System.out.println("Enter your text:");
        temp = in.nextLine();
        buffer = new byte[temp.toCharArray().length];
        buffer = temp.getBytes();
        arr = buffer.clone();

        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        while ((x = bais.read()) != -1){
            System.out.print((char) x + "\t");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(arr);
        System.out.println("\nYour text is " + baos.toString());
        try(FileOutputStream fos = new FileOutputStream("/Users/stanislavderkach/Documents/Java/savedText2.txt")){
            fos.write(arr, 0, arr.length -1);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
