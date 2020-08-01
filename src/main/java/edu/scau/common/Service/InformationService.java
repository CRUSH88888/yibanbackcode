package edu.scau.common.Service;

import edu.scau.common.pojo.Information;

import java.util.List;

/**
 * @description: 消息中心
 * @author: whj
 * @create: 2020-08-01 23:14
 **/
public interface InformationService {
    List<Information> getInformation(int userId);
    Information getInformationById(int id);
    Integer insertInformation(Information information);
}
