package org.huifer.seata.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.huifer.seata.product.entity.TestTx;

@Mapper
public interface TestTxMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTx record);

    int insertSelective(TestTx record);

    TestTx selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTx record);

    int updateByPrimaryKey(TestTx record);

    void addOne(@Param("i") int id);
}