package com.ab.object.versioning.entity;

import lombok.Data;

import javax.persistence.Version;

@Data
public class MobilePhoneUser {
    private Long regNo;
    private Long mobileNo;
    private boolean prepaid;
    private String circle;
    private String callerTune;
    /*@Version In annotation driven programming*/
    private Integer updateCount;
}
