package edu.scau.common.Service.impl;

import edu.scau.common.Service.PublishManagementService;
import edu.scau.common.dto.PublishManagement;
import edu.scau.common.mapper.ActivityCollectedMapper;
import edu.scau.common.mapper.AuthenticationMapper;
import edu.scau.common.mapper.BrowsedMapper;
import edu.scau.common.mapper.PublishManagementMapper;
import edu.scau.common.utils.DateToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 发布管理
 * @author: whj
 * @create: 2020-07-17 15:50
 **/
@Service
public class PublishManagementServiceImpl implements PublishManagementService {
    @Autowired(required = false)
    private PublishManagementMapper publishManagementMapper;
    @Autowired(required = false)
    private ActivityCollectedMapper activityCollectedMapper;
    @Autowired(required = false)
    private BrowsedMapper browsedMapper;
    @Autowired(required = false)
    private AuthenticationMapper authenticationMapper;
    @Override
    public List<PublishManagement> getPublish(int userId) {
        List<Integer> level = authenticationMapper.getLevel(userId);
        List<PublishManagement> publishActivity=new ArrayList<>();
        List<PublishManagement> publishGroup=new ArrayList<>();
        int max=0;
        for (Integer integer : level) {
            if(integer>max){
                max=integer;
            }
        }
        if(max==3){
            publishActivity=publishManagementMapper.getAllActivity();
            publishGroup=publishManagementMapper.getAllGroup();
        }
        else{
            publishActivity = publishManagementMapper.getPublishActivity(userId);
            publishGroup = publishManagementMapper.getPublishGroup(userId);
        }
        for (PublishManagement publishManagement : publishActivity) {
            publishManagement.setType(1);
        }
        for (PublishManagement publishManagement : publishGroup) {
            publishManagement.setType(2);
        }
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
        for (PublishManagement publishManagement : publishManagements) {
            publishManagement.setSelect(false);
        }
        return publishManagements;
    }

    @Override
    @Transactional
    public Integer deletePublish(int[] id, int[] type) {
        Integer result=0;
        for (int i = 0; i <id.length ; i++) {
            if(type[i]==1){
                result=publishManagementMapper.deletePublishActivity(id[i]);
                activityCollectedMapper.deleteCollectedActivity(null,id[i]);
                browsedMapper.deleteBrowsed(id[i]);
            }
            else
                result=publishManagementMapper.deletePublishGroup(id[i]);
        }
        return result;
    }
}
