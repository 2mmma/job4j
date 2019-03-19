package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.Random;
import java.util.function.BiPredicate;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        BiPredicate<Cell, Cell> biPredicate = (source1, dest1) -> Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x);
        if (biPredicate.test(source, dest)) {
            steps = tracer(source, dest);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
