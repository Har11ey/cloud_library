package com.stu.cloudlibrary.service;

import com.stu.cloudlibrary.mapper.RecordMapper;
import com.stu.cloudlibrary.model.BorrowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordService {
    @Autowired
    private RecordMapper borrowRecordMapper;

    public List<BorrowRecord> getBorrowRecordsByUsername(String username) {
        return borrowRecordMapper.getBorrowRecordsByUsername(username);
    }

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordMapper.getAllBorrowRecords();
    }
}
