import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class HelperClassTest {

    @Test
    void isTheAnnualFeePaid() throws ParseException {
        HelperClass helperClass = new HelperClass();

        boolean isAnnualFeePaid = helperClass.isTheAnnualFeePaid("2021-05-01");
        assertEquals(true, isAnnualFeePaid);

        boolean isAnnualFeePaid2 = helperClass.isTheAnnualFeePaid("2019-05-01");
        assertEquals(false, isAnnualFeePaid2);
    }


    @Test
    void writeToMedlemsFile() throws FileNotFoundException {
        String fileName = "riyam";
        HelperClass helperClass = new HelperClass();
        helperClass.writeToMedlemsFile(fileName);
    }
}