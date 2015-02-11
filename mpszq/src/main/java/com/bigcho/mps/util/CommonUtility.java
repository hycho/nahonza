package com.bigcho.mps.util;

import java.io.IOException;
import java.io.Reader;
import java.util.Calendar;

public class CommonUtility {

	/**
	 * 현재 서버 년을 가져옵니다.
	 *
	 * @return String : 현재 서버 년 문자열로 반환(yyyy)
	 */
	public static String getCurrentServerYear() {
		java.util.Date uDate = java.util.Calendar.getInstance().getTime();
		String currTime = null;
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy");
		currTime = dateFormat.format(date);
		return currTime;
	}

	/**
	 * 현재 서버 월일을 가져옵니다.
	 *
	 * @return String : 현재 서버 년 문자열로 반환(MMdd)
	 */
	public static String getCurrentServerMonthDay() {
		java.util.Date uDate = java.util.Calendar.getInstance().getTime();
		String currTime = null;
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("MMdd");
		currTime = dateFormat.format(date);
		return currTime;
	}

	/**
	 * 현재 서버 시간을 가져옵니다.
	 *
	 * @return String : 현재 서버시간을 8자리 문자열로 반환(yyyyMMdd)
	 */
	public static String getCurrentServerTime() {
		java.util.Date uDate = java.util.Calendar.getInstance().getTime();
		String currTime = null;
		java.sql.Date date = new java.sql.Date(uDate.getTime());
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMdd");
		currTime = dateFormat.format(date);
		return currTime;
	}

	/**
	 * 현재 서버 시간을 가져옵니다.
	 *
	 * @return String : 현재 서버시간을 14자리 문자열로 반환(yyyyMMddHHmmss)
	 */
	public static String getCurrentServerTime(long time) {
		java.sql.Date date = new java.sql.Date(time);
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String temp = dateFormat.format(date);
		return temp;
	}

	/**
	 * 현재 서버 시간을 가져옵니다.
	 *
	 * @return String : 현재 서버시간을 17자리 문자열로 반환(yyyyMMddHHmmssSSS)
	 */
	public static String getCurrentServerTimeMillis() {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmssSSS");
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}

	/**
	 * 현재 서버 시간을 가져옵니다.
	 *
	 * @return String : 현재 서버시간을 14자리 문자열로 반환(yyyyMMddHHmmss)
	 */
	public static String getCurrentServerTimes() {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}

	public static String getCurrentServerByFormat(String format) {
		java.util.Date date = new java.util.Date();
		java.text.SimpleDateFormat dataFormat = new java.text.SimpleDateFormat(format);
		String currTimeMillis = dataFormat.format(date);
		return currTimeMillis;
	}

	public static String getDayOfWeek() {
		Calendar oCalendar = Calendar.getInstance();
		return String.valueOf(oCalendar.get(Calendar.DAY_OF_WEEK));

	}

	/**
	 * <pre>
	 * Clob 데이터를 읽어 String으로 변환 한다.
	 * </pre>
	 * 
	 * @param reader
	 *            Clob데이터
	 * @return String Clob에 데이터
	 * @throws IOException
	 */
	public static String readClobData(Reader reader) throws IOException {
		StringBuffer data = new StringBuffer();
		char[] buf = new char[1024];
		int cnt = 0;
		if (null != reader) {
			while ((cnt = reader.read(buf)) != -1) {
				data.append(buf, 0, cnt);
			}
		}
		return data.toString();
	}
}