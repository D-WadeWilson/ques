package com.yz.questionnaire.service;

import com.yz.questionnaire.entity.Answercard;
import java.util.List;

/**
 * (Answercard)表服务接口
 *
 * @author makejava
 * @since 2020-05-26 11:58:56
 */
public interface AnswercardService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Answercard queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Answercard> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param answercard 实例对象
     * @return 实例对象
     */
    Answercard insert(Answercard answercard);

    /**
     * 修改数据
     *
     * @param answercard 实例对象
     * @return 实例对象
     */
    Answercard update(Answercard answercard);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}