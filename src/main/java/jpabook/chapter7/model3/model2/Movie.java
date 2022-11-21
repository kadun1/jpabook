package jpabook.chapter7.model3.model2;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
public class Movie extends Item {

    private String director;    //감독
    private String actor;       //배우
}
