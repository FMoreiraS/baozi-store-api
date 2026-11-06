package com.fmoreiras.baozistore.controller.request;

import java.math.BigDecimal;
import java.util.Optional;

public record ProductUpdateRequest(
        Optional<String> name,
        Optional<BigDecimal> price) {
}
