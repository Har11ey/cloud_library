package com.stu.cloudlibrary.model;

import lombok.Data;

@Data
public class Book {
    private Long id;            // 图书ID
    private String name;        // 图书名称
    private String publisher;   // 出版社
    private String author;      // 作者
    private String pagination;  // 页数
    private Double price;       // 价格
    private String uploadTime;  // 上架时间
    private String status;      // 图书状态 (例如: available, borrowed)
    private String borrower;    // 借阅人
    private String borrowTime;  // 借阅时间
    private String returnTime;  // 预计归还时间
}
