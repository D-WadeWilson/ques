package com.yz.questionnaire.service;

import com.yz.questionnaire.entity.Answercard;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * (Answercard)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 17:35:40
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


    List<Answercard> queryAll(Answercard answercard);

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

    /**
     *
     *错评率
     * @return
     */
    BigDecimal queryErrorEvaluate();


    /**
     * 漏评率
     */
    BigDecimal queryMissEvaluate();

    /**
     * 错退率
     * @return
     */
    BigDecimal queryErrorExit();

    /**
     * 漏退率
     */
    BigDecimal queryMissExit();

    /**
     * 信息对比率
     */
    BigDecimal queryInfoComparison();

    /**
     * 结对帮扶覆盖率
     */
    BigDecimal queryPairingrate();

    /**
     * 帮扶方式精准率
     */
    BigDecimal queryExactrate();

    /**
     * 帮扶工作满意度
     */
    BigDecimal queryPleasedrate();



}