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
}
