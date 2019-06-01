package com.biotrio.backend.model;

import javax.persistence.*;

/**
 * Represents the role table in the database
 *
 * This class contains methods related to setting and getting different parameters of a role.
 * Spring automatically generates the role table in the localhost using this model
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}