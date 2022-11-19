package jpabook.chapter5.model1.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Member {

    public Member(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    private String city;
    private String street;
    private String zipcode;

    public void setTeam(Team team) {

        //기존 팀과의 관계를 제거 - 일종의 안전장치
        if (this.team != null) {
            this.team.getMembers().remove(this);
        }
        this.team = team;
        team.getMembers().add(this); // 양방향 관계를 설정해준다.
    }
}
