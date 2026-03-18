package com.groupeisi.company.achatenlignems.mapper.impl;

import com.groupeisi.company.achatenlignems.dtos.VenteRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.VenteResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Achat;
import com.groupeisi.company.achatenlignems.entities.Vente;
import com.groupeisi.company.achatenlignems.mapper.ProduitMapper;
import com.groupeisi.company.achatenlignems.mapper.VenteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenteMapperImpl implements VenteMapper {

    private final ProduitMapper produitMapper;
    @Override
    public Vente toEntity(VenteRequestDTO dto) {
        if(dto == null) return null;
        Vente vente = new Vente();
        vente.setDateP(dto.getDateP());
        vente.setQuantity(dto.getQuantity());
        return vente;
    }

    @Override
    public VenteResponseDTO toDto(Vente entity) {
        if (entity == null) return null;

        VenteResponseDTO dto = new VenteResponseDTO();
        dto.setId(entity.getId());
        dto.setDateP(entity.getDateP());
        dto.setQuantity(entity.getQuantity());

        if (entity.getProduit() != null) {
            dto.setProduit(produitMapper.toDto(entity.getProduit()));
        }

        return dto;
    }
    @Override
    public List<VenteResponseDTO> toDtos(List<Vente> entities) {
        if(entities == null) return null;
        return entities
                .stream()
                .map(this::toDto)
                .toList();
    }
}
