package starvation;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Worker {
    
    // synchronized garante que a execução deste 
    // método seja realizada por apenas uma Thread por vez
    public synchronized void work() {
        String name = Thread.currentThread().getName();
        String fileName = name + ".txt";
        int i = 0;
 
        try (
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        ) {
            writer.write("Thread " + name + " wrote this message");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
//        while(i<1) {
        while (true) {
            try {
                Thread.sleep(200);
                System.out.println(name);
                i++;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}