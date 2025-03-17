package src.main.java.me.cu.test_rest.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BookDto {
    private long id;
    private String name;
    private String author;

    public static void main(String[] args) {
        BookDto b1 = new BookDto(1, "Книга 1", "Пупкин В.В.");
        BookDto b2 = new BookDto(2, "Книга 2", "Оруэлл Дж.");
        BookDto b3 = new BookDto(3, "Книга 3", "Некрасов Н.А.");
    }
}
