package com.yz.questionnaire.dao;

import com.yz.questionnaire.entity.Answercard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Answercard)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-01 17:35:38
 */
@Mapper
public interface AnswercardDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Answercard queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Answercard> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param answercard 实例对象
     * @return 对象列表
     */
    List<Answercard> queryAll(Answercard answercard);

    /**
     * 新增数据
     *
     * @param answercard 实例对象
     * @return 影响行数
     */
    int insert(Answercard answercard);

    /**
     * 修改数据
     *
     * @param answercard 实例对象
     * @return 影响行数
     */
    int update(Answercard answercard);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}