package com.zarek.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhao
 * @date 2021/2/27 18:10
 */
public class PrintJson {

    public static void printJsonFlag(HttpServletResponse response,boolean flag){

        Map<String,Object> map = new HashMap<String, Object>();

        map.put("success",flag);

        ObjectMapper om = new ObjectMapper();

        try {
            String json = om.writeValueAsString(map);
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void pringJsonObj(HttpServletResponse response,Object obj){

        ObjectMapper om = new ObjectMapper();

        try {
            String json = om.writeValueAsString(obj);
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
