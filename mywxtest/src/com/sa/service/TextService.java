package com.sa.service;

import com.sa.dao.testMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by sa on 14-11-30.
 */
public class TextService {
    private SqlSession sqlSession =null;
    public  static TextService getTextService(SqlSession sqlSession){
        return new TextService(sqlSession);
    }
    public TextService(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List checkUser(){
        testMapper testMapper = this.sqlSession.getMapper(testMapper.class);
        List lists = testMapper.checkUser();
        return lists;
    }
}
