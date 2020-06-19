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
/**
 * Auther: mengguoqing@gmail.com
 * Date: 2020/6/19 2:18 下午
 * Method:
 * Description: 借助此对象封装页面上<input type="checkbox>对象需要的对象
 */
public class CheckBox implements Serializable {
    private static final long serialVersionUID = -4573461489816236836L;
    private Integer id;
    private String name;
}
