package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilities {

    public static String CurrentDateTime() {
        DateFormat df= new SimpleDateFormat("ddMMyyyyHHmmss");
        Date dateobj = new Date();
        Calendar calobj= Calendar.getInstance();
        //System.out.println(df.format(calobj.getTime()));
        String datetime = df.format(calobj.getTime());

        return (datetime);
    }


}
