package com.example.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.domain.entity.AccountEntity;
import com.example.domain.service.AccountService;

/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("account")
@CrossOrigin
public class AccountController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    AccountService accountService;

    /**
     * アカウント情報を全件取得します
     * 
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<AccountEntity> getAll() {
        return accountService.getAll();
    }
    /**
     * 2.アカウント情報を全件取得
     * 
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/get/id", method = RequestMethod.GET)
    public List<AccountEntity> findById() {
        return accountService.getAll();
    }

    /**
     * 3.アカウント情報を保存します
     * 
     * @param accountParam
     * @return void
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public void saveAcccount(@RequestBody Map accountParam) {
        accountService.saveAcccount(accountParam);
        ;
    } 
}
