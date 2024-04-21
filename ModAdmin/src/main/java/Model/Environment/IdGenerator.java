package Model.Environment;

import java.io.*;

public class IdGenerator {

    public static String generateEmployeeId() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/Model/IdFiles/idEmployees.txt")));
        String id = bufferedReader.readLine();
        String newId = String.valueOf(Integer.parseInt(id) + 1);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/resources/Model/IdFiles/idEmployees.txt")));
        bufferedWriter.write(newId);
        bufferedWriter.close();
        bufferedReader.close();
        return id;
    }

    public static String generateTrainId() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/Model/IdFiles/idTrains.txt")));
        String id = bufferedReader.readLine();
        String newId = String.valueOf(Integer.parseInt(id) + 1);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/resources/Model/IdFiles/idTrains.txt")));
        bufferedWriter.write(newId);
        bufferedWriter.close();
        bufferedReader.close();
        return id;
    }

    public static String generateTicketId() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("src/main/resources/Model/IdFiles/idTickets.txt")));
        String id = bufferedReader.readLine();
        String newId = String.valueOf(Integer.parseInt(id) + 1);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("src/main/resources/Model/IdFiles/idTickets.txt")));
        bufferedWriter.write(newId);
        bufferedWriter.close();
        bufferedReader.close();
        return id;
    }
}
