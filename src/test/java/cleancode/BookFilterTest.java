package cleancode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookFilterTest {

    private BookFilter bookFilter = new BookFilter();

    @Test
    public void returnOnlySmallBooksBeginningWithLetterA() {

        List<BookFilter.Book> filteredBooks = bookFilter.filterBooks(createBookList(), book -> book.getName().charAt(0) == 'A', book ->  (book.getPages() > BookFilter.Size.SMALL.getMinimumNumberOfPages() && book.getPages() < BookFilter.Size.SMALL.getMaximumNumberOfPages()));
        List<BookFilter.Book> expectedResult = List.of(bookFilter.new Book("Andromeda", 50));
        assertEquals(expectedResult.get(0).getName(), filteredBooks.get(0).getName());
    }

    private List<BookFilter.Book> createBookList() {
        return List.of(bookFilter.new Book("Andromeda", 50),
                bookFilter.new Book("Beauty", 100));
    }

}