package com.axsos.javaexam.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Table(name="celebrities")
public class Celebrity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="Name is required!")
    @Size(min = 3, message="Name must be at least 3 characters.")
    private String name;
    @Size(min = 10,  message="Description must be at least 10 characters.")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="pageManager_id")
    private User pageManager;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "users_celebrities",
                joinColumns = @JoinColumn(name = "celebrity_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        private List<User> users;
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Celebrity() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPageManager() {
        return pageManager;
    }

    public void setPageManager(User pageManager) {
        this.pageManager = pageManager;
    }



    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
