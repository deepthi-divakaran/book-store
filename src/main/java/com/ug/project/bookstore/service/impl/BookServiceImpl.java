package com.ug.project.bookstore.service.impl;

import com.ug.project.bookstore.common.enums.ApiError;
import com.ug.project.bookstore.common.converter.EntityDtoConverter;
import com.ug.project.bookstore.dto.book.BookDTO;
import com.ug.project.bookstore.entity.book.Book;
import com.ug.project.bookstore.exception.ApiFailedException;
import com.ug.project.bookstore.repository.BookRepository;
import com.ug.project.bookstore.service.book.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;


    private final EntityDtoConverter converter;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, EntityDtoConverter converter) {
        this.bookRepository = bookRepository;
        this.converter = converter;
    }

    @Override
    public BookDTO addBook(BookDTO bookDTO) throws ApiFailedException {
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        Book savedBook = bookRepository.save(book);
        return converter.convertToDTO(savedBook);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDetails) throws ApiFailedException {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new ApiFailedException(ApiError.BOOK_NOT_FOUND));
        BeanUtils.copyProperties(bookDetails, existingBook);
        Book updatedBook = bookRepository.save(existingBook);
        return converter.convertToDTO(updatedBook);
    }

    @Override
    public void deleteBook(Long id) throws ApiFailedException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ApiFailedException(ApiError.BOOK_NOT_FOUND));
        bookRepository.delete(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) throws ApiFailedException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ApiFailedException(ApiError.BOOK_NOT_FOUND));
        return converter.convertToDTO(book);
    }
}
