import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelperClass {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public boolean isTheAnnualFeePaid(String date) throws ParseException {
        String previousYear = getPreviousYear();
        String currentDate = sdf.format(new Date());

        Date startDate = sdf.parse(previousYear);
        Date endDate = sdf.parse(currentDate);
        Date dateToCheck = sdf.parse(date);

        return (dateToCheck.after(startDate) && (dateToCheck.before(endDate)));
    }

    private String getPreviousYear() {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);
        String previousYearDate = sdf.format(prevYear.getTime());

        return previousYearDate;
    }


    public void writeToMedlemsFile(String fullName) throws FileNotFoundException {
        String filename = fullName+".txt";
        File file = new File(filename);

        PrintWriter printWriter;
        if ( file.exists() ) {
            printWriter = new PrintWriter(new FileOutputStream(filename, true));
        }
        else {
            printWriter = new PrintWriter(filename);
        }
        printWriter.append(new Date()+"\n");
        printWriter.close();
    }

}