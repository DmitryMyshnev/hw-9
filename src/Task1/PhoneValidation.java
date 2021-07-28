package Task1;

import java.io.FileReader;
import java.io.IOException;


public class PhoneValidation {
    public String getValidationPhones(String fileName){
        String gotPhones = new String();
        String result = new String();
        boolean isSuccessful = true;
        char[] templatePhone = new char[]{'(','x','x','x',')',' ','x','x','x','-','x','x','x','x'};
        char[] templatePhone2 = new char[]{'x','x','x','-','x','x','x','-','x','x','x','x'};

        try (FileReader reader = new FileReader(fileName)){
            int c;
            while ((c = reader.read()) != -1) {
                gotPhones += (char) c;
            }
            String[] phones = gotPhones.split("\r\n");
            for (String st : phones) {
                if (st.length() == 14) {
                    for (int i = 0; i < st.length(); i++) {
                        if (i == 0 || i == 4 || i == 5 || i == 9) {
                            if (st.charAt(i) != templatePhone[i]) {
                                isSuccessful = false;
                                break;
                            }
                        } else if (!Character.isDigit(st.charAt(i))) {
                            isSuccessful = false;
                            break;
                        }
                    }
                }else {
                    if (st.length() == 12) {
                        for (int i = 0; i < st.length(); i++) {
                            if (i == 3 || i == 7) {
                                if (st.charAt(i) != templatePhone2[i]) {
                                    isSuccessful = false;
                                    break;
                                }
                            } else if (!Character.isDigit(st.charAt(i))) {
                                isSuccessful = false;
                                break;
                            }
                        }
                    } else {
                        isSuccessful = false;
                    }
                }
                    if (isSuccessful) {
                        result += st + "\n";
                    }
                    else {isSuccessful = true;}
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
