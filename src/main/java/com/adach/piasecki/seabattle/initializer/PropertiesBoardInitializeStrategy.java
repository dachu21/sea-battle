package com.adach.piasecki.seabattle.initializer;

import com.adach.piasecki.seabattle.model.Board;
import com.adach.piasecki.seabattle.model.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.adach.piasecki.seabattle.model.Field.FieldState.UNKNOWN;

public class PropertiesBoardInitializeStrategy implements BoardInitializeStrategy {

    public Board initBoard() {
        final Map<Character, List<Field>> fieldsMap = new HashMap<>();
        Stream.iterate('a', i -> ++i).limit(20).forEach(columnChar -> {
            List<Field> columnFields = Stream
                .generate(() -> new Field(true, UNKNOWN))
                .limit(20)
                .collect(Collectors.toList());
            fieldsMap.put(columnChar, columnFields);
        });
        return new Board(fieldsMap);
    }
}
