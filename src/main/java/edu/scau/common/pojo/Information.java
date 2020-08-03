package edu.scau.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;

/**
 * @description: 信息中心
 * @author: whj
 * @create: 2020-08-01 21:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private int id;
    private String information;//信息
    private int userId;//用户id
    private Boolean browsed;
    private Timestamp publishTime;
    private String date;
}
