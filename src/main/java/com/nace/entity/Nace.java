package com.nace.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Nace")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nace {

    @Id
    @Column
    private long orderNo;

    @Column
    private int level;

    @Column
    private  String code;

    @Column
    private String parent;

    @Column(length = 10000)
    private String description;

    @Column(length = 10000)
    private String thisItemIncludes;

    @Column(length = 10000)
    private String thisItemAlsoIncludes;

    @Column
    private String rulings;

    @Column(length = 10000)
    private String thisItemExcludes;

    @Column
    private String ref;



}
