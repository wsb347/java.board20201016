package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {
	SimpleDateFormat today = new SimpleDateFormat("yyyy.MM.dd");
	Calendar c1 = Calendar.getInstance();
	public String date = today.format(c1.getTime());

	SimpleDateFormat today2 = new SimpleDateFormat("HH:mm");
	Calendar c2 = Calendar.getInstance();
	public String time = today2.format(c2.getTime());
}
