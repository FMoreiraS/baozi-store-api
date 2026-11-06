package com.fmoreiras.baozistore.controller.request;

import java.time.LocalDate;
import java.util.Optional;

public record CustomerUpdateRequest(
        Optional<String> name,
        Optional<LocalDate> customerSince
) {
}
