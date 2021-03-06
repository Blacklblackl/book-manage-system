package com.luojs.bookmanagesystem.common.domain;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 接收前端查询参数类
 * @author: luojs
 * @since: 2020/8/3
 */
public class Params extends HashMap<String,Object> {

    private Params() {
    }

    private Params(Map<? extends String, ?> m) {
        super(m);
    }

    public static Params build(Map<String,?> param){
        return new Params(param);
    }

    public static Params buildDefault(){
        return new Params();
    }

    public Params putE(String key, Object value) {
        put(key, value);
        return this;
    }

    /**
     * 清理空值
     * 将字符串类型的"空值"全部替换成null
     */
    public Params cleanEmpty(){
        this.replaceAll((k,v)->{
            // 如果是字符串 且符合空字符判断标准则赋值个null
            if(v instanceof String && StringUtils.isEmpty(v.toString())){
                return null;
            }
            return v;
        });
        return this;
    }

    public Integer getInt(String key){
        Object obj = this.get(key);
        if(obj instanceof Integer){
            return (Integer) obj;
        }else if(obj instanceof String){
            return Integer.valueOf(obj.toString());
        }
        return null;
    }

    public String getString(String key){
        Object obj = this.get(key);
        return obj==null?null:obj.toString();
    }

}
