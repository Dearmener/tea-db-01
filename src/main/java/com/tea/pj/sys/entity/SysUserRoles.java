package com.tea.pj.sys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserRoles implements Serializable {

    private Integer id;
    private Integer user_id;
    private Integer role_id;

}
