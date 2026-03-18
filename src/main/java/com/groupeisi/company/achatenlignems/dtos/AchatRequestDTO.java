package com.groupeisi.company.achatenlignems.dtos;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AchatRequestDTO {
    private long id;
    private Date dateP;
    private Double quantity;
    private Long produitId;

}
