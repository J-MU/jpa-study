package helloJpa.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="Member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="MEMBER_ID")
    private Long id;

    private String userName;

    public Member() {
    }

    public Member(String userName) {
        this.userName = userName;
    }

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    public void setTeam(Team team){
        this.team=team;

//        if(!team.getMembers().contains(this)){
//            team.getMembers().add(this);
//        }
        team.getMembers().add(this);
    }

    public Team getTeam() {
        return team;
    }
}
