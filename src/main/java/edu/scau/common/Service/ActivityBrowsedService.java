package edu.scau.common.Service;

import edu.scau.common.dto.IndexActivityStatus;

import java.util.List;

/**
 * @description:
 * @auther:cyf
 * @create:2020/7/3 22:05
 **/
public interface ActivityBrowsedService {


    List<IndexActivityStatus> selectActivityBrowsed();

}
