package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.example.domain.entity.AccountEntity;
import com.example.domain.repository.AccountRepository;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class AccountService extends AbstractService<AccountEntity, List<AccountEntity>> {

    // Beenからリポジトリの呼び出し
    @Autowired
    AccountRepository accountRepository;

    /**
     * アカウント情報を全て取得します
     * 
     * @return List<AccountEntity> アカウント情報リスト
     */
    public List<AccountEntity> getAll() {
        return accountRepository.findAll();
    }

        /**
     * 2.IDからツイート情報を取得して返却します
     * 
     * @return TweetEntity ツイート情報
     */
    public AccountEntity findById(int id) {
        return accountRepository.findById(id).orElseThrow();
    }

    /**
     * 3.アカウントを保存します
     * 
     * @param StringString  文字
     * @return void
     * /**
     * 3.ツイートを保存します
     * 
     * （アカウントサービスに移動）
     * 4.データを取り出す
     * 5.AccountEntity型のリストを作成する　
     * 6.entityに取り込む　entityはコンストラクタ
     * 7.リポジトリはアカウントリポジトリを継承しているので、このデータを保存できる
     */
    public void saveAcccount(Map accountParam) {
        List<AccountEntity> entities = Arrays.asList(
                new AccountEntity(
                    7, //ID
                    accountParam.get("email").toString(),//メールアドレス
                    accountParam.get("password").toString(),//PASS
                    accountParam.get("userName").toString(),//ユーザー名 
                    accountParam.get("accountDetails").toString()//アカウントの詳細
                    ));               
             accountRepository.saveAll(entities);
        }

}
