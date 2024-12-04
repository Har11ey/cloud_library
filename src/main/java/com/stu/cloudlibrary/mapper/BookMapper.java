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
    int returnBook(@Param("id") Long id);

    // 根据ID查找图书
    @Select("SELECT * FROM book WHERE id = #{id}")
    Book findById(Long id);

    // 更新图书信息（例如：修改状态）
    @Update("UPDATE book SET status = #{status} WHERE id = #{id}")
    int updateStatus(@Param("id") Long id, @Param("status") String status);

    // 查询图书，支持分页
    @Select("<script>" +
            "SELECT * FROM book WHERE status = 'available' " +  // 查询可用状态的图书
            "<if test='name != null and name != \"\"'> AND name LIKE CONCAT('%', #{name}, '%') </if>" +  // 图书名称模糊匹配
            "<if test='author != null and author != \"\"'> AND author LIKE CONCAT('%', #{author}, '%') </if>" +  // 作者模糊匹配
            "<if test='publisher != null and publisher != \"\"'> AND publisher LIKE CONCAT('%', #{publisher}, '%') </if>" +  // 出版社模糊匹配
            "LIMIT #{offset}, #{pageSize}" +  // 分页：offset 是偏移量，pageSize 是每页数据量
            "</script>")
    List<Book> searchBooks(@Param("name") String name,
                           @Param("author") String author,
                           @Param("publisher") String publisher,
                           @Param("offset") int offset,
                           @Param("pageSize") int pageSize);

    // 新增图书
    @Insert("INSERT INTO book (name, author, publisher, price, uploadtime, status) VALUES (#{name}, #{author}, #{publisher}, #{price}, NOW(), 'available')")
    int addBook(Book book);

    // 编辑图书
    @Update("UPDATE book SET name = #{name}, author = #{author}, publisher = #{publisher}, price = #{price} WHERE id = #{id}")
    int updateBook(Book book);
}
