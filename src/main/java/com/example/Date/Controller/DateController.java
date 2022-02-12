package com.example.Date.Controller;

import com.example.Date.Entity.CurrenDate;
import com.example.Date.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;





import java.util.List;

@RestController
public class DateController {
    @Autowired
    DataRepository dataRepository;
    @GetMapping("/Date")
public CurrenDate getDate(){


ZonedDateTime Zdate=ZonedDateTime.now();
ZonedDateTime zzz=Zdate.plusDays(4);
ZonedDateTime currenDateplus= zzz.plusDays(25) ;
ZonedDateTime currenDateDelete=zzz.plusDays(30);
CurrenDate  currenDate=new CurrenDate();
currenDate.setCDate(zzz);
currenDate.setEDate(currenDateplus);
currenDate.setDDate(currenDateDelete);
dataRepository.save(currenDate);
return currenDate;

}
@GetMapping("/getbydate/eDate")
public List<LocalDate> findByeDate(@RequestParam String eDate) {
        List<LocalDate> localDates=new ArrayList<>();
    List<CurrenDate> adt = dataRepository.findAll();
    LocalDate lll=LocalDate.parse(eDate);
    for (CurrenDate zone : adt
    ) {
        ZonedDateTime zzz = zone.getEDate();
        LocalDate ldt = zzz.toLocalDate();
 if(ldt.compareTo(lll)==0)
{
localDates.add(ldt);
}
    }
    return localDates;
    }
    @GetMapping("/retrieveDates/eDate")
    public List<LocalDate> findByeDate(@RequestParam String start, @RequestParam String end ){
        List<LocalDate> localDates=new ArrayList<>();


        List<CurrenDate> adt = dataRepository.findAll();
        LocalDate startDate=LocalDate.parse(start);
        LocalDate endDate=LocalDate.parse(end);
        for (CurrenDate zone : adt
        ) {
            ZonedDateTime zzz = zone.getEDate();
            LocalDate ldt = zzz.toLocalDate();
            if(ldt.isAfter(startDate) &&ldt.isBefore(endDate))
            {
                localDates.add(ldt);
            }
        }
        return localDates;
    }
}
