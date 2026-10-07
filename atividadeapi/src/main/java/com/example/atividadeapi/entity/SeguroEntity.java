package com.example.atividadeapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tab_seguro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeguroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numeroApolice;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String valorPremio;

    @Column(nullable = false)
    private String dataInicio;

    @Column(nullable = false)
    private String dataFim;

    @Column(nullable = false)
    private String status;

}
