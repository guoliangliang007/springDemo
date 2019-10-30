package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("tree")
    public String treeTable(){
        return "test/treetable";
    }
    @RequestMapping("treedata")
    @ResponseBody
    public String treedata(){
        String s = "{\n" +
                "  \"code\": 0,\n" +
                "  \"msg\": \"ok\",\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": -1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": -1\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 5\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 8,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 9,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 9\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 11,\n" +
                "      \"name\": \"xx\",\n" +
                "      \"sex\": \"male\",\n" +
                "      \"pid\": 9\n" +
                "    }\n" +
                "  ],\n" +
                "  \"count\": 11\n" +
                "}";
        String ss = "{\"count\":0,\"code\":0,\"msg\":\"请求成功\",\"data\":[{\"id\":1,\"name\":\"用户管理\",\"css\":null,\"href\":null,\"type\":1,\"permission\":null,\"sort\":null,\"pid\":0},{\"id\":2,\"name\":\"用户管理\",\"css\":null,\"href\":null,\"type\":1,\"permission\":null,\"sort\":null,\"pid\":1},{\"id\":3,\"name\":\"查询\",\"css\":null,\"href\":null,\"type\":0,\"permission\":null,\"sort\":null,\"pid\":2},{\"id\":4,\"name\":\"新增\",\"css\":null,\"href\":null,\"type\":0,\"permission\":null,\"sort\":null,\"pid\":2},{\"id\":5,\"name\":\"删除\",\"css\":null,\"href\":null,\"type\":0,\"permission\":null,\"sort\":null,\"pid\":2}],\"datas\":null}";
        return ss;
    }
}
