package jpabook.chapter7.model13;

import javax.persistence.*;
import java.util.List;

@Entity
public class Child {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;
}
