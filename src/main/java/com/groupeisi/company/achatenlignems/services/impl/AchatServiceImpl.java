package com.groupeisi.company.achatenlignems.services.impl;

import com.groupeisi.company.achatenlignems.dtos.AchatRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.AchatResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Achat;
import com.groupeisi.company.achatenlignems.entities.Produit;
import com.groupeisi.company.achatenlignems.mapper.AchatMapper;
import com.groupeisi.company.achatenlignems.repositories.AchatRepository;
import com.groupeisi.company.achatenlignems.repositories.ProduitRepository;
import com.groupeisi.company.achatenlignems.services.AchatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchatServiceImpl implements AchatService {

    private final AchatRepository achatRepository;
    private final AchatMapper achatMapper;
    private final ProduitRepository produitRepository;

    @Override
    public AchatResponseDTO create(AchatRequestDTO achat) {
        Achat entity = achatMapper.toEntity(achat);

        // Associer le produit via son ID
        Produit produit = produitRepository.findById(achat.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + achat.getProduitId()));
        entity.setProduit(produit);

        return achatMapper.toDto(achatRepository.save(entity));
    }

    @Override
    public List<AchatResponseDTO> getAll() {
        return achatMapper.toDtos(achatRepository.findAll());
    }

    @Override
    public AchatResponseDTO getById(Long id) {
        Achat achat = achatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Achat non trouvé avec l'id : " + id));
        return achatMapper.toDto(achat);
    }

    @Override
    public AchatResponseDTO update(Long id, AchatRequestDTO achat) {
        Achat existAchat = achatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Achat non trouvé avec l'id : " + id));

        existAchat.setDateP(achat.getDateP());
        existAchat.setQuantity(achat.getQuantity());

        // Mettre à jour le produit via son ID
        Produit produit = produitRepository.findById(achat.getProduitId())
                .orElseThrow(() -> new RuntimeException("Produit non trouvé avec l'id : " + achat.getProduitId()));
        existAchat.setProduit(produit);

        return achatMapper.toDto(achatRepository.save(existAchat));
    }

    @Override
    public void delete(Long id) {
        achatRepository.deleteById(id);
    }
}