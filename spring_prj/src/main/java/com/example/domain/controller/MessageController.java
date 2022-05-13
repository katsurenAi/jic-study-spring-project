package com.example.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import com.example.domain.entity.MessageEntity;
import com.example.domain.service.MessageService;

/**
 * アカウント情報に対してのリクエストを処理します
 */
@RestController
@RequestMapping("message")
@CrossOrigin
public class MessageController {
    // Beenからserviceクラスを呼び出し
    @Autowired
    MessageService messageService;
      /**
     * メッセージテーブルに登録されている情報を全件取得します
     * 
     * @return List<AccountEntity> アカウント情報リスト
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<MessageEntity> getAll() {
        return messageService.getAll();
    }
  
    /**
     * 投稿されたメッセージを保存します
     * 
     * @param massageParam
     * @return void
     */
    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public void saveMessage(@RequestBody Map massageParam) {
        messageService.saveMessage(massageParam);
        ;
    } 
}
