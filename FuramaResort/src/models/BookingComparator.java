package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate1 = LocalDate.parse(o1.getStartDay(),formatter);
        LocalDate startDate2 = LocalDate.parse(o2.getStartDay(), formatter);
        LocalDate endDate1 = LocalDate.parse(o1.getFinishDay(), formatter);
        LocalDate endDate2 = LocalDate.parse(o2.getFinishDay(), formatter);

        if(startDate1.compareTo(startDate2) > 0){
            return 1;
        }else if(startDate1.compareTo(startDate2) < 0)
            return  -1;
        else{
            if(endDate1.compareTo(endDate2) > 0){
                return 1;
            }else if(endDate1.compareTo(endDate2) < 0){
                return -1;
            }else{
                return 0;
            }
        }
    }
}
