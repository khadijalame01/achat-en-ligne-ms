package com.groupeisi.company.achatenlignems.services;

import com.groupeisi.company.achatenlignems.dtos.AchatRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.AchatResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Achat;
import com.groupeisi.company.achatenlignems.entities.Produit;

import java.util.List;

public interface AchatService {
    AchatResponseDTO create(AchatRequestDTO achat);
    List<AchatResponseDTO> getAll();
    AchatResponseDTO getById(Long id);
    AchatResponseDTO update(Long id, AchatRequestDTO achat);
    void delete(Long id);
}
