package com.stu.cloudlibrary.model;

import lombok.Data;

@Data
public class BorrowRecord {
    private String borrower;  // 借阅人
    private String name;  // 图书名称
    private String borrowTime; // 借阅时间
    private String returnTime; // 预计归还时间

    // 省略构造方法和 getter、setter
}
