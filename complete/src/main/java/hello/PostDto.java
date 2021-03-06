package hello;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostDto {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	private Long id;

	private String title;

	private String url;

	private String date;

	private UserDto user;

	public Date getSubmissionDateConverted(String timezone) throws ParseException {
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		return dateFormat.parse(this.date);
	}

	public void setSubmissionDate(Date date, String timezone) {
		dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
		this.date = dateFormat.format(date);
	}
}
