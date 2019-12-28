package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Field;
import com.adach.piasecki.seabattle.model.HorizontalShip;
import com.adach.piasecki.seabattle.model.Ship;

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
                .generate(Field::empty)
                .limit(10)
                .collect(Collectors.toList());
            fieldsMap.put(columnChar, columnFields);
        });

        Ship ship = new HorizontalShip(5, 'C', 'E');
        for (var shipCoordinates : ship.getCoordinates()) {
            fieldsMap.get(shipCoordinates.getColumn()).set(shipCoordinates.getRow(), Field.withShip(ship));
        }

        return new Board(10, 10, fieldsMap);
    }
}
