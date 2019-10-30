package com.example.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity<Integer>{


  private String username;

  private String password;

  private String phone;

  private Integer status;

  private String birthdy;

  public interface  Status{
    int DISABLED = 0;
    int VALID =1;
    int LOCKED =2;
  }

}
