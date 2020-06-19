package com.tea.pj.common.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * creatd by mengguoqing on 2020/6/18 12:13 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckBox implements Serializable {
    private static final long serialVersionUID = -4573461489816236836L;
    private Integer id;
    private String name;
}
