package com.yz.questionnaire.dao;

import com.yz.questionnaire.entity.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Paper)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 16:45:58
 */
@Mapper
public interface PaperDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Paper queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Paper> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param paper 实例对象
     * @return 对象列表
     */
    List<Paper> queryAll(Paper paper);

    /**
     * 新增数据
     *
     * @param paper 实例对象
     * @return 影响行数
     */
    int insert(Paper paper);

    /**
     * 修改数据
     *
     * @param paper 实例对象
     * @return 影响行数
     */
    int update(Paper paper);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}