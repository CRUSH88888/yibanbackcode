package edu.scau.common.utils;

import java.util.List;

/**
 * @CreateDate 
 * @Author 
 * @Description 分页处理工具类
 */
public class PageUtil {
    private String pageSize;
    private String pageNum;

    public PageUtil(String pageSize, String pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }

    public static ApiResponse pageManual(List entities, Integer pageNumber, Integer pageSize, Integer maxCount) {
        return new ApiResponse(0,"success",entities,pageNumber,pageSize,maxCount,getTotalPages(maxCount, pageSize));
    }

    public String getPageSize() {
        return pageSize;
    }

    public String getPageNum() {
        return pageNum;
    }

    public PageUtil invoke() {
        // 默认每页显示10页
        try {
            Integer pageSize2 = Integer.valueOf(pageSize);
            if (pageSize2 <= 0)
                pageSize = "10";
        } catch (Exception ex) {
            pageSize = "10";
        }
        // 默认显示第一页
        try {
            Integer pageNum2 = Integer.valueOf(pageNum);
            if (pageNum2 < 0)
                pageNum = "0";
        } catch (Exception ex) {
            pageNum = "0";
        }
        return this;
    }

    public static Integer getTotalPages(Integer countNum, Integer pageSize) {
        if((countNum%pageSize)==0) {
            return ((countNum/pageSize));
        }else {
            return ((countNum/pageSize)+1);
        }
    }
}
