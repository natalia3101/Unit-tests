package homework4Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import homework4.BookService;
import homework4.iBookRepository;
import homework4.Book;

public class BookServiceTest {
    @Mock
    private iBookRepository bookRepository;
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Инициализация мок-объектов

        // Создаем мок-объект bookRepository
        bookRepository = Mockito.mock(iBookRepository.class);
    
        // Создаем экземпляр BookService, передавая мок-объект BookRepository
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetAllBooks() {
        // Создаем список книг для заглушки
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Book1", "Author1"));
        books.add(new Book(2, "Book2", "Author2"));

        // Указываем, что при вызове findAllBooks() должен возвращаться список books
        Mockito.when(bookRepository.findAllBooks()).thenReturn(books);

        // Вызываем метод getAllBooks() и проверяем, что он возвращает ожидаемый результат
        List<Book> result = bookService.getAllBooks();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetBookById() {
        // Создаем заглушку для книги с id=1
        Book book = new Book(1, "Book1", "Author1");

        // Указываем, что при вызове findBookById(1) должен возвращаться объект book
        Mockito.when(bookRepository.findBookById(1)).thenReturn(book);

        // Вызываем метод getBookById(1) и проверяем, что он возвращает ожидаемую книгу
        Book result = bookService.getBookById(1);
        assertEquals("Book1", result.getTitle());
    }

    @Test
    public void testAddBook() {
        // Создаем новую книгу
        Book newBook = new Book(3, "New Book", "New Author");

        // Вызываем метод addBook() для добавления новой книги
        bookService.addBook(newBook);

        // Проверяем, что метод saveBook был вызван с новой книгой в качестве аргумента
        Mockito.verify(bookRepository, Mockito.times(1)).saveBook(newBook);
    }
}
