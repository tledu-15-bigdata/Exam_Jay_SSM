package com.tledu.cn.controller;


import com.tledu.cn.pojo.Gradec;
import com.tledu.cn.pojo.PageInfo;
import com.tledu.cn.pojo.Paperc;
import com.tledu.cn.service.GradecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tledu.cn.util.JDK8DateUtil;

@Controller
public class GradecController {

    @Autowired
    private GradecService gradecImpl;



    @RequestMapping("/selectExam1")
    @ResponseBody
    public PageInfo<Paperc> selectPaperc(@RequestBody Gradec gradec){
        String paperId = gradec.getPaperId();
        int currentPage = gradec.getCurrentPage();
//        System.out.println(paperId+"---"+currentPage);

        PageInfo<Paperc> allByPage = gradecImpl.findAllByPage(currentPage, 1, paperId);

        //System.out.println(currentPage);


        gradec.setFinishcTime(JDK8DateUtil.LocalDateTime2String(null,null));

//        Gradec gradec1 = gradecImpl.insertPapercAll(gradec);
        if (currentPage!=1){
            gradecImpl.selectPaperAll(gradec,allByPage.getTotalPage());
        }


        Gradec gradec1 = gradecImpl.insertPapercAll(gradec);
//        System.out.println(currentPage+"---"+gradec1);


        return allByPage;
    }




}
