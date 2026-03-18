package com.groupeisi.company.achatenlignems.repositories;

import com.groupeisi.company.achatenlignems.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
