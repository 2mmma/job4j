package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/** @since 01.2018
 * @author tumen.garmazhapov (gtb-85@yandex.ru)
 */
public class RookWhite implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (source.y - dest.y == 0 || source.x - dest.x == 0) {
            steps = tracer(source, dest);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}
