package com.adach.piasecki.seabattle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FieldShotStatus {

    private final boolean scored;

    private final List<Coordinates> sunkCoordinates;
}
