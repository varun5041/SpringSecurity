package com.security.learn.securityProject.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    private String name;
    @Id
    private String Roleid;

    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();
}
