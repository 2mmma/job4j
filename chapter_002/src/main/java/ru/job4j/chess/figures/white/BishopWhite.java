package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x)) {
            steps = tracer(source, dest);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
