package com.yz.questionnaire.service;

import com.yz.questionnaire.entity.Paper;
import java.util.List;

/**
 * (Paper)表服务接口
 *
 * @author makejava
 * @since 2020-05-26 16:45:58
 */
public interface PaperService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Paper queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Paper> queryAllByLimit(int offset, int limit);


    /**条件查询
     *
     */
    List<Paper> queryAll(Paper paper);
    /**
     * 新增数据
     *
     * @param paper 实例对象
     * @return 实例对象
     */
    Paper insert(Paper paper);

    /**
     * 修改数据
     *
     * @param paper 实例对象
     * @return 实例对象
     */
    Paper update(Paper paper);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}