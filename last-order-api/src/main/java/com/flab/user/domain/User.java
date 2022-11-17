package com.flab.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
// Entity 클래스는 매개변수가 없는 생성자의 접근 레벨이 public 또는 protected로 해야 한다.
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 접근 권한이 PRIVATE이므로 Proxy 객체 생성하는 로직에서 오류가 발생
@ToString // 임시
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
