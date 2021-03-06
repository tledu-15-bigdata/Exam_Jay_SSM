package com.tledu.cn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tledu.cn.pojo.User;
import com.tledu.cn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tledu.cn.util.pageUtils;

import java.util.List;
import java.util.Map;

/**
 * @author sxwstart
 * @create 2021-01-20-10:57:06
 */
@Controller
public class UserController {

    @Autowired
    private UserService userServiceImpl;

    @RequestMapping(value = "/userRegister"/*,consumes="application/x-www-form-urlencoded"*/)
    @ResponseBody
    public int register(@RequestBody User user){

        int mark = userServiceImpl.register(user);
        return mark;
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public int login(@RequestBody User user){

        int mark = userServiceImpl.login(user);
        return mark;

    }
    @RequestMapping("/startStatus")
    @ResponseBody
    public int startStatus(@RequestBody User user){

       userServiceImpl.startStatus(user);
        return 1;

    }
    @RequestMapping("/stopStatus")
    @ResponseBody
    public int stopStatus(@RequestBody User user){

        userServiceImpl.stopStatus(user);
        return 1;

    }
    @RequestMapping("/userDelete")
    @ResponseBody
    public int userDelete(@RequestBody User user){

        userServiceImpl.userDelete(user);

        return 1;
    }
    @RequestMapping("/userSelectAll")
    @ResponseBody
    public pageUtils validateProjectCodeX(@RequestBody Map<String,Object> params){

//        核心分页代码
        PageHelper.offsetPage(Integer.parseInt(params.get("offset").toString()), Integer.parseInt(params.get("pageNumber").toString()));
        List<User> exs = userServiceImpl.userSelectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(exs);

        return new pageUtils(pageInfo.getList(),new Long(pageInfo.getTotal()).intValue());
    }
}
