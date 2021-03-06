package com.tledu.cn.util;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JDK8DateUtil {
	
	public static void main(String[] args) {
		String a = JDK8DateUtil.LocalDateTime2String(null, null);
		System.out.println(a);
	}
	
	//LocalDateTime to Date
	public static Date LocalDateTime2Date(LocalDateTime ldt) {
		Date date=new Date();
		if(ldt!=null) {
			date=Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
		}
		
		return date;
	}
	
	
	//Date to LocalDateTime
	public static LocalDateTime Date2LocalDateTime(Date date) {
		LocalDateTime ldt=LocalDateTime.now();
		if(date!=null) {
			ldt=date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		}
		
		return ldt;
	}
	
	
	//LocatDateTime to String
	public static String LocalDateTime2String(LocalDateTime ldt,String pattern) {
		String result=null;
		pattern=pattern!=null?pattern:"yyyy-MM-dd HH:mm:ss";
		if(ldt!=null) {
			
			result=ldt.format(DateTimeFormatter.ofPattern(pattern));
		}else {
			result=LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
		}
		
		return result;
	}
	
	
	//String to LocalDateTime
	public static LocalDateTime String2LocalDateTime(String target,String pattern) {
		LocalDateTime ldt=LocalDateTime.now();
		pattern=pattern!=null?pattern:"yyyy-MM-dd HH:mm:ss";
		if(target!=null&&target.length()>0) {
			ldt=LocalDateTime.parse(target, DateTimeFormatter.ofPattern(pattern));
		}
		return ldt;
	}
	

}
