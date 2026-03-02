package cl.franco.rojas.toolrent.toolrent_backend.entities;

import cl.franco.rojas.toolrent.toolrent_backend.enums.KardexMovementType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "kardex")
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Tool tool;

    @ManyToOne(optional = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KardexMovementType movementType;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, updatable = false)
    private LocalDateTime movementDate;

    @PrePersist
    protected void onCreate() {
        this.movementDate = LocalDateTime.now();
    }

}
