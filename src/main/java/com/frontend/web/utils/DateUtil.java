package com.frontend.web.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 * @author wangluyang
 *
 */
public final class DateUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DateUtil.class);

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String DATETIME_FORMAT2 = "yyyyMMdd HH:mm:ss";

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";

    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    
    private DateUtil() {
        // 禁止实例化
    }

    /**
     * 字符串转日期（精确到日）
     *
     * @param str
     * @return
     * @throws SystemException
     */
    public static Date str2Date(String str) {
        Date date = null;
        if (!StringUtils.isBlank(str)) {
            date = DateUtil.to_date(str, DATE_FORMAT);
        }
        return date;

    }
    
    /**
     * 按指定格式将字符串转换为日期对象
     *
     * @param dateStr
     * @param format
     * @return
     * @throws SystemException
     */
    public static Date to_date(String dateStr, String format) {
        if (StringUtils.isBlank(dateStr)) {
            System.out.println("请指定时间");
        }
        if (StringUtils.isBlank(format)) {
        	System.out.println("请指定格式");
        }
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date date = df.parse(dateStr);
            return new Date(date.getTime());
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
            System.out.println("系统转换日期字符串时出错！");
        }
		return null;
    }
    
    /**
     * 获取指定时间的格式化串
     *
     * @param date
     * @param pattern
     * @return
     * @throws SystemException
     */
    public static String getDateString(Date date, String pattern) {
        if (date == null) {
        	System.out.println("请指定时间");
        }
        if (StringUtils.isBlank(pattern)) {
        	System.out.println("请指定格式");
        }
        SimpleDateFormat sdfmt = new SimpleDateFormat(pattern);
        return date != null ? sdfmt.format(date) : "";
    }
    
    /**
     * corn = "0,0,0";
     * @param corn
     * @return
     */
    public static Date getDateByCorn(String corn){
    	
		String[] cornArr = corn.split(",");
		int[] calendarArray = {Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH,
				Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND};
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int length = cornArr.length<=calendarArray.length?cornArr.length:calendarArray.length;
		for(int i=0; i<length; i++){
			calendar.add(calendarArray[i], Integer.valueOf(cornArr[i]));
		}
		return calendar.getTime();
	}
}
