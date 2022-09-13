/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Person;
import entities.RenameMe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PersonDTO {
    private String fName;
    private String lName;
    private String phone;

    private long id;

    public PersonDTO(Person p) {
        this.fName = p.getfName();
        this.lName = p.getlName();
        this.phone = p.getPhone();
        this.id = p.getId();
    }

    public PersonDTO(String fName, String lName, String phone) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
    }

    public PersonDTO() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDTO)) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return getId() == personDTO.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
}
