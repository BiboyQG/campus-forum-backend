package com.example.controller;

import com.example.dto.Account;
import com.example.entity.RestBean;
import com.example.service.AccountService;
import com.example.utils.Const;
import com.example.vo.response.AccountVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class AccountController {

    @Resource
    AccountService service;
    @GetMapping("/info")
    public RestBean<AccountVO> info(@RequestAttribute("id") int id) {
        Account account = service.findAccountById(id);
        return RestBean.success(account.asViewObject(AccountVO.class));
    }

}
