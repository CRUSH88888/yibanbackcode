package edu.scau.common.Service;

import edu.scau.common.dto.PublishManagement;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-07-17 15:43
 **/
public interface PublishManagementService {
    public List<PublishManagement> getPublish(int userId);
    public Integer deletePublish(int[] id, int[] type);
}
