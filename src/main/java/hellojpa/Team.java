package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {


    @Id @Column(name="team_id")
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "team_id")
    //????? mappedBy같은데??
    private List<Member> members = new ArrayList<>();
    //ArrayList로 초기화 해주면 add할떄  null이 안뜸


    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}