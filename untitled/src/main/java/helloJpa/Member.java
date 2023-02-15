package helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="Member")
//@Table(name="Member", uniqueConstraints = {
//        @UniqueConstraint(
//                name="NAME_AGE_UNIQUE",
//                columnNames={"NAME","PHONE"}
//        )})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    //이걸 왜 Wrapper자료형으로 잡을까?

//    @Column(name="name",unique = true,length = 10,nullable = false) //실행에는 영향을 주지 않는다. 단지 DDL생성에만 관여할 뿐이다.
    private String name;
//    @Column(name="phone",unique = true,length = 10,nullable = false) //실행에는 영향을 주지 않는다. 단지 DDL생성에만 관여할 뿐이다.
//    private String phone;


    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
