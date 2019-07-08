package bongs.calendar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Calendar {
	
	public static final int[] MAXDAY_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] LEAF_MAXDAY_OF_MONTH = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private HashMap<String, String> planMap;
	
	public Calendar() {
		planMap = new HashMap<String, String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("Calendar.dat"));
			while(true) {
				String line = null;
				try {
					line = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (line == null)	break;
				String[] str = line.split(",");
				planMap.put(str[0], str[1]);
			}
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void setPlan(String date, String plan) {
		planMap.put(date, plan);
		try {
			FileWriter fw = new FileWriter("Calendar.dat", true);
			fw.write(date + "," + plan + "\n");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getPlan(String date) {
		
		if (planMap.get(date) != null) {
			return date + " 일의 일정 : " + planMap.get(date);
		} else {
			return date + " 일의 일정 : 일정이 없습니다.";
		}
	}
	
	public void getAllPlan() {
		
		System.out.println("<전체 일정>");
		
		Set<String> keys = planMap.keySet();
		
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			String value = planMap.get(key);
			System.out.println(key + " : " + value);
		}		
	}	
	
	public void printCalendar(int year, int month) {
		
		int week = getWeekday(year, month);
		
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		for (int i = 0; i < week; i++) {
			System.out.print("   ");
		}
		
		for (int i = 1; i <= getMaxdayOfMonth(year, month); i++) {
			System.out.printf("%3d", i);
			if ((i + week) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public boolean getLeafYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}	
	
	public int getMaxdayOfMonth(int year, int month) {
		if (getLeafYear(year)) {
			return LEAF_MAXDAY_OF_MONTH[month - 1];
		} else {
			return MAXDAY_OF_MONTH[month - 1];
		}
	}
	
	public int getWeekday (int year, int month) {
	// 계산기준일: 1700.1.1 금요일
		int sYear = 1700;
		int sWeekday = 5;	//금요일
		int countDay = 0;
		int Weekday = 0;
		
		//년도 일수
		for (int i = sYear; i < year; i++) {
			if (getLeafYear(i)) {
				countDay += 366;
			} else {
				countDay += 365;
			}
		}
		
		//월일수
		for (int i = 1; i < month; i++) {
			countDay += getMaxdayOfMonth(year, i);
		}		
			
		Weekday = (countDay + sWeekday) % 7;
		return Weekday;
	}

}
