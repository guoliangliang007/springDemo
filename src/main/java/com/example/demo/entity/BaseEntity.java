package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity<ID extends Serializable> implements Serializable{

  private ID id;
  private Date createTime = new Date();
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime = new Date();
}
