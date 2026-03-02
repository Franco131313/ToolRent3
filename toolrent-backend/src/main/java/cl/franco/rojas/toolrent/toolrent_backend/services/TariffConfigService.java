package cl.franco.rojas.toolrent.toolrent_backend.services;

import cl.franco.rojas.toolrent.toolrent_backend.entities.TariffConfig;
import cl.franco.rojas.toolrent.toolrent_backend.repositories.TariffConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TariffConfigService {

    private final TariffConfigRepository tariffConfigRepository;

    public TariffConfig getCurrentConfig() {
        return tariffConfigRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tariff configuration not found"));
    }

    public TariffConfig createOrUpdate(TariffConfig config) {
        List<TariffConfig> existingConfigs = tariffConfigRepository.findAll();

        if (!existingConfigs.isEmpty()) {
            TariffConfig existing = existingConfigs.get(0);
            existing.setDailyRentalRate(config.getDailyRentalRate());
            existing.setDailyLateFee(config.getDailyLateFee());
            existing.setRepairBaseFee(config.getRepairBaseFee());
            return tariffConfigRepository.save(existing);
        }

        return tariffConfigRepository.save(config);
    }
}