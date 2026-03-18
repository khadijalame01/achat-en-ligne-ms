package com.groupeisi.company.achatenlignems.services;

import com.groupeisi.company.achatenlignems.dtos.VenteRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.VenteResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Achat;
import com.groupeisi.company.achatenlignems.entities.Vente;

import java.util.List;

public interface VenteService {
    VenteResponseDTO create(VenteRequestDTO vente);
    List<VenteResponseDTO> getAll();
    VenteResponseDTO getById(Long id);
    VenteResponseDTO update(Long id, VenteRequestDTO vente);
    void delete(Long id);
}
