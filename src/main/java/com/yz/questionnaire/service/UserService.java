package com.yz.questionnaire.service;

import com.yz.questionnaire.entity.User;

import java.util.List;
import java.util.Map;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2020-06-01 17:36:07
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);


    /**
     * 跟据条件查询
     */
    List<User> queryAll(User user);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 通过条件查询数量
     * @param user
     * @return
     */
    List queryCountUser(Map<String, String> map);

    int queryCountUserType(Map<String, Object> map);



}