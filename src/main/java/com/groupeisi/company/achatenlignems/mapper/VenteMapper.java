package com.groupeisi.company.achatenlignems.mapper;

import com.groupeisi.company.achatenlignems.dtos.ProduitRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.ProduitResponseDTO;
import com.groupeisi.company.achatenlignems.dtos.VenteRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.VenteResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Produit;
import com.groupeisi.company.achatenlignems.entities.Vente;

import java.util.List;

public interface VenteMapper {
    Vente toEntity(VenteRequestDTO dto);
    VenteResponseDTO toDto(Vente entity);
    List<VenteResponseDTO> toDtos(List<Vente> entities);
}
