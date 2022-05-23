package com.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import javax.persistence.*;

/**
 * アカウントの情報を永続化するEntity
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "diary")	//指定しないと生成されるテーブルはクラス名と同じdiary
public class TodoEntity {
    public TodoEntity(String bodytext, LocalDateTime createDatetime) {
        this.bodytext = bodytext;
        this.createDatetime = createDatetime;
    }
    // ID
    @Id
    @GeneratedValue
    private int id;

    // テキスト
    @Column(nullable = false)
    private String bodytext;

    // 入力時間
    @Column(name = "create_datetime", nullable = false)
    private LocalDateTime  createDatetime;

}
