package com.easyexam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = true) // false
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Teacher teacher;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Admin admin;

    public User() { }

    public User(String email, String password, Boolean active, Role role) {
        this.email = email;
        this.password = password;
        this.active = active;
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setTeacher(Teacher teacher) {
        teacher.setUser(this);
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setAdmin(Admin admin) {
        admin.setUser(this);
        this.admin = admin;
    }

    public Admin getAdmin() {
        return this.admin;
    }
}
