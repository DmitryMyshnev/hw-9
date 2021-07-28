import Task1.PhoneValidation;
import Task2.GetUsers;
import Task3.FrequencyWord;

import java.util.List;

public class Main {
    public static void main(String[] args) {
       PhoneValidation phoneValidation = new PhoneValidation();
       System.out.println(phoneValidation.getValidationPhones("src/Task1/file.txt"));

        GetUsers getUsers = new GetUsers();
       List users =  getUsers.getData("src/Task2/file.txt");
        getUsers.createFileFromJson(users);

        FrequencyWord freq = new FrequencyWord("src/Task3/word.txt");
        freq.getFrequency();
    }
}
