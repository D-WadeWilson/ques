package com.yz.questionnaire.service.impl;

import com.yz.questionnaire.entity.Answercard;
import com.yz.questionnaire.dao.AnswercardDao;
import com.yz.questionnaire.service.AnswercardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Answercard)表服务实现类
 *
 * @author makejava
 * @since 2020-05-26 11:59:03
 */
@Service("answercardService")
public class AnswercardServiceImpl implements AnswercardService {
    @Resource
    private AnswercardDao answercardDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Answercard queryById(Integer id) {
        return this.answercardDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Answercard> queryAllByLimit(int offset, int limit) {
        return this.answercardDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param answercard 实例对象
     * @return 实例对象
     */
    @Override
    public Answercard insert(Answercard answercard) {
        this.answercardDao.insert(answercard);
        return answercard;
    }

    /**
     * 修改数据
     *
     * @param answercard 实例对象
     * @return 实例对象
     */
    @Override
    public Answercard update(Answercard answercard) {
        this.answercardDao.update(answercard);
        return this.queryById(answercard.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.answercardDao.deleteById(id) > 0;
    }
}