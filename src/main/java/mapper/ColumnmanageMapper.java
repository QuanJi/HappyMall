package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Columnmanage;
import pojo.ColumnmanageExample;

import java.util.List;

public interface ColumnmanageMapper {
    int countByExample(ColumnmanageExample example);

    int deleteByExample(ColumnmanageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Columnmanage record);

    int insertSelective(Columnmanage record);

    List<Columnmanage> selectByExample(ColumnmanageExample example);

    Columnmanage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Columnmanage record, @Param("example") ColumnmanageExample example);

    int updateByExample(@Param("record") Columnmanage record, @Param("example") ColumnmanageExample example);

    int updateByPrimaryKeySelective(Columnmanage record);

    int updateByPrimaryKey(Columnmanage record);
}