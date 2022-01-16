package com.tang.goods.controller;

import com.tang.goods.entity.User;
import com.tang.goods.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *文件名: UserContoller
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 13:16
 *描述: 这是一个示例
 */
@RestController
@RequestMapping(value = "/")
public class UserController {
    @RequestMapping(value = "/")
    public String getAccount()
    {
        return "angular/index";
    }


}
