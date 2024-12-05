package com.stu.cloudlibrary.mapper;

import com.stu.cloudlibrary.model.BorrowRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface RecordMapper {

        @Select("SELECT borrower, name, borrowTime, returnTime FROM book WHERE borrower = #{username}")
        List<BorrowRecord> getBorrowRecordsByUsername(@Param("username") String username);

        @Select("SELECT borrower, name, borrowTime, returnTime FROM book")
        List<BorrowRecord> getAllBorrowRecords();

}
