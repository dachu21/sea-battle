package com.adach.piasecki.seabattle.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
class FieldShotStatus {

    private final boolean scored;
    private final List<Coordinates> sunkCoordinates;
}
