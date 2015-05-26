package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TableGenerator;

/**
 * To create ID generator table "PLAYER_ID_TAB_GEN":
 * CREATE TABLE "PLAYER_ID_TAB_GEN" ("PRIMARY_KEY_NAME" VARCHAR2(4000) PRIMARY KEY, "NEXT_ID_VALUE" NUMBER(38));
 *
 * To initialize this table with data for this entity's ID generator 'Player.id' (starting with value '0'):
 * INSERT INTO "PLAYER_ID_TAB_GEN" VALUES ('Player.id', 0);
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Player.findAll", query = "select o from Player o") })
@TableGenerator(name = "Player_Id_Tab_Gen", table = "PLAYER_ID_TAB_GEN", pkColumnName = "PRIMARY_KEY_NAME",
                pkColumnValue = "Player.id", valueColumnName = "NEXT_ID_VALUE")
public class Player implements Serializable {
    private static final long serialVersionUID = 3536528169568113319L;
    private Integer age;
    @Column(length = 50)
    private String firstname;
    private Integer height;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Player_Id_Tab_Gen")
    private Integer id;
    @Column(length = 50)
    private String lastname;
    @ManyToOne
    @JoinColumn(name = "TEAMID")
    private Team team;

    public Player() {
    }

    public Player(Integer age, String firstname, Integer height, Integer id, String lastname, Team team) {
        this.age = age;
        this.firstname = firstname;
        this.height = height;
        this.id = id;
        this.lastname = lastname;
        this.team = team;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
