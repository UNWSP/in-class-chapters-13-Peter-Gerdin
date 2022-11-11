import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.nio.file.*;

public class WriteCustomerList {
    public static void main(String[] arg){
        Scanner inputDevice = new Scanner(System.in);
        String[] array = new String[3];
        String s = "";
        String delimiter = ",";
        String id;
        String fName;
        String lName;
        double Balance;


        Path file = Paths.get("customers.txt");
        final String QUIT = "Q";

        try{
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            System.out.print("Enter ID number or type 'Q' to quit >> ");
            id = inputDevice.nextLine();
            while(!id.equals(QUIT)){
                System.out.println("Enter the first name >> ");
                fName = inputDevice.nextLine();
                System.out.println("Enter the last name >> ");
                lName = inputDevice.nextLine();
                System.out.println("Enter the balance owed >> ");
                Balance = Double.parseDouble(inputDevice.nextLine());

                s = id + delimiter + fName + delimiter + lName + delimiter + Balance + System.getProperty("line.separator");
                writer.write(s, 0, s.length());

                System.out.print("Enter ID number or type 'Q' to quit >> ");
                id = inputDevice.nextLine();
            }
            writer.close();
        }
        catch (Exception e){
                System.out.println("ERROR: " + e);
        }
    }
}
