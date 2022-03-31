package com.springpractice.springwebdev.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder // 오브젝트 생성을 위한 디자인 패턴중 하나입니다. Builder 클래스를 따로 개발하지 않고도 Builder 패턴을 사용해 오브젝트를 생성 가능합니다.
@NoArgsConstructor //매개변수가 없는 생성자를 구현해 줍니다.
@AllArgsConstructor // 클래스의 모든 멤버변수를 매개변수로 받는 생성자를 구현해줍니다.
@Data // 클래스 멤버변수의 getter, setter를 구현해줍니다.
@Entity
@Table(name = "Todo") // 테이블 이름 지정.
public class TodoEntity {

    @Id // id가 기본 key
    @GeneratedValue(generator = "system-uuid") //id를 자동생성한다는 뜻입니다.
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id; // 오브젝트 id

    private String userId; // 오브젝트 생성한 사용자 id
    private String title; // Todo 타이틀
    private Boolean done; // true 경우, todo 완료

    public Boolean isDone() {
        return true;
    }
}
