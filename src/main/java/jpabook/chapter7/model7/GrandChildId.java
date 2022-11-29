package jpabook.chapter7.model7;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

public class GrandChildId implements Serializable {

    private ChildId child;  //GrandChild.child 매핑
    private String id;      //GrandChild.id 매핑

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}