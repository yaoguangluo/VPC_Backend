
package org.lyg.common.utils;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;



public class DateUtil{
	public static final String LONG_ALL_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String LONG_DATE_PATTERN = "yyyy-MM-dd HH:mm";
	/** 鐭棩鏈熸牸寮�*/
	public static final String SHORT_DATE_PATTERN = "yyyy-MM-dd";
	/** 鐭棩鏈熸牸寮�*/
	public static final String SHORT_HH_MM_PATTERN = "HH:mm";
	/** 鐭棩鏈熸鍒欒〃杈惧紡 */
	public static final String SHORT_DATE_REG = "\\d{4}-\\d{1,2}-\\d{1,2}";
	/** �?��棩鏈熸牸寮忔鍒欒�?杈惧�?*/
	public static final String LONG_DATE_REG = "[\\d]{4}[-][\\d]{2}[-][\\d]{2} [\\d]{1,2}:[\\d]{1,2}";
	
	public static final String LONG_DATE_REG_HAVE_SS = "[\\d]{4}[-][\\d]{2}[-][\\d]{2} [\\d]{1,2}:[\\d]{1,2}:[\\d]{1,2}";
	
	public static final String LONG_DATE_REG_HAVE_MS = "[\\d]{4}[-][\\d]{2}[-][\\d]{2} [\\d]{1,2}:[\\d]{1,2}:[\\d]{1,2}.[\\d]{1,2}";
	/** 鏄熸湡鏃�?/
	public static final int SUNDAY = Calendar.SUNDAY;
	/** 鏄熸湡涓�?/
	public static final int MONDAY = Calendar.MONDAY;
	/** 鏄熸湡浜�?/
	public static final int TUESDAY = Calendar.TUESDAY;
	/** 鏄熸湡涓�?/
	public static final int WEDNESDAY = Calendar.WEDNESDAY;
	/** 鏄熸湡鍥�?/
	public static final int THURSDAY = Calendar.THURSDAY;
	/** 鏄熸湡浜�?/
	public static final int FRIDAY = Calendar.FRIDAY;
	/** 鏄熸湡鍏�?/
	public static final int SATURDAY = Calendar.SATURDAY;
	/** 鏄熸湡鏁扮粍 */
	private static final String[] DAY_OF_WEEK = {""};
	
    /**
     * <PRE>
     * 鑾峰彇褰撳墠鏃ユ�?
     * </PRE>
     *
     * @return Date today
     */
    public static Date getNow() {
        Date now = new Date();
        return now;
    }

    /**
     * 鑾峰彇绠�崟鏍煎紡鐨勫綋鍓嶆棩鏈熷瓧绗︿覆锛屽舰寮弝yyy-mm-dd
     * @return String
     */
    public static String getShortNow(){
    	String sNow;
    	Date now = new Date();
    	sNow = dateFormater(now,SHORT_DATE_PATTERN);
    	return sNow;
    }
    
    /**
     * 鑾峰彇绠�崟鏍煎紡鐨勫綋鍓嶆棩鏈熷瓧绗︿覆锛屽舰寮弝yyy-mm-dd hh:mm
     * @return String
     */
    public static String getLongNow(){
    	String sNow;
    	Date now = new Date();
    	sNow = dateFormater(now,LONG_DATE_PATTERN);
    	return sNow;
    }
    
    /**
     * 鑾峰彇绠�崟鏍煎紡鐨勫綋鍓嶆棩鏈熷瓧绗︿覆锛屽舰寮弝yyy-mm-dd
     * @return String
     */
    public static String getHMTime(){
    	String sNow;
    	Date now = new Date();
    	sNow = dateFormater(now,SHORT_HH_MM_PATTERN);
    	return sNow;
    }
    
    /**
     * 鏍规嵁鎸囧畾鏍煎紡锛岃幏鍙栨寚�?氭棩鏈熺殑鏍煎紡瀛楃涓�?     * @param date 鎸囧畾鏃ユ湡
     * @param sPattern 鏃ユ湡鏍煎紡
     * @return String
     */
    public static String dateFormater(Date date,String sPattern) {
    	String sDate;
    	if(null == date){
    		sDate = "";
    	}else{
	        SimpleDateFormat sdf = new SimpleDateFormat(sPattern);
	        sDate = sdf.format(date);
    	}
        return sDate;
    }

    /**
     * 鏍规嵁鎸囧畾鏍煎紡锛岃幏鍙栨寚�?氶暱鏃ユ湡鐨勬牸寮忓瓧绗︿覆
     * @param date 鎸囧畾鏃ユ湡
     * @return String
     */
    public static String shortDateFormater(Date date) {
    	String sDate;
    	if(null == date){
    		sDate = "";
    	}else{
            SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_PATTERN);
            sDate = sdf.format(date);
    	}
        return sDate;
    }
    
    /**
     * 鏍规嵁鎸囧畾鏍煎紡锛岃幏鍙栨寚�?氶暱鏃ユ湡鐨勬牸寮忓瓧绗︿覆
     * @param date 鎸囧畾鏃ユ湡
     * @return date
     */
    public static Date shortDate(Date d) {
    	Date date;
    	if(null == d){
    		date = new Date();
    	}else{
            String str = shortDateFormater(d);
            date = parseDate(str);
    	}
        return date;
    }
    
    /**
     * 鏍规嵁鎸囧畾鏍煎紡锛岃幏鍙栨寚�?氶暱鏃ユ湡鐨勬牸寮忓瓧绗︿覆
     * @param date 鎸囧畾鏃ユ湡
     * @return String
     */
    public static String longDateFormater(Date date) {
    	String sDate;
    	if(null == date){
    		sDate = "";
    	}else{
            SimpleDateFormat sdf = new SimpleDateFormat(LONG_DATE_PATTERN);
            sDate = sdf.format(date);
    	}
        return sDate;
    }
    
    /**
     * 鏍规嵁鎸囧畾鏍煎紡锛屾棩鏈熷瓧绗︿覆杞崲鎴怐ATE鍨�
     * @param date yyyy-mm-dd HH:MI:SS鏍煎紡鐨勬棩鏈熷瓧绗︿覆
     * @return Date
     */
    public static Date getLongDate(String sDate){
    	Date date = null;
		if(sDate.matches(LONG_DATE_REG_HAVE_SS)){
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(sDate.split("-")[0]) );
			cal.set(Calendar.MONTH, Integer.parseInt(sDate.split("-")[1])-1 );
			cal.set(Calendar.DATE, Integer.parseInt(
					sDate.substring(sDate.lastIndexOf("-")+1,sDate.lastIndexOf(" "))));
			cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(
					sDate.substring(sDate.lastIndexOf(" ")+1,sDate.indexOf(":"))));
			cal.set(Calendar.MINUTE, Integer.parseInt(sDate.split(":")[1]) );
			cal.set(Calendar.SECOND, Integer.parseInt(sDate.split(":")[2]) );
			date = cal.getTime(); 
		} 
		else if(sDate.matches(LONG_DATE_REG_HAVE_MS)){
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(sDate.split("-")[0]) );
			cal.set(Calendar.MONTH, Integer.parseInt(sDate.split("-")[1])-1 );
			cal.set(Calendar.DATE, Integer.parseInt(
					sDate.substring(sDate.lastIndexOf("-")+1,sDate.lastIndexOf(" "))));
			cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(
					sDate.substring(sDate.lastIndexOf(" ")+1,sDate.indexOf(":"))));
			cal.set(Calendar.MINUTE, Integer.parseInt(sDate.split(":")[1]) );
			cal.set(Calendar.SECOND, Integer.parseInt(
					sDate.substring(sDate.lastIndexOf(":")+1,sDate.lastIndexOf("."))));
			date = cal.getTime(); 
		}
		return date;   	
    }
    
    /**
     * 灏唝yyy-mm-dd鏍煎紡鐨勬棩鏈熷瓧绗︿覆杞寲涓烘棩鏈熷璞�?     * @param sDate yyyy-mm-dd鏍煎紡鐨勬棩鏈熷瓧绗︿覆
     * @return Date
     */
    public static Date parseDate(String sDate){
		if( !sDate.matches(SHORT_DATE_REG) ){
		  return null;  
		} 
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(sDate.split("-")[0]) );
		cal.set(Calendar.MONTH, Integer.parseInt(sDate.split("-")[1])-1 );
		cal.set(Calendar.DATE, Integer.parseInt(sDate.split("-")[2]) );
		Date date = cal.getTime(); 
		return date;
    }
    
    /**
     * 灏唝yyy-mm-dd mm:ss鏍煎紡鐨勬棩鏈熷瓧绗︿覆杞寲涓烘棩鏈熷璞�?     * @param sDate yyyy-mm-dd mm:ss鏍煎紡鐨勬棩鏈熷瓧绗︿覆
     * @return Date
     */
    public static Date parseLongDate(String sDate){
		if( !sDate.matches(LONG_DATE_REG) ){
			  return null;  
			} 
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, Integer.parseInt(sDate.split("-")[0]) );
			cal.set(Calendar.MONTH, Integer.parseInt(sDate.split("-")[1])-1 );
			cal.set(Calendar.DATE, Integer.parseInt(
					sDate.substring(sDate.lastIndexOf("-")+1,sDate.lastIndexOf(" "))));
			cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(
					sDate.substring(sDate.lastIndexOf(" ")+1,sDate.lastIndexOf(":"))));
			cal.set(Calendar.MINUTE, Integer.parseInt(sDate.split(":")[1]) );
			Date date = cal.getTime(); 
			return date;    	
    }
    
    /**
     * 鑾峰彇鍒跺畾鏃ユ湡鐨勭畝鍗曟牸寮忓瓧绗︿覆锛屽舰寮弝yyy-mm-dd
     * @param date 鎸囧畾鏃ユ湡
     * @return String
     */
    public static String getShortDate(Date date){
    	String sShortDate;
    	if(null == date){
    		sShortDate = "";
    	}else{
        	sShortDate = dateFormater(date,SHORT_DATE_PATTERN);
    	}
    	return sShortDate;
    }

    
    /**
     * 鑾峰彇鍒跺畾鏃ユ湡鐨勭畝鍗曟牸寮忓瓧绗︿覆锛屽舰寮廻h:mm
     * @param date 鎸囧畾鏃ユ湡
     * @return String
     */
    public static String getShortDateHHMM(Date date){
    	String sShortDate;
    	if(null == date){
    		sShortDate = "";
    	}else{
        	sShortDate = dateFormater(date,SHORT_HH_MM_PATTERN);
    	}
    	return sShortDate;
    }
    /**
     * 杩斿洖鎸囧畾鏃ユ湡鐨勬绉掑�?
     * @param date 鎸囧畾鏃ユ湡
     * @return long 姣鍊�?     */
    public static long getMillis(Date date) {
    	Calendar c = Calendar.getInstance();
		c.setTime(date);
		long millins = c.getTimeInMillis();
		return millins;
    }
    /**
     * 鑾峰彇褰撳墠鏃ユ湡鐨勫墠涓�ぉ锛堟槰澶╋�?
     * @return Date
     */
    public static Date getYesterday(){
    	Date now = new Date();
    	Date yesterday = addDate(now,-1);
		return yesterday;    	
    }
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡鐨勫墠涓��?
     * @param date yyyy-mm-dd鏍煎紡鐨勬棩鏈熷瓧绗︿覆
     * @return Date
     */
    public static Date getYesterday(String date){
    	Date currentDate = parseDate(date);
		Date yesterday = addDate(currentDate,-1);
		return yesterday;     	
    }
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡鐨勫墠涓��?
     * @param date yyyy-mm-dd鏍煎紡鐨勬棩鏈熷瓧绗︿覆
     * @return Date
     */
    public static Date getYesterday(Date date){
    	String sShortDate = "";
    	if(null == date){
    		sShortDate = "";
    	}else{
        	sShortDate = dateFormater(date,SHORT_DATE_PATTERN);
    	}
    	
    	if(null != date){
        	sShortDate = dateFormater(date,SHORT_DATE_PATTERN);
    	}
    	Date currentDate = parseDate(sShortDate);
		Date yesterday = addDate(currentDate,-1);
		return yesterday;     	
    }
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡鍔犱笂浠绘剰澶╂暟涔嬪悗鐨勬棩鏈�
     * @param date 鎸囧畾鏃ユ湡
     * @param day 澧炲姞鐨勫ぉ鏁�
     * @return Date
     */
    public static Date addDate(Date date,int days){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) + ((long)days) * 24 * 3600 * 1000);
		return c.getTime();
	}
    
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡鍔犱笂浠绘剰澶╂暟涔嬪悗鐨勬棩鏈�
     * @param date 鎸囧畾鏃ユ湡
     * @param day 澧炲姞鐨勫ぉ鏁�
     * @return Date
     */
    public static Date addDate(Date date,double days){
		Calendar c = Calendar.getInstance();
		long lDays = (long)(days * 24 * 3600 * 1000);
		c.setTimeInMillis(getMillis(date) + lDays);
		return c.getTime();
	}
    
    /**
     * 璁＄畻涓や釜鏃ユ湡涔嬮棿鐩稿樊鐨勫ぉ鏁�
     * @param dateFrom 寮�鏃ユ湡
     * @param dateTo 缁撴潫鏃ユ湡
     * @return int 涓や釜鏃ユ湡涔嬮棿鐩稿樊鐨勫ぉ鏁�?     */
    public static int diffDate(Date dateFrom,Date dateTo){
		int iDiff = (int)((getMillis(dateTo) - getMillis(dateFrom)) / (24 * 3600 * 1000));
		return iDiff;
	} 
    /**
     * 鑾峰彇涓や釜鏃ユ湡涔嬮棿鐨勬棩鏈�?     * @param dateFrom 寮�鏃ユ湡
     * @param dateTo 缁撴潫鏃ユ湡
     * @return List 涓や釜鏃ユ湡涔嬮棿鐨勬棩鏈�鍖呮嫭寮�鏃ユ湡鍜�?��鏉熸棩鏈�?
     */
    public static List getDateList(String dateFrom,String dateTo){
    	List lstDate =  new ArrayList();
    	int iDiff = diffDate(parseDate(dateFrom),parseDate(dateTo));
    	Date newDate = new Date();
    	for(int i =0;i<=iDiff;i++){
    		newDate = addDate(parseDate(dateFrom),i);
    		lstDate.add(shortDateFormater(newDate));
    	}
		return lstDate;
	} 
    /**
     * 鑾峰彇褰撳墠鏃ユ湡涔嬪悗涓�ぉ鐨勬棩鏈燂紙鏄庡ぉ锛�
     * @return Date
     */
    public static Date getTomorrow(){
    	Date now = new Date();
    	Date tomorrow = addDate(now,1);
		return tomorrow;       	
    }
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡涔嬪悗涓�ぉ鐨勬棩鏈�
     * @param date yyyy-mm-dd鏍煎紡鐨勬棩鏈熷瓧绗︿覆
     * @return Date
     */
    public static Date getTomorrow(String date){
    	Date currentDate = parseDate(date);
		Date tomorrow = addDate(currentDate,1);
		return tomorrow;      	
    }
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡涔嬪悗涓�ぉ鐨勬棩鏈�
     * @param date yyyy-mm-dd mm:ss鏍煎紡鐨勬棩鏈熷瓧绗︿覆
     * @return Date
     */
    public static Date getLongTomorrow(String date){
    	Date currentDate = parseLongDate(date);
		Date tomorrow = addDate(currentDate,1);
		return tomorrow;      	
    }
    /**
     * 鑾峰彇褰撳墠骞�
     * @return String
     */
    public static String getYear(){
    	Date now = new Date();
		String year = getYear(now); 
		return year;
	}
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡涓殑骞�
     * @param date 鎸囧畾鏃ユ湡
     * @return String
     */
    public static String getYear(Date date){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    	String year = sdf.format(date);
		return year;
	}
    /**
     * 鑾峰彇褰撳墠鏈�
     * @return String
     */
    public static String getMonth(){
    	Date now = new Date();
    	String month = getMonth(now); 
		return month;
	}    
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡涓殑鏈�
     * @param date 鎸囧畾鏃ユ湡
     * @return String
     */
	public static String getMonth(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		String month = sdf.format(date);
		return month;
	} 
	/**
	 * 鑾峰彇褰撳墠鏃�
	 * @return String
	 */
    public static String getDay(){
    	Date now = new Date();
    	String day = getDay(now); 
		return day;
	}    
    /**
     * 鑾峰彇鎸囧畾鏃ユ湡涓殑鏃�
     * @param date 鎸囧畾鏃ユ湡
     * @return String
     */
	public static String getDay(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		String day = sdf.format(date);
		return day;
	}
	/**
	 * 鑾峰彇褰撳墠鏃ユ湡鐨勫勾鏈�
	 * @return String锛屾牸寮忎负yyyy-mm鐨勬棩鏈熷瓧绗︿�?
	 */
	public static String getYearMonth(){
		String year = getYear();
		String month = getMonth();
		String sYearMonth = year + "-" + month;
		return sYearMonth;
	}
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡鐨勫勾鏈�
	 * @param date 鎸囧畾鏃ユ湡
	 * @return String锛屾牸寮忎负yyyy-mm鐨勬棩鏈熷瓧绗︿�?
	 */
	public static String getYearMonth(Date date){
		String sYearMonth = dateFormater(date,"yyyy-MM");
		return sYearMonth;
	}
	/**
	 * 鑾峰彇褰撳墠鏃ユ湡鐨勪笅涓��?
	 * @return String锛屾牸寮忎负yyyy-mm鐨勬棩鏈熷瓧绗︿�?
	 */
	 public static String getNextYearAndMonth() {
		 	String year = getYear();
			String month = getMonth();
			String date = year + "-" + month;
	    	String nextDate=null;
	    	if("12".equals(date.substring(5, 7))){
	    		nextDate = String.valueOf(Integer.parseInt(date.substring(0, 4))+1)+"-01";
	    	}
	    	else{
	    		if((Integer.parseInt(date.substring(5, 6))+1)>=10){
	    		nextDate = date.substring(0, 4)+"-"+String.valueOf(Integer.parseInt(date.substring(5, 7))+1);
	    		}else
	    		{nextDate = date.substring(0, 4)+"-0"+String.valueOf(Integer.parseInt(date.substring(5, 7))+1);}
	    	}
	        return nextDate;
	    }
	 /**
	 * 鑾峰彇鎸囧畾鏃ユ湡鐨勪笅涓��?
	 * @return String锛屾牸寮忎负yyyy-mm鐨勬棩鏈熷瓧绗︿�?
	 */
	 public static String getNextYearAndMonth(String date) {
	    	String nextDate=null;
	    	if("12".equals(date.substring(5, 7))){
	    		nextDate = String.valueOf(Integer.parseInt(date.substring(0, 4))+1)+"-01";
	    	}
	    	else{
	    		if((Integer.parseInt(date.substring(5, 6))+1)>=10){
	    		nextDate = date.substring(0, 4)+"-"+String.valueOf(Integer.parseInt(date.substring(5, 7))+1);
	    		}else
	    		{nextDate = date.substring(0, 4)+"-0"+String.valueOf(Integer.parseInt(date.substring(5, 7))+1);}
	    	}
	        return nextDate;
	    }
	/**
	 * 鑾峰彇褰撳墠鏈堢殑绗竴澶╁搴旂殑鏃ユ湡锛屾牸寮忎负yyyy-mm-dd
	 * @return String锛屾牸寮忎负yyyy-mm-dd鐨勬棩鏈熷瓧绗︿�?
	 */
	public static String getMonthBegin(){
		Date now = getNow();
		String sMonthBegin = getMonthBegin(now);
		return sMonthBegin;
	}	
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡鎵�湪鏈堜唤鐨勭涓�ぉ�?瑰簲鐨勬棩鏈�?	 * @param date 鎸囧畾鏃ユ湡
	 * @return String锛岀煭鏍煎紡鐨勬棩鏈熷瓧绗︿�?
	 */
	public static String getMonthBegin(Date date){
		String sYearMonth = dateFormater(date,"yyyy-MM");
		String sMonthBegin = sYearMonth + "-01";
		return sMonthBegin;
	}
	/**
	 * 鑾峰彇褰撳墠鏈堜唤涓殑鏈�悗涓�ぉ鐨勬棩鏈�?	 * @return String锛岀煭鏍煎紡鐨勬棩鏈熷瓧绗︿�?
	 */
	public static String getMonthEnd(){
		Date now = getNow();
		String sMonthEnd = getMonthEnd(now);
		return sMonthEnd;
	}	
	
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡鎵�湪鏈堜唤鐨勬渶鍚庝竴澶╁搴旂殑鏃ユ湡
	 * @param date 鎸囧畾鏃ユ湡
	 * @return String锛岀煭鏍煎紡鐨勬棩鏈熷瓧绗︿�?
	 */
	public static String getMonthEnd(Date date){
		Date monthBegin = parseDate(getMonthBegin(date));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(monthBegin);
		calendar.add(Calendar.MONTH,1);
		calendar.add(Calendar.DAY_OF_YEAR,-1);
		String sMonthEnd = getShortDate(calendar.getTime());
		return sMonthEnd;
	}
	
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡鎵�湪鍛ㄧ殑鍛ㄥ嚑鐨勬棩鏈熷瓧绗︿�?
	 * @param date 鎸囧畾鏃ユ湡
	 * @param day 鍩轰�?鐨勪竴鍛ㄤ腑鐨勭鍑犲ぉ
	 * @see SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY
	 * @return String 鐭牸寮忕殑鏃ユ湡�?楃涓�
	 */
	public static String getWeekDate(Date date,int day){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK,day);
		Date sunday = c.getTime();
		String sWeekDay = dateFormater(sunday,SHORT_DATE_PATTERN);
		return sWeekDay;
	}
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡�?瑰簲鐨勬槦鏈熷嚑
	 * @param date 鎸囧畾鏃ユ湡
	 * @return String
	 */
	public static String getDayOfWeek(Date date){
		String sDayOfWeek;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		sDayOfWeek = DAY_OF_WEEK[day-1];
		return sDayOfWeek;
	}
	
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡�?瑰簲鐨勬槦鏈熷嚑
	 * @param date 鎸囧畾鏃ユ湡
	 * @return String
	 */
	public static int getDayNumberOfWeek(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		return day;
	}	
	
    /**
	 * 鑾峰緱鏌愬勾鏌愭�?��勫ぉ鏁�
	 * @param year 骞翠�?
	 * @param month 鏈堜�?
	 * @return int 
	 */
    public static int getDays(int year,int month) {
    	int days=0;
    	switch(month){
    	case 1:days=31; break;
    	case 2:days=(((0 == year % 4) && (0 != (year % 100))) || (0 == year % 400) ? 29 : 28); break;
    	case 3:days=31; break;
    	case 4:days=30; break;
    	case 5:days=31; break;
    	case 6:days=30; break;
    	case 7:days=31; break;
    	case 8:days=31; break;
    	case 9:days=30; break;
    	case 10:days=31; break;
    	case 11:days=30; break;
    	case 12:days=31; break;
    	}
    	return days;
    }
    /**
     * 鏍规嵁鏃ユ湡锛屽鏃ユ湡杩涜绠�崟姣旇�?
     * @param date1 鏃ユ�?
     * @param date2 鏃ユ�?
     * @return int锛�---鏃ユ�?>鏃ユ�?锛�1---鏃ユ�?<鏃ユ�?锛�---鏃ユ�?=鏃ユ�?
     */
    public static int dateSimpleCompare(Date date1,Date date2){
    	int iResult = 0;
    	int iDiff = diffDate(date1,date2);
    	if(iDiff>0){
    		iResult = 1;
    	}
    	else if(iDiff<0){
    		iResult = -1;
    	}
    	else{
    		iResult = 0;
    	}
    	return iResult;
    }
    /**
     * 鏍规嵁鏃ユ湡锛屽�?楃涓蹭唬琛ㄧ殑鐭牸寮忔棩鏈熻繘琛�?��鍗曟瘮杈�?     * @param date1 鏃ユ�?
     * @param date2 鏃ユ�?
     * @return int锛�---鏃ユ�?>鏃ユ�?锛�1---鏃ユ�?<鏃ユ�?锛�---鏃ユ�?=鏃ユ�?
     */    
    public static int dateSimpleCompare(String sDate1,String sDate2) {
        Date date1 = parseDate(sDate1);
        Date date2 = parseDate(sDate2);
        int iResult = dateSimpleCompare(date1, date2);
        return iResult;
    }     
    /**
     * 鏍规嵁鏃ユ湡锛屽鏃ユ湡杩涜澶嶆潅姣旇緝锛�?��纭埌姣
     * @param date1 鏃ユ�?
     * @param date2 鏃ユ�?
     * @return int锛�---鏃ユ�?>鏃ユ�?锛�1---鏃ユ�?<鏃ユ�?锛�---鏃ユ�?=鏃ユ�?
     */ 
    public static int dateComplexCompare(Date date1,Date date2) {
    	int iResult = 0;
        boolean bBefore = date1.before(date2);
        boolean bAfter = date1.after(date2);
        if(bBefore){
        	iResult = 1;
        }
        else if(bAfter){
        	iResult = -1;
        }
        else{
        	iResult = 0;
        }
        return iResult;
    }
    /**
     * 鏍规嵁鏃ユ湡锛屽鏃ユ湡杩涜澶嶆潅姣旇緝锛�?��纭埌姣
     * @param date1 鏃ユ�?
     * @param date2 鏃ユ�?
     * @return int锛�---鏃ユ�?>鏃ユ�?锛�1---鏃ユ�?<鏃ユ�?锛�---鏃ユ�?=鏃ユ�?
     */ 
    public static int dateComplexCompare(String sDate1,String sDate2) {
        Date date1 = parseDate(sDate1);
        Date date2 = parseDate(sDate2);
        int iResult = dateComplexCompare(date1, date2);
        return iResult;
    }  
    /**
     * 鍒ゆ柇涓�釜瀛楃涓叉槸鍚︿唬琛ㄤ竴涓鍚堟寚瀹氭牸寮忕殑姝ｇ‘鏃ユ湡
     * @param sDate 鏃ユ湡鏍煎紡瀛楃涓�?     * @param sPattern 鏃ユ湡鏍煎紡
     * @return true---鏄棩鏈熷瓧绗︿�?false---涓嶆槸鏃ユ湡瀛楃涓�?     */
    public static boolean isDate(
        String sDate,
        String sPattern) {
        boolean bIsDate = false;

        try {
            if ((sDate != null) && (sDate.length() > 0)) {
                SimpleDateFormat fmt = new SimpleDateFormat(sPattern);
                Date dtCheck = fmt.parse(sDate);

                String sCheck = fmt.format(dtCheck);

                if (sDate.equals(sCheck)) {
                    bIsDate = true;
                }
            }
        } catch (ParseException e) {
            bIsDate = false;
        }

        return bIsDate;
    }   
    /**
     * 鍒ゆ柇涓�釜瀛楃涓叉槸鍚︿唬琛ㄤ竴涓纭棩鏈�
     * @param sDate 鏃ユ湡鏍煎紡瀛楃涓�?     * @return true---鏄棩鏈熷瓧绗︿�?false---涓嶆槸鏃ユ湡瀛楃涓�?     */
    public static boolean isDate(String sDate) {
        boolean bIsDate = false;

        if (isDate(sDate, "yyyy/MM/dd")
            || isDate(sDate, "yyyy/M/dd")
            || isDate(sDate, "yyyy/M/d")
            || isDate(sDate, "yyyy/MM/d")
            || isDate(sDate, "yyyy-MM-dd")
            || isDate(sDate, "yyyy-M-dd")
            || isDate(sDate, "yyyy-M-d")
            || isDate(sDate, "yyyy-MM-d")) {
            bIsDate = true;
        }

        return bIsDate;
    } 
    
    /**
     * 鑾峰彇褰撳墠鏃堕棿�?屾暣瀛楃涓�?     * @return String
     */
    public static String getNowDateTimeString() {
        Date currentTime = getNow();
        return dateFormater(currentTime, "yyyyMMddHHmmss");
    }  
    
    /**
     * 鑾峰彇褰撳墠鏃堕棿�?屾暣瀛楃涓�?     * @return String
     */
    public static String getNowDateTimeAllString() {
        Date currentTime = getNow();
        return dateFormater(currentTime, LONG_ALL_DATE_PATTERN);
    }  
	
	/**
	 * 鑾峰彇鎸囧畾鏃ユ湡i涓�?��庣殑鏃ユ�?
	 * @param date 鎸囧畾鏃ユ湡
	 * @return String锛岀煭鏍煎紡鐨勬棩鏈熷瓧绗︿�?
	 */
	public static Date getNextMonth(Date date, int i){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH,i);
		return calendar.getTime();
	}

	/**
     * 鏃堕棿鎹㈢畻String(yyyy-MM-dd HH:mm:ss)-> 鏃堕棿鎴�?     * @param time
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static long timeFormat(String time)throws Exception{
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		Date date = format.parse(time);
		
		return date.getTime()/1000;
	}
	/**
     * 鑾峰彇褰撳墠绯荤粺鏃堕棿鐨勬椂闂存埑
     * @param time
     * @throws NoSuchAlgorithmException,UnsupportedEncodingException
     * @author james.wu
     */
	public  static Long getNowLong()throws Exception{
		String time = DateUtil.dateFormater(DateUtil.getNow(), "yyyy-MM-dd HH:mm:ss");
		
		return DateUtil.timeFormat(time);
	}
}
