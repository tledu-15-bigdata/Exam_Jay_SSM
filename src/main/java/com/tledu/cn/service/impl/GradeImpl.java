package com.tledu.cn.service.impl;

import com.tledu.cn.dao.GradeDao;
import com.tledu.cn.dao.GradecDao;
import com.tledu.cn.pojo.Grade;
import com.tledu.cn.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GradeImpl implements GradeService {

    @Autowired
    private GradeDao gradeDao;
//    @Autowired
//    private GradecDao gradecDao;


    @Override
    public int insert1(Grade grade) {
        grade.setGradeId(UUID.randomUUID().toString());
        int i = gradeDao.insert1(grade);
        if (i>0){
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public List<Grade> selectGAll(String str) {
        List<Grade> grades = gradeDao.selectGAll(str);
        return grades;
    }
}
