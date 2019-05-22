package com.biotrio.backend.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(
        name = "ScreeningMovie",
        types = { Screening.class })
public interface ScreeningMovie {

    String getName();

    List<Screening> getMovie();

}