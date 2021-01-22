package com.tledu.cn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tledu.cn.pojo.Examination;
import com.tledu.cn.service.ExaminationService;
import com.tledu.cn.service.UserService;
import com.tledu.cn.service.impl.ExaminationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.pageUtils;

import java.util.List;
import java.util.Map;


@Controller
public class ExaminationController {
    @Autowired
    private ExaminationService examinationImpl;

    @RequestMapping("/insertEx")
    @ResponseBody
    public int insert(@RequestBody Examination examination){
        int mark=1;

         mark = examinationImpl.insertExamination(examination);

        return mark;
    }


    @RequestMapping("/updateEx")
    @ResponseBody
    public int update(@RequestBody Examination examination){
        int mark=0;
        System.out.println("更新的"+examination);
        mark = examinationImpl.updateExamination(examination);
        System.out.println("更新的"+mark);
        return mark;
    }


    @RequestMapping("/deleteEx")
    @ResponseBody
    public int delete(@RequestBody Examination examination){
        int mark=0;

        mark = examinationImpl.deleteExamination(examination);

        return mark;
    }



    @RequestMapping("/selectEx")
    @ResponseBody
    public pageUtils validateProjectCode(@RequestBody Map<String,Object> params){

//        核心分页代码
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("pageNumber").toString()));
        List<Examination> exs = examinationImpl.selectExamination();
        PageInfo<Examination> pageInfo = new PageInfo<Examination>(exs);

        return new pageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }


    //题库详情页
    @RequestMapping("/selectTitleEx")
    @ResponseBody
    public List<Examination> selTitle(@RequestBody Examination examination){

        List<Examination> exs = examinationImpl.selTitleExamination(examination);

        return exs;
    }



}