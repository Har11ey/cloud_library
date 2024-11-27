package com.stu.cloudlibrary.mapper;

import com.stu.cloudlibrary.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    // 查询最新的五本图书，按上架时间降序排列
    @Select("SELECT * FROM book ORDER BY uploadtime DESC LIMIT 5")
    List<Book> findLatestBooks();

    // 借阅图书，更新图书状态和借阅信息
    @Update("UPDATE book SET status = 'borrowed', borrower = #{borrower}, borrowtime = #{borrowTime}, returntime = #{returnTime} WHERE id = #{id} AND status = 'available'")
    int borrowBook(@Param("id") Long id, @Param("borrower") String borrower, @Param("borrowTime") String borrowTime, @Param("returnTime") String returnTime);

    // 还书，更新图书状态
    @Update("UPDATE book SET status = 'available', borrower = NULL, borrowtime = NULL, returntime = NULL WHERE id = #{id} AND status = 'borrowed'")
    int returnBook(Long id);

    // 根据ID查找图书
    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(Long id);

    // 更新图书信息（例如：修改状态）
    @Update("UPDATE book SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);
}
