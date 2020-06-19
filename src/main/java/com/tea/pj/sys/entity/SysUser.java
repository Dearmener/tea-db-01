package com.tea.pj.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {

    private static final long serialVersionUID = -7165306623490975251L;

    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid=1;
    private Integer deptId;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
