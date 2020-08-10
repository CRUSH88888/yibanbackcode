package edu.scau.common.Service;

import edu.scau.common.dto.ActivityManger;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-17 15:43
 **/
public interface PublishManagementService {
    public List<ActivityManger> getPublish(int userId);
    public Integer deletePublish(int[] id, int[] type);
}
