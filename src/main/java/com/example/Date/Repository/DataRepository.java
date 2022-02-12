package com.example.Date.Repository;

import com.example.Date.Entity.CurrenDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public interface DataRepository extends JpaRepository<CurrenDate,String> {
List<LocalDate> findByeDate(LocalDate eDate);
List<LocalDate> findAllByeDateBetween(LocalDate start, LocalDate end);

}
