package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.EmptyField;
import com.adach.piasecki.seabattle.model.Field;
import com.adach.piasecki.seabattle.model.FieldWithShip;
import com.adach.piasecki.seabattle.model.Ship;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface AbstractBoardInitializeStrategy extends BoardInitializeStrategy {

    default Map<Character, List<Field>> createFieldMap(final int width, final int height, final List<Ship> shipList,
                                               final AtomicInteger shipFieldsCount) {
        final Map<Character, List<Field>> fieldMap = new HashMap<>();
        Stream.iterate('A', i -> ++i).limit(width).forEach(columnChar -> {
            List<Field> columnFields = Stream
                .generate(EmptyField::new)
                .limit(height)
                .collect(Collectors.toList());
            fieldMap.put(columnChar, columnFields);
        });

        shipList.forEach(ship -> ship.getCoordinates().forEach(coordinates -> {
            fieldMap.get(coordinates.getColumn()).set(coordinates.getRow(), new FieldWithShip(ship));
            shipFieldsCount.getAndIncrement();
        }));

        return fieldMap;
    }
}
