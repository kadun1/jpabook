package jpabook.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

//회원
@Entity
public class Member extends BaseEntity{

    @Id
    private Long id;
}
