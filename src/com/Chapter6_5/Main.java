package com.Chapter6_5;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String text = "this is example 1.";
        try(FileOutputStream fos = new FileOutputStream("/Users/stanislavderkach/Documents/Java/savedText2.txt")) {
            PrintStream ps1 = new PrintStream(fos);
            ps1.println("This is from the ps the object.");
            ps1.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis = new FileInputStream("/Users/stanislavderkach/Documents/Java/savedText2.txt")) {
            int tmp;
            while ((tmp = fis.read()) != -1){
                System.out.print((char)tmp + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(PrintWriter pw = new PrintWriter("/Users/stanislavderkach/Documents/Java/savedText3.txt")) {
            pw.println("This is from ps object.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try(FileInputStream fis2 = new FileInputStream("/Users/stanislavderkach/Documents/Java/savedText3.txt")) {
            int tmp;
            while ((tmp = fis2.read()) != -1){
                System.out.print((char)tmp + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
