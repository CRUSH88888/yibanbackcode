package edu.scau.common.Service.impl;

import edu.scau.common.Service.SearchService;
import edu.scau.common.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: whj
 * @create: 2020-08-02 23:14
 **/
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired(required = false)
    private SearchMapper searchMapper;
    @Override
    public List<String> searchAssociation(String search) {
        char[] chars = search.toCharArray();
        List<String> strings = searchMapper.searchAssociation(chars);
        return strings;
    }
}
