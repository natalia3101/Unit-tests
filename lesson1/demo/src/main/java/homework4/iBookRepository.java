package homework4;

import java.util.List;

public interface iBookRepository {
    List<Book> findAllBooks();
    Book findBookById(int id);
    void saveBook(Book book);
}

