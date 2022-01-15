package cleancode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookFilter {

    public  List<Book> filterBooks(List<Book> booksToFilter, Predicate<Book>... conditions){

        return booksToFilter.stream().filter(getFinalCondition(conditions)).collect(Collectors.toList());
    }

    private Predicate<Book> getFinalCondition (Predicate<Book>... conditions) {
     /*   Predicate<Book> finalCondition = input -> true;

        for (Predicate<Book> condition: conditions){
            finalCondition = finalCondition.and(condition);
        }
        return finalCondition;*/

        return Arrays.stream(conditions).reduce(input -> true, Predicate::and);
    }

    public class Book {
        private String name;
        private int numberOfPages;

        public Book(String name, int numberOfPages){
            this.name = name;
            this.numberOfPages = numberOfPages;
        }

        public String getName(){
            return this.name;
        }

        public int getPages(){
            return this.numberOfPages;
        }
    }


}
