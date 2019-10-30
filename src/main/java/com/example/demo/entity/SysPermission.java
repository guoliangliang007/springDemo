package com.example.demo.entity;

import lombok.Data;

@Data
public class SysPermission {
    private Integer id;
    private Integer pId;
    private String name;
    private String css;
    private String href;
    private Integer type;
    private String permission;
    private Integer sort;
}
