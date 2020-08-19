package edu.scau.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-18 18:40
 **/
@Data
public class MessageData {
    private Thing2 thing2;
    private Thing5 thing5;
    private Thing6 thing6;
    @Data
    @AllArgsConstructor
    public static class Thing2{
        private String value;
    }
    @Data
    @AllArgsConstructor
    public static class Thing5{
        private String value;
    }
    @Data
    @AllArgsConstructor
    public static class Thing6{
        private String value;
    }
}
