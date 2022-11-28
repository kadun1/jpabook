package jpabook.chapter7.model6;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Parent {

    @EmbeddedId
    private ParentId id;

    private String name;
}
