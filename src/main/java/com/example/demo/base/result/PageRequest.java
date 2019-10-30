package com.example.demo.base.result;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageRequest implements Serializable {

    private Integer page;

    private Integer limit;

    private Integer offset;

    public void countOffset(){
        if(null==this.page || null == this.limit){
            this.offset = 0;
            return ;
        }
        this.offset = (this.page-1) * limit;
    }
}
