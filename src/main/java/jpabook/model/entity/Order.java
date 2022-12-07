package jpabook.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//주문
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    private Long id;
}
