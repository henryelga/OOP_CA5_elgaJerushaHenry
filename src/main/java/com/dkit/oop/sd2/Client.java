package com.dkit.oop.sd2;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/** Main author: Annita Mila Chuenglin */
public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.start(8888);
    }

    public void start(int portNumber) {
        try (
                Socket socket = new Socket("localhost", 8888);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outputStream, true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Scanner scanner = new Scanner(System.in)) {

            System.out.println("The client is running and has connected to the server.");

            while(true){
                System.out.println("====== Menu ======");
                System.out.println("1. Display Entity by Id");
                System.out.println("2. Display All Entities");
                System.out.println("3. Add an Entity");
                System.out.println("4. Delete an Entity by Id");
                System.out.println("5. Get Images List");
                System.out.println("6. Exit");
                System.out.print("Enter option: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch(option) {
                    /** Main author: Annita Mila Chuenglin */
                    case 1:
                        System.out.println("Enter the entity ID to display: ");
                        int entityId = scanner.nextInt();
                        scanner.nextLine();
                        out.println("displayEntityById "+entityId);
                        String response = in.readLine();
                        System.out.println("In client: The server response was : " + response);
                        break;
                    /** Main author: Annita Mila Chuenglin */
                    case 2:
                        System.out.println("Displaying all entities.");
                        out.println("displayAllEntities");
                        response = in.readLine();
                        System.out.println("In client: The server response was : " + response);
                        break;
                    case 3:
                        System.out.println("Exiting..");
                        return;
                    case 4:
                        System.out.println("Exiting...");
                        return;
                    case 5:
                        System.out.println("Exiting....");
                        return;
                    case 6:
                        System.out.println("Exiting.....");
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 to 6.");
                }
            }

        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
