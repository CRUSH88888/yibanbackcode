package edu.scau.common.Service.impl;

import edu.scau.common.Service.PublishManagementService;
import edu.scau.common.dto.ActivityManger;
import edu.scau.common.mapper.ActivityCollectedMapper;
import edu.scau.common.mapper.AuthenticationMapper;
import edu.scau.common.mapper.BrowsedMapper;
import edu.scau.common.mapper.PublishManagementMapper;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.ListMerge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<ActivityManger> getPublish(int userId) {
        List<Integer> level = authenticationMapper.getLevel(userId);
        List<ActivityManger> publishActivity=new ArrayList<>();
        List<ActivityManger> publishGroup=new ArrayList<>();
        List<ActivityManger> certificate=new ArrayList<>();
        int max=0;
        for (Integer integer : level) {
            if(integer>max){
                max=integer;
            }
        }
        if(max==3){
            publishActivity=publishManagementMapper.getAllActivity();
            publishGroup=publishManagementMapper.getAllGroup();
            certificate = publishManagementMapper.getAllCertificate();
        }
        else{
            publishActivity = publishManagementMapper.getPublishActivity(userId);
            publishGroup = publishManagementMapper.getPublishGroup(userId);
            certificate = publishManagementMapper.getCertificate(userId);

        }
        for (ActivityManger activityManger : publishActivity) {
            activityManger.setType(1);
            System.out.println(activityManger.toString());
        }
        System.out.println("~~~~~~~~~");
        for (ActivityManger activityManger : certificate) {
            activityManger.setType(2);
            System.out.println(activityManger.toString());
        }
        for (ActivityManger activityManger : publishGroup) {
            activityManger.setType(3);
        }
        List<ActivityManger> activityMangers = ListMerge.listMerge2(publishActivity, certificate);
        List<ActivityManger> activityMangers1 = ListMerge.listMerge2(activityMangers, publishGroup);
        for (ActivityManger activityManger : activityMangers1) {
            activityManger.setDate(DateToStringUtil.publishTime(activityManger.getBuildTime()));
            activityManger.setSelect(false);
        }
        return activityMangers1;
    }

    @Override
    @Transactional
    public Integer deletePublish(int[] id, int[] type) {
        Integer result=0;
        for (int i = 0; i <id.length ; i++) {
            if(type[i]==1){
                result+=publishManagementMapper.deletePublishActivity(id[i]);
                activityCollectedMapper.deleteCollectedActivity(null,id[i]);
                browsedMapper.deleteBrowsed(id[i]);
            }
            else if(type[i]==2){
                browsedMapper.deleteCertificateBrowsed(id[i]);
                result+=publishManagementMapper.deleteCertificate(id[i]);
            }
            else
                result=publishManagementMapper.deletePublishGroup(id[i]);
        }
        return result==id.length?1:0;
    }
}
