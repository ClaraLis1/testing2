package Selenium.ExtentReports;



import com.relevantcodes.extentreports.ExtentReports;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class reports {

    public static ExtentReports getInstance(){
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        SimpleDateFormat formatDate = new SimpleDateFormat("ddMMyyHHmm");
        String dateText = formatDate.format(date);
        String Path = ("src/test/resources/reports/"+dateText+".html");

        ExtentReports extent = new ExtentReports(Path, false);
        return extent;

    };
}
