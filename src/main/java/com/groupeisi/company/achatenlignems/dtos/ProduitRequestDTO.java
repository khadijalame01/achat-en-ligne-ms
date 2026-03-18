package com.groupeisi.company.achatenlignems.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProduitRequestDTO {
    private long id;
    private String ref;
    private String name;
    private Double stock;
}
