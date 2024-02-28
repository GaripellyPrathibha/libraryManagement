package com.cis.batch33.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
@Entity
@Table(name="address")
@Data
public class LibraryAddress {
    @Id
    private int addressId;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private Integer zip;
    @OneToMany(mappedBy = "address")
    private List<LibraryMember> members;
}
