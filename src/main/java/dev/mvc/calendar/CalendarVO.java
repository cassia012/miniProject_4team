package dev.mvc.calendar;

public class CalendarVO{
    
    private int dayno;
    private int year;
    private int month;
    private int day;
    private int dayOfWeek;
    
    
    public int getDayno() {
        return dayno;
    }
    public void setDayno(int dayno) {
        this.dayno = dayno;
    }
    public int getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }    
}