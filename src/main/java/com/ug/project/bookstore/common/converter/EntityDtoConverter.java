package com.ug.project.bookstore.common.converter;

import com.ug.project.bookstore.dto.book.BookDTO;
import com.ug.project.bookstore.entity.book.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class EntityDtoConverter {

    public BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }

    public Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        return book;
    }
}
