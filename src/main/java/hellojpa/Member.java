package hellojpa;

import javax.persistence.*;
import java.util.*;

@Entity
public class Member {

        @Id @GeneratedValue
        @Column(name="member_id")
        private Long id;

        @Embedded
        private Address homeAddress;

        @ElementCollection
        @CollectionTable(name= "FAVORITE_FOOD",joinColumns =
        @JoinColumn(name="member_id"))
        @Column(name="food_name")
        private Set<String> favoriteFoods = new HashSet<>();

        @ElementCollection
        @CollectionTable(name="ADDRESS" ,joinColumns =
        @JoinColumn(name = "member_id"))
        private List<Address> addressHistory = new ArrayList<>();

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

        //period
//        @Embedded
//        private Period period;



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

        public Address getHomeAddress() {
                return homeAddress;
        }

        public void setHomeAddress(Address homeAddress) {
                this.homeAddress = homeAddress;
        }

        public Set<String> getFavoriteFoods() {
                return favoriteFoods;
        }

        public void setFavoriteFoods(Set<String> favoriteFoods) {
                this.favoriteFoods = favoriteFoods;
        }

        public List<Address> getAddressHistory() {
                return addressHistory;
        }

        public void setAddressHistory(List<Address> addressHistory) {
                this.addressHistory = addressHistory;
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

