package jpabook.chapter7.model1;

import javax.persistence.*;

@Entity
@DiscriminatorValue("A")
public class Album extends Item{

    private String artist;

}
