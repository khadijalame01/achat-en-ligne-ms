package com.groupeisi.company.achatenlignems.services.impl;

import com.groupeisi.company.achatenlignems.dtos.ProduitRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.ProduitResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Produit;
import com.groupeisi.company.achatenlignems.mapper.ProduitMapper;
import com.groupeisi.company.achatenlignems.repositories.ProduitRepository;
import com.groupeisi.company.achatenlignems.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;
    private final ProduitMapper produitMapper;

    @Override
    public ProduitResponseDTO create(ProduitRequestDTO produit) {
        Produit entity = produitMapper.toEntity(produit);
        return produitMapper.toDto(produitRepository.save(entity));
    }

    @Override
    public List<ProduitResponseDTO> getAll() {
        return produitMapper.toDtos(produitRepository.findAll());
    }

    @Override
    public ProduitResponseDTO getById(Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + id));
        return produitMapper.toDto(produit);
    }

    @Override
    public ProduitResponseDTO update(Long id, ProduitRequestDTO produit) {
        Produit existProduit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + id));

        existProduit.setRef(produit.getRef());
        existProduit.setName(produit.getName());
        existProduit.setStock(produit.getStock());

        return produitMapper.toDto(produitRepository.save(existProduit));
    }

    @Override
    public void delete(Long id) {
        produitRepository.deleteById(id);
    }
}