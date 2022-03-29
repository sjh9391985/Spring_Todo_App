package com.springpractice.springwebdev.persistence;
import com.springpractice.springwebdev.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                                           // 첫번째 매개변수: 테이블에 매핑될 엔티티클래스입니다.
                                                      // 두번째 매개변수: 엔티티의 기본 키의 타입입니다.
public interface TodoRepository extends JpaRepository<TodoEntity,String> {

    @Query("select * from Todo t where t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);
}
