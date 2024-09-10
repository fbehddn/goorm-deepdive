package practice.expmission0910.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private Date published_date;
}
