package com.stu.cloudlibrary.controller;

import com.stu.cloudlibrary.model.BorrowRecord;
import com.stu.cloudlibrary.service.BorrowRecordService;
import com.stu.cloudlibrary.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    // 根据用户名获取借阅记录
    @GetMapping("/records")
    public ApiResponse<List<BorrowRecord>> getBorrowRecords(@RequestParam String username) {
        // 查询借阅记录
        List<BorrowRecord> records = borrowRecordService.getBorrowRecordsByUsername(username);

        if (records != null && !records.isEmpty()) {
            // 如果有记录，返回成功响应
            return ApiResponse.success(records, "借阅记录查询成功");
        } else {
            // 如果没有记录，返回没有数据的响应
            return ApiResponse.failed("暂无借阅记录");
        }
    }


    // 获取所有借阅记录
    @GetMapping("/allRecords")
    public ApiResponse<List<BorrowRecord>> getAllBorrowRecords() {
        // 查询所有借阅记录
        List<BorrowRecord> records = borrowRecordService.getAllBorrowRecords();

        // 判断记录是否为空
        if (records != null && !records.isEmpty()) {
            // 如果有记录，返回成功响应
            return ApiResponse.success(records, "所有借阅记录查询成功");
        } else {
            // 如果没有记录，返回失败响应
            return ApiResponse.failed("暂无借阅记录");
        }
    }

}
