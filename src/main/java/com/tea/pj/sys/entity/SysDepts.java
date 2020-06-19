package com.tea.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.net.Inet4Address;
import java.util.Date;

@Data
public class SysDepts implements Serializable {

    private static final long serialVersionUID = 5023554432569278656L;
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
