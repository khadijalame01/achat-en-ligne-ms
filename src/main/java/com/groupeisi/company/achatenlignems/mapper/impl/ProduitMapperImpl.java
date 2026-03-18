package com.groupeisi.company.achatenlignems.mapper.impl;

import com.groupeisi.company.achatenlignems.dtos.ProduitRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.ProduitResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Produit;
import com.groupeisi.company.achatenlignems.mapper.ProduitMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitMapperImpl implements ProduitMapper {
    @Override
    public Produit toEntity(ProduitRequestDTO dto) {
        if(dto == null) return null;
        Produit produit = new Produit();
        produit.setName(dto.getName());
        produit.setStock(dto.getStock());
        return produit;
    }

    @Override
    public ProduitResponseDTO toDto(Produit entity) {
        if(entity == null) return null;
        ProduitResponseDTO dto = new ProduitResponseDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStock(entity.getStock());
        return dto;
    }

    @Override
    public List<ProduitResponseDTO> toDtos(List<Produit> entities) {
        if(entities == null) return null;
        return entities
                .stream()
                .map(this::toDto)
                .toList();
    }
}
