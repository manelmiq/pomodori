package com.pomodori.pomodori.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@Entity
@Table(name="pomodori")
@Getter@Setter
public class Pomodori {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="distractions")
    private int distractions;

    @Column(name="description")
    private String description;

    @JsonFormat  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="begin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date begin;

    @JsonFormat  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="end")
    private Date end;

    @JsonFormat  (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "rest")
    private Date rest;

    public Pomodori() {
    }

    public Pomodori(int distractions, String description, Date begin, Date end, Date rest) {
        this.distractions = distractions;
        this.description = description;
        this.begin = begin;
        this.end = end;
        this.rest = rest;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDistractions() {
        return distractions;
    }

    public void setDistractions(int distractions) {
        this.distractions = distractions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getRest() {
        return rest;
    }

    public void setRest(Date rest) {
        this.rest = rest;
    }
}
