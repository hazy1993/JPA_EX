package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Member  extends BaseEntity{

        @Id @GeneratedValue
        @Column(name="member_id")
        private Long id;

        public Team getTeam() {
                return team;
        }

        public void setTeam(Team team) {
                this.team = team;
        }

        @Column(name = "USERNAME")
        private String username;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name ="team_id")
        private Team team;



        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }


//    @Override << 무한루프에 빠질 수 있음 사용하지 말 것.
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +
//                '}';
//    }
}

