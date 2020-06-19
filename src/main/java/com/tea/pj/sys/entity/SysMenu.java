package com.tea.pj.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 914193380882672899L;
    private Integer id;
    private String name;
    private String url;
    private Integer type;
    private Integer sort;
    private String note;
    private String permission;
    private Integer parentId;
    private String parentName;
    private String createdUser;
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;

}
