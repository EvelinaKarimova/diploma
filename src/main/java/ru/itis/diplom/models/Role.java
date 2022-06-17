package ru.itis.diplom.models;

import javax.persistence.Table;


@Table(name = "user_role")
public enum Role{
    USER, ADMIN;
}
