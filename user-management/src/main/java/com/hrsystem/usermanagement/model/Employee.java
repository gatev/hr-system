package com.hrsystem.usermanagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employees", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "email"
        })
})

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends BaseEntity {
    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 300)
    private String imageUrl;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(min = 8, max = 100)
    private String password;

    @NotNull
    private int daysOff;

    @NotNull
    @Size(max = 25)
    private String position;

    @NotNull
    @Size(max = 14)
    private String phone;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "r_employees_roles",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public Employee(@NotBlank @Size(max = 40) String name, @NotBlank @Size(max = 300) String imageUrl, @NotBlank @Size(max = 40) @Email String email, @NotBlank @Size(min = 8, max = 100) String password, @NotNull @Size(min = 1, max = 2) int daysOff, @NotNull @Size(max = 25) String position, @NotNull @Size(max = 14) String phone) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.email = email;
        this.password = password;
        this.daysOff = daysOff;
        this.position = position;
        this.phone = phone;
    }

}