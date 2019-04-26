package service;

import mapper.ColumnmanageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Columnmanage;
import pojo.ColumnmanageExample;
import service.all_interface.ColumnInterface;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/7 0007 19:44
 * @Version 1.0
 */
@Service
public class ColumnImpl implements ColumnInterface {
    @Autowired
    ColumnmanageMapper columnMapper;
    @Override
    public List<Columnmanage> getColumn(ColumnmanageExample columnmanageExample) throws Exception {
        return columnMapper.selectByExample(columnmanageExample);
    }
}
