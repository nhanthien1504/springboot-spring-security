package com.mock.flight.entities;

import com.mock.flight.common.ERole;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private ERole name;

    public Role() {
    }

    public Role(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }
}
