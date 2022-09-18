package jpabook.chapter5.model1.maintest;

import jpabook.chapter5.model1.model.entity.Team;
import jpabook.chapter5.model1.model.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

/**
 * 5장 연관관계 매핑 관련 예제
 */
public class TestMain {

    public static void main(String[] args) {
        //엔티티 매니저 팩토리 - 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        //엔티티 매니저 - 생성
        EntityManager em = emf.createEntityManager();
        //트랜잭션 - 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();     //트랜잭션 - 시작
            //logic(em);      //비즈니스 로직 실행
            tx.commit();    //트랜잭션 - 커밋
        } catch (Exception e) {
            tx.rollback();  //트랜잭션 - 롤백
        } finally {
            em.close();     //엔티티 매니저 - 종료
        }
        emf.close();        //엔티티 매니저 팩토리 - 종료
    }

    //연관관계 저장(객체그래프 사용)
    public void testSave(EntityManager em) {

        //팀1 저장
        Team team1 = new Team("team1", "팀1");
        em.persist(team1);

        //회원1 저장
        Member member1 = new Member(1L, "회원1");
        member1.setTeam(team1);
        em.persist(member1);

        //회원2 저장
        Member member2 = new Member(2L, "회원2");
        member2.setTeam(team1);
        em.persist(member2);
    }

    //연관관계 조회(JPQL 사용)
    private static void queryLogicJoin(EntityManager em) {
        String jpql = "select m from Member m join m.team t where t.name = :teamName";

        List<Member> resultList = em.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        for (Member member : resultList) {
            System.out.println("[Query] member.username=" + member.getUsername());
        }
        /**
         * 결과: [Query] member.username=회원1
         * 결과: [Query] member.username=회원2
         */

    }

    //연관관계 수정
    private static void updateRelation(EntityManager em) {

        //새로운 팀2
        Team team2 = new Team("team2", "팀2");
        em.persist(team2);

        //회원1에 새로운 팀2 설정
        Member member = em.find(Member.class, "member1");
        member.setTeam(team2);
    }

    //연관관계 삭제
    private static void deleteRelation(EntityManager em) {

        Member member1 = em.find(Member.class, "member1");
        member1.setTeam(null);  //연관관계 제거

        /**
         * 엔티티 삭제하려면 기존 연관관계를 제거해야한다. 아니면 외래키 오류가 발생생
         * member1.setTeam(null); 원1 연관관계 제거
         * member2.setTeam(null); 회원2 연관관계 제거
         * em.remove(team);       팀 삭제
         */
    }

}
