package com.groupeisi.company.achatenlignems.mapper;

import com.groupeisi.company.achatenlignems.dtos.AchatRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.AchatResponseDTO;
import com.groupeisi.company.achatenlignems.dtos.ProduitRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.ProduitResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Achat;
import com.groupeisi.company.achatenlignems.entities.Produit;

import java.util.List;

public interface ProduitMapper {
    Produit toEntity(ProduitRequestDTO dto);
    ProduitResponseDTO toDto(Produit entity);
    List<ProduitResponseDTO> toDtos(List<Produit> entities);
}
