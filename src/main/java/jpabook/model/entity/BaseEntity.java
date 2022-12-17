package jpabook.model.entity;

import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {

    private Date createdDate;       //등록일
    private Date lastModifiedDate;  //수정일
}
