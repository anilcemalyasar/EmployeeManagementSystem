package com.tutorial.employeemanagement.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column
    private String name;

    private String type;

    @Column(name = "image")
    @Lob
    private byte[] file;

    public Image(String name, String type, byte[] file) {
        this.name = name;
        this.type = type;
        this.file = file;
    }
}
