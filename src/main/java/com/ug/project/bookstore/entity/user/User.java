package com.ug.project.bookstore.entity.user;

import com.ug.project.bookstore.entity.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User extends BaseEntity {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;
}
