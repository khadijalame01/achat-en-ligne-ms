package com.groupeisi.company.achatenlignems.mapper.impl;

import com.groupeisi.company.achatenlignems.dtos.AchatRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.AchatResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Achat;
import com.groupeisi.company.achatenlignems.entities.Produit;
import com.groupeisi.company.achatenlignems.mapper.AchatMapper;
import com.groupeisi.company.achatenlignems.mapper.ProduitMapper;
import com.groupeisi.company.achatenlignems.services.AchatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchatMapperImpl implements AchatMapper {


    private final ProduitMapper produitMapper;

    @Override
    public Achat toEntity(AchatRequestDTO dto) {
        if(dto == null) return null;
        Achat achat = new Achat();
        achat.setDateP(dto.getDateP());
        achat.setQuantity(dto.getQuantity());
        return achat;
    }

    @Override
    public AchatResponseDTO toDto(Achat entity) {
        if (entity == null) return null;

        AchatResponseDTO dto = new AchatResponseDTO();
        dto.setId(entity.getId());
        dto.setDateP(entity.getDateP());
        dto.setQuantity(entity.getQuantity());

        // Mapper le produit lié
        if (entity.getProduit() != null) {
            dto.setProduit(produitMapper.toDto(entity.getProduit()));
        }

        return dto;
    }

    @Override
    public List<AchatResponseDTO> toDtos(List<Achat> entities) {
        if(entities == null) return null;
        return entities
                .stream()
                .map(this::toDto)
                .toList();
    }
}
