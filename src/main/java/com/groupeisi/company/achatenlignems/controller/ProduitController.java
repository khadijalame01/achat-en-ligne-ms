package com.groupeisi.company.achatenlignems.controller;

import com.groupeisi.company.achatenlignems.dtos.ApiResponse;
import com.groupeisi.company.achatenlignems.dtos.ProduitRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.ProduitResponseDTO;
import com.groupeisi.company.achatenlignems.entities.Produit;
import com.groupeisi.company.achatenlignems.entities.Vente;
import com.groupeisi.company.achatenlignems.services.ProduitService;
import com.groupeisi.company.achatenlignems.services.VenteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produits")

public class ProduitController {
    // INJECTION PAR CONSTRUCTEUR
    ProduitService produitService;

    public ProduitController(ProduitService produitService){
        this.produitService = produitService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> createProduit(@RequestBody @Valid ProduitRequestDTO produit) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.CREATED.value(),
                        "Produit bien créé !",
                        produitService.create(produit)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProduitResponseDTO>>> getAllProduits() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Liste des produits récupérée !",
                        produitService.getAll()
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> getProduitById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Produit récupéré !",
                        produitService.getById(id)
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProduitResponseDTO>> updateProduit(@PathVariable("id") Long id,
                                                                         @RequestBody ProduitRequestDTO produit) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Produit mis à jour !",
                        produitService.update(id, produit)
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduit(@PathVariable("id") Long id) {
        produitService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Produit supprimé !",
                        null
                ));
    }
}
