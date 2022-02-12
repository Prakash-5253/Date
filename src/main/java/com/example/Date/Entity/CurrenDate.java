package com.example.Date.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Date_table")
public class CurrenDate {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
public String id;
public ZonedDateTime cDate;
public ZonedDateTime eDate;
public ZonedDateTime dDate;
}
