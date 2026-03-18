package com.groupeisi.company.achatenlignems.controller;

import com.groupeisi.company.achatenlignems.dtos.VenteRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.VenteResponseDTO;
import com.groupeisi.company.achatenlignems.services.VenteService;
import com.groupeisi.company.achatenlignems.dtos.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventes")
public class VenteController {

    private final VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VenteResponseDTO>> createVente(@RequestBody @Valid VenteRequestDTO vente) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.CREATED.value(),
                        "Vente bien créée !",
                        venteService.create(vente)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VenteResponseDTO>>> getAllVentes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Liste des ventes récupérée !",
                        venteService.getAll()
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VenteResponseDTO>> getVenteById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Vente récupérée !",
                        venteService.getById(id)
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<VenteResponseDTO>> updateVente(@PathVariable("id") Long id,
                                                                     @RequestBody @Valid VenteRequestDTO vente) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Vente mise à jour !",
                        venteService.update(id, vente)
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteVente(@PathVariable("id") Long id) {
        venteService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Vente supprimée !",
                        null
                ));
    }
}