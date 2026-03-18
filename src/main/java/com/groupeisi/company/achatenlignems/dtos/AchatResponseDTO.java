package com.groupeisi.company.achatenlignems.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchatResponseDTO {
    private long id;
    private Date dateP;
    private Double quantity;
    private ProduitResponseDTO produit;
}
