package jpabook.chapter7.model7;

import java.io.Serializable;
import java.util.Objects;

public class ChildId implements Serializable {

    private String parent; //Child.parent 매핑
    private String childId; //Child.childId 매핑

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
