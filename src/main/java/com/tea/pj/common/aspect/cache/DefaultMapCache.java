package com.tea.pj.common.aspect.cache;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * creatd by mengguoqing on 2020/6/22 9:47 上午
 */
@Component
public class DefaultMapCache {

    //使用Map作为存储对数据的容器
    private Map<Object,Object> cache = new ConcurrentHashMap<>();

    public void put(Object key,Object value){

    }

    public Object getObject(Object key){
        return cache.get(key);
    }

}
