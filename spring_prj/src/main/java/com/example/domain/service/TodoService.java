package com.example.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.example.domain.entity.TodoEntity;
import com.example.domain.repository.TodoRepository;

/**
 * アカウント情報を操作するビジネスロジックを実装します
 */
@Service
@Transactional
public class TodoService implements ServiceInterFace<List<TodoEntity>> {

    // Beenからリポジトリの呼び出し
    @Autowired
    TodoRepository todoRepository;

    /**
     * アカウント情報を全て取得します
     * @return List<AccountEntity> アカウント情報リスト
     */
    public List<TodoEntity> getAll() {
        return todoRepository.findAll();
    }

    /**
     * アカウントIDと一致する情報を削除します。
     * @param id  文字
     * @return void
     */
    public void delete(int id) {
        //削除する処理
        todoRepository.deleteById(id);
        
    }

    /**
     * 新規登録
     * @param accountParam
     * @return void*/
     
    public void add(String newdiary) {
        TodoEntity diary = new TodoEntity(newdiary, LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
        todoRepository.save(diary);
    }

    /**
     * 更新画面用に検索（入力されている文字を表示させる）
     * @param accountParam
     * @return void*/
     
    public TodoEntity findById(int id) {
        return todoRepository.findById(id).orElseThrow();
    }


    /**
     * アカウント情報を降順にソートします
     * @return void
     */
    public List<TodoEntity> desc() {
        return todoRepository.desc();
    }

    /**
     * アカウント情報を昇順にソートします
     * @return void
     */
    public List<TodoEntity> asc() {
        return todoRepository.asc();
    }
} 