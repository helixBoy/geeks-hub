package com.geeksHub.dev.entities;

import javax.persistence.*;

@Entity
//@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public String roles;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "users_roles",  joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
//    public Collection<Role> roles;
}
