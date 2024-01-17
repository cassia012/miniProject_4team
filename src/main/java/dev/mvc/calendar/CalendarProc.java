package dev.mvc.calendar;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("dev.mvc.calendar.CalendarProc")
public class CalendarProc implements CalendarProcInter{
    
    @Autowired
    private CalendarDAOInter calendarDAO;

    @Override
    public ArrayList<CalendarVO> read_month(CalendarVO calendarVO) {
        ArrayList<CalendarVO> cnt = this.calendarDAO.read_month(calendarVO);
        return cnt;
    }
    
}