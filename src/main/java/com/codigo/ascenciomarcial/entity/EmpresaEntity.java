package com.codigo.ascenciomarcial.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "empresa")
public class EmpresaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "razon_social")
    private String razonSocial;
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Column(name = "condicion")
    private String condicion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "distrito")
    private String distrito;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "departamento")
    private String departamento;
    @Column(name = "es_agente_retencion")
    private Boolean EsAgenteRetencion;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "usua_crea")
    private String usuaCrea;
    @Column(name = "date_create")
    private Timestamp dateCreate;
    @Column(name = "usua_modif")
    private String usuaModif;
    @Column(name = "date_modif")
    private Timestamp dateModif;
    @Column(name = "usua_delet")
    private String usuaDelet;
    @Column(name = "date_delet")
    private Timestamp dateDelet;
}
