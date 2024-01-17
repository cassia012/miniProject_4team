package dev.mvc.calendar;

import java.util.ArrayList;

public interface CalendarDAOInter {
    /**
     * 
     * @param calendarVO
     * @return
     */
    public ArrayList<CalendarVO> read_month(CalendarVO calendarVO);

}
