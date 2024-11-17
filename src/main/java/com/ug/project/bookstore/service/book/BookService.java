package com.ug.project.bookstore.service.book;

import com.ug.project.bookstore.dto.book.BookDTO;
import com.ug.project.bookstore.exception.ApiFailedException;

import java.util.List;

public interface BookService {
    BookDTO addBook(BookDTO bookDTO) throws ApiFailedException;

    BookDTO updateBook(Long id, BookDTO bookDetails) throws ApiFailedException;

    void deleteBook(Long id) throws ApiFailedException;

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id) throws ApiFailedException;
}

