package com.example.domain.dto;

import lombok.Data;

@Data
public class TodoForm {
    //編集するid
    private int id;
    //編集投稿された本文
    private String updateBodytext;
}
