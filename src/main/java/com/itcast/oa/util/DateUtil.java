package com.itcast.oa.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{

	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	private static final int TEN_MINUTES = 10;

	private static final DateFormat yyyymmdd = new SimpleDateFormat("yyyyMMdd");
	public static String DATE_FORMART_HHMMSS = "HHmmss";
	public static String DATE_FORMART_YYYYMMDD = "yyyyMMdd";
	public static String DATE_FORMART_YYYY_MM_DD = "yyyy-MM-dd";
	public static String DATE_FORMART_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static String DATE_FORMART_YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static String DATE_FORMART_SYMBOL_LINE = "-";
	public static String DATE_FORMART_SYMBOL_COLON = ":";


	public static String getCurrentRandomDate(int dateute){
		Calendar c = Calendar.getInstance();  //得到当前日期和时间
		c.add(Calendar.DATE, dateute);//设置当前时间的前后日期
		Date newDate = c.getTime();
		return formatnormal(DATE_FORMART_YYYYMMDD,newDate);
	}

	public static String getCurrentRandomMonth(int monthute){
		Calendar c = Calendar.getInstance();  //得到当前日期和时间
		c.add(Calendar.MONTH, monthute);//设置当前时间的前后月份
		Date newDate = c.getTime();
		return formatnormal(DATE_FORMART_YYYYMMDD,newDate);
	}

	public static String formatnormal(String formatStr,Date formatDate){
		DateFormat df = new SimpleDateFormat(formatStr);
		return df.format(formatDate);
	}
	/**
	 * @Title: getCurrentDateTime
	 * @Description: 获取当系统时间
	 * @return
	 */
	public static Date getCurrentDateTime(){
		Calendar c = Calendar.getInstance();  //得到当前日期和时间
		return c.getTime();
	}

	/**
	 * @Title: getCurrentDateTime
	 * @Description:
	 * @param minute
	 * @return
	 */
	public static Date getTenMinutesLaterDateTime(){
		return getDateTime(TEN_MINUTES);
	}

	/**
	 * @Title: getCurrentDateMin
	 * @Description: 获取当系统时间,前后时间
	 * @param minute
	 * @return
	 */
	public static Date getDateTime(int minute){
		Calendar c = Calendar.getInstance();  //得到当前日期和时间
		c.add(Calendar.MINUTE, minute);
		return c.getTime();
	}

	/**
	 * @Title: compare_date
	 * @Description: date1大于date2返回1，date1小于date2返回-1
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareDate(Date date1, Date date2) {
		try {
			if (date1.getTime() > date2.getTime()) {
				return 1;
			} else if (date1.getTime() < date2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			logger.error("时间比较出错！", exception);
		}
		return 0;
	}

	/**
	 * @Description: date1大于date2返回1，date1小于date2返回-1
	 * @param format_date
	 * @param date1
	 * @param date2
	 * @return int
	 */
	public static int compareDate(String format_date, String date1, String date2) {
		DateFormat df = new SimpleDateFormat(format_date);
		try {
			Date dt1 = df.parse(date1);
			Date dt2 = df.parse(date2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			} else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			logger.error("时间比较出错！", exception);
		}
		return 0;
	}

	/**
	 * @Title: compareDate
	 * @Description: 大于当前系统时间返回true，小于当前系统时间返回false
	 * @param effectiveTime
	 * @return
	 */
	public static boolean compareDate(Date effectiveTime){
		int i = compareDate(effectiveTime, getCurrentDateTime());
		return i == 1 ? true : false;
	}

	/**
	 * @Title: formatYYYYMMDD
	 * @Description: 将date类型时间格式化成yyyyMMdd格式字符串
	 * @param date
	 * @return
	 */
	public static String formatYYYYMMDD(Date date) {
		if(date == null)
			return null;
		return yyyymmdd.format(date);
	}

	/**
	 * 格式化日期  yyyyMMdd
	 */
	public static String formatYYYYMMDD(String dateStr)
	{
		String dateString = "";
		try {
			SimpleDateFormat format = new SimpleDateFormat(DATE_FORMART_YYYYMMDD);
			Date date = format.parse(dateStr);
			dateString = format.format(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dateString;
	}

	/**
	 * 格式化日期  yyyy-MM-dd
	 */
	public static String formatyymmddLine(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(DATE_FORMART_YYYY_MM_DD);
		return format.format(date);
	}

	/**
	 * 格式化日期  yyyy-MM-dd HH:mm:ss ->yyyyMMddHHmmss
	 */
	public static String parseLineToDateStr(String dateStr)
	{
		String dateString = "";
		try
		{
			SimpleDateFormat oldFormat = new SimpleDateFormat(DATE_FORMART_YYYYMMDD_HHMMSS);
			SimpleDateFormat newFormat = new SimpleDateFormat(DATE_FORMART_YYYYMMDDHHMMSS);
			dateString = newFormat.format(oldFormat.parse(dateStr));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 将dateStr转成Date
	 */
	public static String parseDateStrToLine(String dateStr)
	{
		String dateString = "";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMART_YYYYMMDD);
			dateString = formatyymmddLine(sdf.parse(dateStr));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateString;
	}

	/**
	 * 生成日期 时间
	 * add by Nick
	 * 2017-10-19
	 */
	public static String getCurrentDate() {

//    	Date dNow = new Date();
		Date dBefore = new Date();

//    	Calendar calendar = Calendar.getInstance();
//    	calendar.setTime(dNow);
//    	calendar.add(Calendar.DAY_OF_MONTH, 0);
//    	dBefore = calendar.getTime();


		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMART_YYYYMMDD_HHMMSS);
		String defaultStartDate = sdf.format(dBefore);
//    	String defaultEndDate = sdf.format(dNow);

		return defaultStartDate;

	}

	/****
	 * add by Nick
	 * 2017-11-10
	 * 获取系统当前时间
	 * */
	public static String getCurDate() {
		//String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

		Date dNow = new Date();
		Date dBefore = new Date();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dNow);
		calendar.add(Calendar.DAY_OF_MONTH, 0);
		dBefore = calendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMART_YYYYMMDDHHMMSS);
		String defaultStartDate = sdf.format(dBefore);

		return defaultStartDate;

	}
	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 60 * 60 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 *字符串的日期格式的计算
	 */
	public static int daysBetween(String smdate,String bdate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 60 * 60 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * @Author: huangchuang
	 * @Description: 比较上次签到时间和当前时间
	 * @Date: 2018/3/9 18:44
	 * @param date1 上次签到时间
	 */
	public static int daysBetween(String date1) throws ParseException {
		String currentDate = formatyymmddLine(new Date());
		String signDate = date1.substring(0, 10);
		return daysBetween(signDate, currentDate);
	}


	public static String currentDate( )   {
		return formatyymmddLine(new Date());
	}

	/**
	 * 格式化日期 YYYYMMDDHHMMSS
	 */
	public static String formatyymmddhhmmss(Date date) {
		return formatyymmddLine(date,DATE_FORMART_YYYYMMDDHHMMSS);
	}
	/**
	 * 格式化日期  yyyy-MM-dd
	 */
	public static String formatyymmddLine(Date date,String formatType) {
		SimpleDateFormat format = new SimpleDateFormat(formatType);
		return format.format(date);
	}
	public static void main(String[] args) throws ParseException {
//		System.out.println(daysBetween("2018-03-09 15:10:41"));
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(daysBetween(sdf.parse("2018-03-09 15:10:41"), new Date()));
//		System.out.println(daysBetween("2016-03-18 11:59:59", "2016-03-19 00:00:01"));
	}

}
