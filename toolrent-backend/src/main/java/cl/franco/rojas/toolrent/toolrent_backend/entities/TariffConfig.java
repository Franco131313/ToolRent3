package cl.franco.rojas.toolrent.toolrent_backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tariff_config")
public class TariffConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal dailyRentalRate;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal dailyLateFee;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal repairBaseFee;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
