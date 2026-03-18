package com.groupeisi.company.achatenlignems.mapper;

import com.groupeisi.company.achatenlignems.dtos.AchatRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.AchatResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Achat;

import java.util.List;

public interface AchatMapper {
    Achat toEntity(AchatRequestDTO dto);
    AchatResponseDTO toDto(Achat entity);
    List<AchatResponseDTO> toDtos(List<Achat> entities);
}
