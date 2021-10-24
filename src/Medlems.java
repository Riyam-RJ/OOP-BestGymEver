import java.io.*;
import java.text.ParseException;

public class Medlems {

    HelperClass helperClass = new HelperClass();

    public int isMedlem(String input){
        String fullName = null;
        int commaPlats = 10;
        int startIndex;
        int endIndex;
        boolean kollaDatum = false;

        // read the file using bufferReader
        try {
            File file = new File("customers.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null){

                if(line.length() > 11){

                    if(input.matches("[0-9]{10}")){
                        fullName = line.substring(commaPlats + 2);
                        startIndex = 0;
                        endIndex = commaPlats;

                    }else{
                        fullName = input;
                        startIndex = commaPlats + 2;
                        endIndex = line.length();
                    }

                    String result = line.substring(startIndex, endIndex);

                    if (input.equalsIgnoreCase(result)){
                        kollaDatum = true;
                        break;
                    }
                }
            }

            if(kollaDatum){
                String dateToCheck = br.readLine();
                boolean isAnnualFeePaid = helperClass.isTheAnnualFeePaid(dateToCheck);
                if(isAnnualFeePaid){
                    helperClass.writeToMedlemsFile(fullName);
                    return 0;
                }else{
                    return 1;
                }
            }
            else{
                return 2;
            }
        }
        catch (FileNotFoundException exception) {
            throw new AssertionError("Det går inte och hitta filen");
        }
        catch (IOException | ParseException exception) {
            throw new AssertionError(exception);
        }

    }
}