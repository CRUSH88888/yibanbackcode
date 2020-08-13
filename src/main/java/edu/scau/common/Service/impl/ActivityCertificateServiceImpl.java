package edu.scau.common.Service.impl;

import com.github.pagehelper.PageHelper;
import edu.scau.common.Service.ActivityCertificateService;
import edu.scau.common.dto.ActivityCertificateCollected;
import edu.scau.common.dto.IndexActivityCertificate;
import edu.scau.common.mapper.ActivityCertificateMapper;
import edu.scau.common.mapper.CertificateFileMapper;
import edu.scau.common.pojo.ActivityCertificate;
import edu.scau.common.pojo.CertificateFile;
import edu.scau.common.utils.DateToStringUtil;
import edu.scau.common.utils.LabelTransUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 20:10
 **/
@Service
public class ActivityCertificateServiceImpl implements ActivityCertificateService {
    @Autowired
    private ActivityCertificateMapper activityCertificateMapper;
    @Autowired
    private CertificateFileMapper certificateFileMapper;


    @Override
    public Boolean save(ActivityCertificate activityCertificate) {
        Integer certificateId = activityCertificateMapper.insertCertificate(activityCertificate);
        System.out.println(certificateId);
        for (String s:activityCertificate.getFileUrl()
        ) {
            activityCertificateMapper.insertCertificateFile(s,certificateId);
        }
        for (String s:activityCertificate.getLabels()
             ) {
            activityCertificateMapper.insertCertificateLabel(s,certificateId);
        }

        return null;
    }

    @Override
    public Integer collectedCertificate(Integer userId, Integer certificateId) {
        List<Integer> collectionResult = new ArrayList<>();
         collectionResult = activityCertificateMapper.checkedCertifiedCollected(userId,certificateId);

        for (Integer i:collectionResult
             ) {
            System.out.println(i);
        }
        if (collectionResult.size()==0){
            activityCertificateMapper.collectedCertificate(userId,certificateId);
        }else if (collectionResult.size()>1){
            for (int i = 1;i<collectionResult.size();i++){
                System.out.println("delete: " + i);
                activityCertificateMapper.deleteCertifiedCollected(collectionResult.get(i));
            }
        }
        return 1;
    }

    @Override
    public Integer updateCertificate(ActivityCertificate activityCertificate) {
        activityCertificateMapper.updateCertificate(activityCertificate);
        List<String> files = activityCertificate.getFileUrl();
        for (String s:files
             ) {
            certificateFileMapper.updateByPrimaryKey(new CertificateFile());
        }

        return null;
    }

    @Override
    public Integer deleteCollectedCertificate(Integer userId, Integer certificateId) {
        return activityCertificateMapper.deleteCollectedCertificate(userId,certificateId);
    }

    @Override
    public List<IndexActivityCertificate> get(Integer userId) {
        List<IndexActivityCertificate> activityCertificates = new ArrayList<>();
        List<ActivityCertificate> certificates = activityCertificateMapper.selectCertificate();
        for (ActivityCertificate a:certificates
             ) {
            a.setFileUrl(activityCertificateMapper.selectFileUrl(a.getId()));
            a.setLabels(activityCertificateMapper.selectLabels(a.getId()));
            IndexActivityCertificate certificate =  new IndexActivityCertificate();
            certificate.setActivityCertificate(a);
            certificate.setBrowsed(activityCertificateMapper.checkedCertificateBrowsed(userId,a.getId()).size()>0?true:false);
            certificate.setBuiltTimeToNow(DateToStringUtil.publishTime(a.getBuildingTime()));
            certificate.getActivityCertificate().setLabels(LabelTransUtils.numStringTranToString(certificate.getActivityCertificate().getLabels()));
            activityCertificates.add(certificate);
        }
        return activityCertificates;
    }

    @Override
    public IndexActivityCertificate selectCertificateById(Integer certificateId, Integer userId) {
        ActivityCertificate activityCertificate = activityCertificateMapper.selectCertificateById(certificateId);
        IndexActivityCertificate indexActivityCertificate = new IndexActivityCertificate();
        indexActivityCertificate.setActivityCertificate(activityCertificate);
        indexActivityCertificate.setBuiltTimeToNow(DateToStringUtil.publishTime(activityCertificate.getBuildingTime()));
        List<Integer> collectionResult = activityCertificateMapper.checkedCertifiedCollected(userId,certificateId);
        for(int i = 1;i<collectionResult.size();i++){
            System.out.println(collectionResult.get(i));
            activityCertificateMapper.deleteCertifiedCollected(collectionResult.get(i));
        }
        indexActivityCertificate.setBrowsed(collectionResult.size()>0?true:false);
        return indexActivityCertificate;
    }

    @Override
    public Integer insertCertificateBrowsed(Integer certificateId, Integer userId) {

        List<Integer> result = activityCertificateMapper.checkedCertificateBrowsed(certificateId,userId);
        for (Integer i:result
             ) {
            System.out.println(i);
        }

        if (result == null || result.size() == 0){
            return activityCertificateMapper.insertCertifiedBrowsed(certificateId,userId);
        }else if (result.size() > 1){
            for (int i = 1;i<result.size();i++){
                System.out.println("delete: " + i);
                activityCertificateMapper.deleteCertificateBrowsed(result.get(i));
            }
             activityCertificateMapper.updateCertificateBrowsed(userId,certificateId, new Timestamp(System.currentTimeMillis()));
        }
        return 1;
    }

    @Override
    public List<ActivityCertificate> selectCollectedCertificate(Integer userId) {
        return activityCertificateMapper.selectCollectedCertificate(userId);
    }
}
