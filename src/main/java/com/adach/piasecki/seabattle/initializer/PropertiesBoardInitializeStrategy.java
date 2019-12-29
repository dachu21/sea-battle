package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesBoardInitializeStrategy implements BoardInitializeStrategy {

    public Board initializeBoard() {
        final Map<Character, List<Field>> fieldsMap = new HashMap<>();
        Stream.iterate('A', i -> ++i).limit(10).forEach(columnChar -> {
            List<Field> columnFields = Stream
                    .generate(EmptyField::new)
                    .limit(10)
                    .collect(Collectors.toList());
            fieldsMap.put(columnChar, columnFields);
        });

        Ship ship = new HorizontalShip(5, 'C', 'E');
        for (var shipCoordinates : ship.getCoordinates()) {
            fieldsMap.get(shipCoordinates.getColumn()).set(shipCoordinates.getRow(), new FieldWithShip(ship));
        }

        return new Board(10, 10, fieldsMap, ship.getSize());
    }
}
