package jpabook.chapter7.model9;

import javax.persistence.*;

@Entity
public class BoardDetail {

    @Id
    private Long boardId;

    @MapsId //BoardDetail.baordId 매핑
    @OneToOne
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    private String content;
}
