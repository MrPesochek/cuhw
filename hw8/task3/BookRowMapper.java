package com.example.books;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("Название"));
        book.setAuthor(rs.getString("Автор"));
        book.setYear(rs.getObject("Год выпуска", Integer.class));
        book.setPublisher(rs.getString("Издательство"));
        return book;
    }
}
