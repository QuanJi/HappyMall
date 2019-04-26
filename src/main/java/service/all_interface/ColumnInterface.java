package service.all_interface;

import pojo.Columnmanage;
import pojo.ColumnmanageExample;

import java.util.List;

/**
 * @Author: QuanJingyuan
 * @Date: 2019/4/7 0007 19:42
 * @Version 1.0
 */
public interface ColumnInterface {
    List<Columnmanage> getColumn(ColumnmanageExample columnmanageExample)throws  Exception;
}
