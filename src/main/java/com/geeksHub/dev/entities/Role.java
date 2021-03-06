package com.geeksHub.dev.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;

    public Role(){ }
    public Role(String name) {
        this.name = name;
    }


}
