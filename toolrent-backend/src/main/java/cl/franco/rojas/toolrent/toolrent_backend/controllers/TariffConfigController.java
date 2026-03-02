package cl.franco.rojas.toolrent.toolrent_backend.controllers;

import cl.franco.rojas.toolrent.toolrent_backend.entities.TariffConfig;
import cl.franco.rojas.toolrent.toolrent_backend.services.TariffConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tariffs")
@RequiredArgsConstructor
public class TariffConfigController {

    private final TariffConfigService tariffConfigService;

    @GetMapping
    public TariffConfig getCurrentTariff() {
        return tariffConfigService.getCurrentConfig();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TariffConfig createOrUpdate(@RequestBody TariffConfig config) {
        return tariffConfigService.createOrUpdate(config);
    }
}