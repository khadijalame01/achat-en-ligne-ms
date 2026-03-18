package com.groupeisi.company.achatenlignems.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.Instant;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt = Instant.now();

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();

    @Column(name = "user_created")
    private String userCreated;

    @Column(name = "user_updated")
    private String userUpdated;

}
