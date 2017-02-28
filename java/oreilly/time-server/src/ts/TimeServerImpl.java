package ts;

import java.util.Date;
import java.util.TimeZone;

import javax.jws.WebService;
import java.text.SimpleDateFormat;

@WebService(endpointInterface = "ts.TimeServer")
public class TimeServerImpl implements TimeServer{

	@Override
	public String getTimeAsString() {
		return new Date().toString();
	}
	
	@Override
	public String getTimeForGMT(Integer gmt) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
        Date date = new Date();
        TimeZone timeZone = TimeZone.getTimeZone(getGMTTimeZone(gmt));
		if (timeZone == null) {
			return "Invalid TimeZone";
		}
		
		formatter.setTimeZone(timeZone);

		String dateForGMT = formatter.format(date);
		try {
			return formatter.parse(dateForGMT).toString();
		} catch (Exception e) {
			return "Exception encounter";
		}
	}

	private String getGMTTimeZone(Integer gmt) {
		if (gmt == 0) {
			return "GMT";
		} else {
			return (gmt > 0? "+" : "-") + gmt;
		}
	}
}
