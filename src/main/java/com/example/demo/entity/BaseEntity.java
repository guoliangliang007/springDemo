package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity<ID extends Serializable> implements Serializable{

  private ID id;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String createTime ;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private String updateTime;
}
