package jpabook.chapter5.model1.start;

import javax.persistence.*;

@Entity
@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint(
        name = "NAME_AGE_UNIQUE",
        columnNames = {"NAME", "AGE"}
)})
public class Member {
    @Id
    @Column(name="ID")
    private String id;          //아이디
    @Column(name="NAME", nullable = false, length = 10)
    private String username;    //이름
    private Integer age;        //나이

    //Getter, Setter

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
