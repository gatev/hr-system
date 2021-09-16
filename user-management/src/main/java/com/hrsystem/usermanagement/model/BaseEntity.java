package com.hrsystem.usermanagement.model;

import javax.persistence.*;

import lombok.Data;

import java.io.Serializable;

@MappedSuperclass
@Data
public class BaseEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;
}
