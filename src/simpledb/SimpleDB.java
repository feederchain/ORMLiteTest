package simpledb;

import java.util.Scanner;

/**
 *
 * @author gregbeauregard
 */
public class SimpleDB {

    public static void main(String[] args) throws Exception {
        DatabaseWork work;
        try (Scanner read = new Scanner(System.in)) {
            String input = read.nextLine();
            if (input.equals("1")) {
                work = new NoORM();
            } else {
                work = new ORMLite();
            }
        }
        work.doWork();
    }
    
}
