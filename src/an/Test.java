package an;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Test {

	public static void main(String[] args) {
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		Time time = new Time(System.currentTimeMillis());
		System.out.println(time);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
	}
	
	void play() {
		System.out.println(123);
	}

}
