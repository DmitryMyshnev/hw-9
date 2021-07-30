package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GetUsers {
    private final String PATH = "src/Task2/user.json";

    public List<User> getData(String fileName) {
        List<User> listUsers = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNext()) {
                String[] data = scanner.nextLine().split(" ");
                if (!data[0].equalsIgnoreCase("name") && !data[1].equalsIgnoreCase("age")) {
                    listUsers.add(new User(data[0], Integer.valueOf(data[1])));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listUsers;
    }

    public void createFileFromJson(List<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        File file = new File(PATH);

        try (FileWriter writeJson = new FileWriter(file)) {

            writeJson.write(json);
            writeJson.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
