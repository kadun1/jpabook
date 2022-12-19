package jpabook.chapter7.model2;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
@PrimaryKeyJoinColumn(name = "BOOK_ID") //ID 재정의
public class Book extends Item {

    private String author;  //작가
    private String isbn;    //ISBN
}
