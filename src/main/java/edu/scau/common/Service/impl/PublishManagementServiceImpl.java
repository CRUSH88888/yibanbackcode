package edu.scau.common.Service.impl;

import edu.scau.common.Service.PublishManagementService;
import edu.scau.common.dto.PublishManagement;
import edu.scau.common.mapper.PublishManagementMapper;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 发布管理
 * @author: whj
 * @create: 2020-07-17 15:50
 **/
@Service
public class PublishManagementServiceImpl implements PublishManagementService {
    @Autowired
    private PublishManagementMapper publishManagementMapper;
    @Override
    public List<PublishManagement> getPublish(int userId) {
        List<PublishManagement> publishActivity = publishManagementMapper.getPublishActivity(userId);
        List<PublishManagement> publishGroup = publishManagementMapper.getPublishGroup(userId);
        List<PublishManagement> publishManagements = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<publishActivity.size()&&j<publishGroup.size()){
            if(publishActivity.get(i).getPublishTime().after(publishGroup.get(j).getPublishTime())){
                publishManagements.add(publishActivity.get(i));
                i++;
            }else{
                publishManagements.add(publishGroup.get(j));
                j++;
            }
        }
        if(i!=publishActivity.size()){
            for(int a=i;a<publishActivity.size();a++){
                publishManagements.add(publishActivity.get(a));
            }
        }else{
            for(int b=j;b<publishGroup.size();b++){
                publishManagements.add(publishGroup.get(b));
            }
        }
        for (PublishManagement publishManagement : publishManagements) {
            publishManagement.setDate(DateToStringUtil.publishTime(publishManagement.getPublishTime()));
        }
        return publishManagements;
    }
}
