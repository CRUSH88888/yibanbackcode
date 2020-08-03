package edu.scau.common.Service;

import edu.scau.common.dto.FootPrint;
import edu.scau.common.pojo.Browse;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-02 17:04
 **/
public interface BrowsedService {
    Integer insertBrowsed(int activityId, int userId);
    List<FootPrint> getFootPrint(int userId);
}
