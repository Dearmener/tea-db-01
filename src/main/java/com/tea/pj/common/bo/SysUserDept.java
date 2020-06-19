package com.tea.pj.common.bo;

import com.tea.pj.sys.entity.SysDepts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * creatd by mengguoqing on 2020/6/17 11:18 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDept implements Serializable {

    private static final long serialVersionUID = -4361119154235199104L;

    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private String mobile;
    private Integer valid=1;
    private SysDepts sysDept;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
