package com.ab.hbm.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "mobileUser")
public class MobilePhoneUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long regNo;
    private Long mobileNo;
    private boolean prepaid;
    private String circle;
    private String callerTune;
    @CreationTimestamp
    private Timestamp doj;
    @UpdateTimestamp
    private Timestamp lastUpdated; // compulsory this should Timestamp property
    @Version
    private Integer updationCount;
}
