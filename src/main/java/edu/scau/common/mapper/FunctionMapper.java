package edu.scau.common.mapper;

import edu.scau.common.dto.ActivityManger;
import edu.scau.common.pojo.Information;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @description:功能页面以及信息中心mapper
 * @author: whj
 * @create: 2020-08-01 21:39
 **/
@Mapper
public interface FunctionMapper {
    List<Information> getInformation(int userId);
    List<ActivityManger> getActivity();
}
