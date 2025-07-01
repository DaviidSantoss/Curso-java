package David_Santos_app_Loggin;

import java.text.SimpleDateFormat;
import java.util.Date;

public class A02_Logger {

    public static void info(String msg) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	System.out.println("[INFO] " + sdf.format(new Date()) + " -" + msg);

    }

}
