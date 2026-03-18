package com.groupeisi.company.achatenlignems.controller;

import com.groupeisi.company.achatenlignems.dtos.AchatRequestDTO;
import com.groupeisi.company.achatenlignems.dtos.AchatResponseDTO;
import com.groupeisi.company.achatenlignems.services.AchatService;
import com.groupeisi.company.achatenlignems.dtos.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/achats")
public class AchatController {

    private final AchatService achatService;

    public AchatController(AchatService achatService) {
        this.achatService = achatService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AchatResponseDTO>> createAchat(@RequestBody @Valid AchatRequestDTO achat) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.CREATED.value(),
                        "Achat bien créé !",
                        achatService.create(achat)
                ));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<AchatResponseDTO>>> getAllAchats() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Liste des achats récupérée !",
                        achatService.getAll()
                ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AchatResponseDTO>> getAchatById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Achat récupéré !",
                        achatService.getById(id)
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<AchatResponseDTO>> updateAchat(@PathVariable("id") Long id,
                                                                     @RequestBody @Valid AchatRequestDTO achat) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Achat mis à jour !",
                        achatService.update(id, achat)
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteAchat(@PathVariable("id") Long id) {
        achatService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        true,
                        HttpStatus.OK.value(),
                        "Achat supprimé !",
                        null
                ));
    }
}