package com.groupeisi.company.achatenlignems.services.impl;

import com.groupeisi.company.achatenlignems.dtos.VenteRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.VenteResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Produit;
import com.groupeisi.company.achatenlignems.entities.Vente;
import com.groupeisi.company.achatenlignems.mapper.VenteMapper;
import com.groupeisi.company.achatenlignems.repositories.ProduitRepository;
import com.groupeisi.company.achatenlignems.repositories.VenteRepository;
import com.groupeisi.company.achatenlignems.services.VenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenteServiceImpl implements VenteService {

    private final VenteRepository venteRepository;
    private final VenteMapper venteMapper;
    private final ProduitRepository produitRepository;

    @Override
    public VenteResponseDTO create(VenteRequestDTO vente) {
        Vente entity = venteMapper.toEntity(vente);

        // Associer le produit via son ID
        Produit produit = produitRepository.findById(vente.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + vente.getProduitId()));
        entity.setProduit(produit);

        return venteMapper.toDto(venteRepository.save(entity));
    }

    @Override
    public List<VenteResponseDTO> getAll() {
        return venteMapper.toDtos(venteRepository.findAll());
    }

    @Override
    public VenteResponseDTO getById(Long id) {
        Vente vente = venteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vente non trouvée avec l'id : " + id));
        return venteMapper.toDto(vente);
    }

    @Override
    public VenteResponseDTO update(Long id, VenteRequestDTO vente) {
        Vente existVente = venteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vente non trouvée avec l'id : " + id));

        existVente.setDateP(vente.getDateP());
        existVente.setQuantity(vente.getQuantity());

        // Mettre à jour le produit via son ID
        Produit produit = produitRepository.findById(vente.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + vente.getProduitId()));
        existVente.setProduit(produit);

        return venteMapper.toDto(venteRepository.save(existVente));
    }

    @Override
    public void delete(Long id) {
        venteRepository.deleteById(id);
    }
}