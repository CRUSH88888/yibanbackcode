package edu.scau.common.mapper;

import edu.scau.common.dto.PublishManagement;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;
import java.util.List;

/**
 * @description: 发布管理的mapper
 * @author: whj
 * @create: 2020-07-17 15:23
 **/
@Mapper
public interface PublishManagementMapper {
    List<PublishManagement> getPublishActivity(int userId);
    List<PublishManagement> getPublishGroup(int userId);
    List<PublishManagement> getAllActivity();
    List<PublishManagement> getAllGroup();
    Integer deletePublishActivity(int id);
    Integer deletePublishGroup(int id);
}
