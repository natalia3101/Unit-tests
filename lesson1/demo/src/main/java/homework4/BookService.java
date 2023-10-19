package homework4;

import java.util.List;

public class BookService {

    private iBookRepository bookRepository;

    public BookService(iBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public Book getBookById(int id) {
        return bookRepository.findBookById(id);
    }

    public void addBook(Book book) {
        bookRepository.saveBook(book);
    }

}
