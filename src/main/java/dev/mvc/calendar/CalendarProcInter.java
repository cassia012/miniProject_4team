package dev.mvc.calendar;

import java.util.ArrayList;

public interface CalendarProcInter {
    /**
     * 
     * @param calendarVO
     * @return
     */
    public ArrayList<CalendarVO> read_month(CalendarVO calendarVO);
}
