package Snippets;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.System;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File_IO {

    public static void Reading() throws InterruptedException {
        try {
            File inputData = new File("ReadingText.txt");
            Scanner myReader = new Scanner(inputData);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                System.out.println(line);
                if (line.isEmpty()) {
                    TimeUnit.SECONDS.sleep(3);
                }
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
    }
    }

    public static void Writing() throws InterruptedException {
        try {
            FileWriter myWriter = new FileWriter("WritingText.txt", true);
            myWriter.write("I am writing in this file to text I know how \n");
            myWriter.write("42 is the answer to life \n");
            myWriter.write("010101010 \n");
            myWriter.write("true \n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
          }
    }
    public static void main(String[] args) throws InterruptedException {
        Reading();
        Writing();
    }
}