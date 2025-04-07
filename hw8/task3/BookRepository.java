package com.example.books;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS books ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "Название TEXT NOT NULL, "
                + "Автор TEXT NOT NULL, "
                + "\"Год выпуска\" INTEGER, "
                + "Издательство TEXT"
                + ")");
    }
    
    public int save(Book book) {
        return jdbcTemplate.update(
            "INSERT INTO books (Название, Автор, \"Год выпуска\", Издательство) VALUES (?, ?, ?, ?)",
            book.getTitle(), book.getAuthor(), book.getYear(), book.getPublisher());
    }
    
    public Book findById(Long id) {
        return jdbcTemplate.queryForObject(
            "SELECT * FROM books WHERE id = ?", 
            new Object[]{id}, new BookRowMapper());
    }
    
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM books", new BookRowMapper());
    }
    
    public int update(Book book) {
        return jdbcTemplate.update(
            "UPDATE books SET Название = ?, Автор = ?, \"Год выпуска\" = ?, Издательство = ? WHERE id = ?",
            book.getTitle(), book.getAuthor(), book.getYear(), book.getPublisher(), book.getId());
    }
    
    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}
