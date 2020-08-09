package edu.scau.common.mapper;

import edu.scau.common.pojo.CertificateFile;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @description:
 * @auther:cyf
 * @create:2020/8/9 22:33
 **/
@Mapper
public interface CertificateFileMapper extends MySqlMapper<CertificateFile>, BaseMapper<CertificateFile> {
}
