package com.yz.questionnaire.service.impl;

import com.yz.questionnaire.dao.UserDao;
import com.yz.questionnaire.entity.Answercard;
import com.yz.questionnaire.dao.AnswercardDao;
import com.yz.questionnaire.entity.User;
import com.yz.questionnaire.service.AnswercardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Answercard)表服务实现类
 *
 * @author makejava
 * @since 2020-06-01 17:35:41
 */
@Service("answercardService")
public class AnswercardServiceImpl implements AnswercardService {
    @Resource
    private AnswercardDao answercardDao;

    @Resource
    private UserDao userDao;

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

    @Override
    public List<Answercard> queryAll(Answercard answercard) {
        return this.answercardDao.queryAll(answercard);
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



    @Override
    public BigDecimal queryErrorEvaluate(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));
        paramsMap.put("typeNo","2");
        paramsMap.put("answerNo1","2");
        paramsMap.put("quesNo1","20");
//        paramsMap.put("quesNo2","28");
        paramsMap.put("quesNo3","30");
        paramsMap.put("quesNo4","32");
        paramsMap.put("quesNo5","33");
        ArrayList<String> answerList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            answerList.add(String.valueOf(i+1));
        }
        paramsMap.put("list",answerList);
        int result1 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.put("typeNo","3");
        paramsMap.put("answerNo1","2");
        paramsMap.put("quesNo1","45");
//        paramsMap.put("quesNo2","53");
        paramsMap.put("quesNo3","58");
        paramsMap.put("quesNo4","59");
        paramsMap.put("quesNo5","60");
        int result2 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.put("typeNo","4");
        paramsMap.put("answerNo1","2");
        paramsMap.put("quesNo1","69");
//        paramsMap.put("quesNo2","77");
        paramsMap.put("quesNo3","80");
        paramsMap.put("quesNo4","82");
        paramsMap.put("quesNo5","83");
        int result3 = answercardDao.queryCondtionEvaluate(paramsMap);

        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("2");
        typeList.add("3");
        typeList.add("4");
        paramsMap.put("list",typeList);
        int result4 = userDao.queryCountUserType(paramsMap);

        Integer resultup = result1+result2+result3;

        BigDecimal result = getResultData(resultup, result4);

        return result;
    }

    @Override
    public BigDecimal queryMissEvaluate(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));
        paramsMap.put("typeNo","1");
        paramsMap.put("answerNo1","1");
        paramsMap.put("quesNo1","14");
        int up = answercardDao.queryCondtionEvaluate(paramsMap);

        User user = new User();
        user.setType(1);
        user.setCity(map.get("city"));
        user.setTown(map.get("town"));
        int down = userDao.queryCountUser(user);

        BigDecimal result = getResultData(up, down);
        return result;
    }

    @Override
    public BigDecimal queryErrorExit(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));
        paramsMap.put("typeNo","3");
        paramsMap.put("quesNo7","56");
        paramsMap.put("answerNo7","|2");

        int up1 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.clear();
        paramsMap.put("typeNo","4");
        paramsMap.put("quesNo1","78");
        paramsMap.put("answerNo1","9");
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));

        int up2 = answercardDao.queryCondtionEvaluate(paramsMap);
        int up = up1+up2;

        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("3");
        typeList.add("4");
        paramsMap.put("list",typeList);


        int down = userDao.queryCountUserType(paramsMap);
        BigDecimal result = getResultData(up, down);

        return result;
    }

    @Override
    public BigDecimal queryMissExit(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));
        paramsMap.put("typeNo","2");
        paramsMap.put("quesNo1","36");
        paramsMap.put("answerNo1","2");
        paramsMap.put("quesNo2","35");
        ArrayList<String> answerList = new ArrayList<>();
        answerList.add("1");
        answerList.add("2");
        paramsMap.put("list",answerList);
        paramsMap.put("quesNo3","35");
        paramsMap.put("answerNo3","3");
        int up = answercardDao.queryCondtionEvaluate2(paramsMap);

        User user = new User();
        user.setType(2);
        user.setCity(map.get("city"));
        user.setTown(map.get("town"));
        int down = userDao.queryCountUser(user);

        BigDecimal result = getResultData(up, down);
        return result;
    }

    @Override
    public BigDecimal queryInfoComparison(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));
        paramsMap.put("typeNo","2");
        paramsMap.put("quesNo1","29");
        paramsMap.put("answerNo1","1");
        int up = answercardDao.queryCondtionEvaluate(paramsMap);

        User user = new User();
        user.setType(2);
        user.setCity(map.get("city"));
        user.setTown(map.get("town"));
        int down = userDao.queryCountUser(user);

        BigDecimal result = getResultData(up, down);
        return result;
    }

    @Override
    public BigDecimal queryPairingrate(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("typeNo","2");
        paramsMap.put("quesNo7","44");
        paramsMap.put("answerNo7","1|");
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));

        int up1 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.put("typeNo","3");
        paramsMap.put("quesNo7","68");
        paramsMap.put("answerNo7","1|");
        int up2 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.put("type1","2");
        paramsMap.put("quentionId1","44");
        paramsMap.put("type2","3");
        paramsMap.put("quentionId2","68");
        int down = userDao.queryCountNotUndef(paramsMap);
        System.out.println("分母:"+down);



        int up = up1+up2;

        BigDecimal result = getResultData(up, down);
        return result;
    }

    @Override
    public BigDecimal queryExactrate(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));
        paramsMap.put("typeNo","2");
        paramsMap.put("quesNo1","39");
        paramsMap.put("answerNo1","1");
        int up1 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.put("typeNo","3");
        paramsMap.put("quesNo1","63");
        paramsMap.put("answerNo1","1");
        int up2 = answercardDao.queryCondtionEvaluate(paramsMap);

//        ArrayList<String> typeList = new ArrayList<>();
//        typeList.add("2");
//        typeList.add("3");
//        int down = userDao.queryCountUserType(typeList);

        paramsMap.put("type1","2");
        paramsMap.put("quentionId1","39");
        paramsMap.put("type2","3");
        paramsMap.put("quentionId2","63");
        int down = userDao.queryCountNotUndef(paramsMap);
        System.out.println("分母:"+down);

        int up = up1+up2;

        BigDecimal result = getResultData(up, down);
        return result;

    }

    @Override
    public BigDecimal queryPleasedrate(Map<String, String> map) {
        HashMap<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("city",map.get("city"));
        paramsMap.put("town",map.get("town"));
        paramsMap.put("typeNo","1");
        paramsMap.put("quesNo8","16");
        int up1 = answercardDao.queryCondtionEvaluate(paramsMap);

        User user = new User();
        user.setType(1);
        user.setCity(map.get("city"));
        user.setTown(map.get("town"));
        int down1 = userDao.queryCountUser(user);
        BigDecimal result1 = getResultData(up1, down1);


        paramsMap.put("type1","2");
        paramsMap.put("quesNo8","40");
        int up2 = answercardDao.queryCondtionEvaluate(paramsMap);


        paramsMap.put("type1","2");
        paramsMap.put("quentionId1","40");
        int down2= userDao.queryCountNotUndef(paramsMap);

        BigDecimal result2 = getResultData(up2, down2);


        paramsMap.put("typeNo","3");
        paramsMap.put("quesNo8","64");
        int up3 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.put("type1","3");
        paramsMap.put("quentionId1","64");
        int down3= userDao.queryCountNotUndef(paramsMap);
        BigDecimal result3 = getResultData(up3, down3);


        paramsMap.put("typeNo","4");
        paramsMap.put("quesNo8","84");
        int up4 = answercardDao.queryCondtionEvaluate(paramsMap);

        paramsMap.put("type1","4");
        paramsMap.put("quentionId1","84");
        int down4= userDao.queryCountNotUndef(paramsMap);
        BigDecimal result4 = getResultData(up4, down4);

        result1 = result1.multiply(BigDecimal.valueOf(0.1));
        result2 = result2.multiply(BigDecimal.valueOf(0.4));
        result3 = result3.multiply(BigDecimal.valueOf(0.4));
        result4 = result4.multiply(BigDecimal.valueOf(0.1));
        BigDecimal result = result1.add(result2).add(result3).add(result4);
        return result;

    }

    private BigDecimal getResultData(int up, int down) {
        BigDecimal result = new BigDecimal(0);
        if(0 != down){
            result = BigDecimal.valueOf(up).divide(BigDecimal.valueOf(down),2,BigDecimal.ROUND_HALF_UP);
        }
        return result;
    }
}