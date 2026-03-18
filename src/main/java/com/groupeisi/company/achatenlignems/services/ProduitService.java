package com.groupeisi.company.achatenlignems.services;

import com.groupeisi.company.achatenlignems.dtos.ProduitRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.ProduitResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Produit;

import java.util.List;

public interface ProduitService {
    ProduitResponseDTO create(ProduitRequestDTO produit);
    List<ProduitResponseDTO> getAll();
    ProduitResponseDTO getById(Long id);
    ProduitResponseDTO update(Long id, ProduitRequestDTO produit);
    void delete(Long id);
}
