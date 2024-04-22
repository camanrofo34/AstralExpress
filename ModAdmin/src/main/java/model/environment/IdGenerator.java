package model.environment;

import java.io.*;

public class IdGenerator {
    /**
     * Generate id for employee
     * @return
     * @throws Exception
     */
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
    /**
     * Generate id for train
     * @return
     * @throws Exception
     */
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
    /**
     * Generate id for ticket
     * @return
     * @throws Exception
     */
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
