package helloJpa.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name="TEAM_ID")
    private Long id;

    private String name;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "team")
    private List<Member> members=new ArrayList<>();

    public void addMember(Member member){
        this.members.add(member);
//        if(member.getTeam()!=this){
//            member.setTeam(this);
//        }
        member.setTeam(this);
    }

    public List<Member> getMembers() {
        return members;
    }
}
