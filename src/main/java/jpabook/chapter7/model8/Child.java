package jpabook.chapter7.model8;

import javax.persistence.*;

@Entity
public class Child {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;


    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Parent parent;
}
