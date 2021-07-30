package Task3;

import java.io.File;
import java.util.*;

public class FrequencyWord {
    private final String path;

    public FrequencyWord(String path) {
        this.path = path;
    }

    public void getFrequency() {
        String[] line;
        Integer count = 1;
        Map<String, Integer> map = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNext()) {
                line = scanner.nextLine().split(" ");
                for (String st : line) {
                    if (map.containsKey(st)) {
                        count++;
                        map.put(st, count);
                    } else {
                        map.put(st, 1);
                    }
                }
                count = 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);

    }
}
