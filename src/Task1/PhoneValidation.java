package Task1;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PhoneValidation {
    public String getValidationPhones(String fileName) {
        String gotPhones = new String();
        String result = new String();

        try (FileReader reader = new FileReader(fileName)) {
            int c;
            while ((c = reader.read()) != -1) {
                gotPhones += (char) c;
            }
            Pattern pattern = Pattern.compile(("[(]\\d\\d\\d[)]\\s\\d\\d\\d[-]\\d\\d\\d\\d"));
            Pattern pattern2 = Pattern.compile(("\\d\\d\\d[-]\\d\\d\\d[-]\\d\\d\\d\\d"));

            Matcher matcher = pattern.matcher(gotPhones);
            while (matcher.find()) {
                result += matcher.group() + "\r\n";
            }
            matcher = pattern2.matcher(gotPhones);
            while (matcher.find()) {
                result += matcher.group() + "\r\n";
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
