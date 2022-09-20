package com.quiniela.app.commons.models.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "equipos")
public class Equipo implements Serializable {


    private Long id;
    private String nombre;
    private String filename;
    private String contentType;
    private String imageSize;
    @Lob
    private byte[] imageData;

    public Equipo() {
    }

    public Equipo(String nombre, String filename, String contentType, String imageSize, byte[] imageData) {
        this.nombre = nombre;
        this.filename = filename;
        this.contentType = contentType;
        this.imageSize = imageSize;
        this.imageData = imageData;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "equipo", unique = true, nullable = false)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "filename", nullable = false)
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Column(name = "content_type", nullable = false)
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Column(name = "image_size", nullable = false)
    public String getImageSize() {
        return imageSize;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    @Column(name = "image_data", nullable = false)
    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
