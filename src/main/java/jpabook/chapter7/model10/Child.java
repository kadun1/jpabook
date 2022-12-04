package jpabook.chapter7.model10;

import javax.persistence.*;

//자식
@Entity
public class Child {

    @Id @GeneratedValue
    @Column(name = "CHILD_ID")
    private Long id;
    private String name;

    //양방향 매핑
    @OneToOne(mappedBy = "child")
    private Parent parent;
}
