package com.example.demo.base.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Results<T> implements Serializable {

    int  count; //数量
    Integer code;// 代码
    String msg;//信息
    List<T> data; //返回数据集合
    T datas;// 任何类型条件

    public Results(){}

    public Results(Integer code,String msg){
        super();
        this.code = code;
        this.msg=msg;
    }

    public Results(int count, Integer code, String msg, List<T> data, T datas) {
        this.count = count;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.datas = datas;
    }

    /*无数据传输的 返回成功的*/
    public static <T> Results success(){
        return  new Results<T>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage());
    }
    public static <T> Results success(String msg){
        return  new Results<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> Results success(ResponseCode responseCode){
        return  new Results<T>(responseCode.getCode(),responseCode.getMessage());
    }
    /*单个数据传输 成功返回*/
    public static <T> Results success(T data){
        return  new Results<T>(0,ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),null,data);
    }
    public static <T> Results success(String msg,T data){
        return  new Results<T>(0,ResponseCode.SUCCESS.getCode(),msg,null,data);
    }
    public static <T> Results success(ResponseCode responseCode,T data){
        return  new Results<T>(0,responseCode.getCode(),responseCode.getMessage(),null,data);
    }
    /*分页数据传输 返回成功*/
    public static <T> Results success(Integer count,List<T> data){
        return  new Results<T>(count,ResponseCode.TABLE_SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),data,null);
    }
    public static <T> Results success(Integer count,List<T> data,String msg){
        return  new Results<T>(count,ResponseCode.TABLE_SUCCESS.getCode(),msg,data,null);
    }
    public static <T> Results success(ResponseCode responseCode,Integer count,List<T> data){
        return  new Results<T>(count,responseCode.getCode(),responseCode.getMessage(),data,null);
    }
    /*无数据传输 失败返回*/
    public static <T> Results failure(){
        return  new Results<T>(ResponseCode.FAIL.getCode(),ResponseCode.FAIL.getMessage());
    }
    public static <T> Results failure(ResponseCode responseCode){
        return  new Results<T>(responseCode.getCode(),responseCode.getMessage());
    }
    public static <T> Results failure(Integer code,String msg){
        return  new Results<T>(code,msg);
    }
    public static  Results ok(){
        return new Results();
    }
}
