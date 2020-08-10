package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityManger;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description: 发布管理的mapper
 * @author: whj
 * @create: 2020-07-17 15:23
 **/
@Mapper
public interface PublishManagementMapper {
    List<ActivityManger> getPublishActivity(int userId);
    List<ActivityManger> getPublishGroup(int userId);
    List<ActivityManger> getCertificate(int userId);
    List<ActivityManger> getAllActivity();
    List<ActivityManger> getAllGroup();
    List<ActivityManger> getAllCertificate();
    Integer deletePublishActivity(int id);
    Integer deletePublishGroup(int id);
    Integer deleteCertificate(int id);
}
