/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.entities;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author mehdi
 */
public class user {
    public String username,email,password,roles,first_name,last_name,address;
    private int id,phone;
    private Date birth_date;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public user(String username, String email, String password, String roles, String first_name, String last_name, Date birth_date, String address, int phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.address = address;
        this.phone = phone;
    }

    public user() {
        
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.username);
        hash = 31 * hash + Objects.hashCode(this.email);
        hash = 31 * hash + Objects.hashCode(this.password);
        hash = 31 * hash + Objects.hashCode(this.roles);
        hash = 31 * hash + Objects.hashCode(this.first_name);
        hash = 31 * hash + Objects.hashCode(this.last_name);
        hash = 31 * hash + Objects.hashCode(this.birth_date);
        hash = 31 * hash + Objects.hashCode(this.address);
        hash = 31 * hash + Objects.hashCode(this.phone);
        return hash;
    }

    @Override
    public String toString() {
        return "user{" + "username=" + username + ", email=" + email + ", password=" + password + ", roles=" + roles + ", first_name=" + first_name + ", last_name=" + last_name + ", birth_date=" + birth_date + ", address=" + address + ", phone=" + phone + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final user other = (user) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.roles, other.roles)) {
            return false;
        }
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.birth_date, other.birth_date)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRoles() {
        return roles;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public user(String username, String email, String password, String roles, String first_name, String last_name, String address, int id, int phone, Date birth_date) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.id = id;
        this.phone = phone;
        this.birth_date = birth_date;
    }
    
}
