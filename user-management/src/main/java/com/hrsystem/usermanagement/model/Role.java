package com.hrsystem.usermanagement.model;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleName name;
}
