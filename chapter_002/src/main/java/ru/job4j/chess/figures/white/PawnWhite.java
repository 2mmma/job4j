package ru.job4j.chess.figures.white;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class PawnWhite implements Figure {
    private final Cell position;

    public PawnWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if (dest.y - source.y <= (source.y == 1 ? 2 : 1)
                && dest.y - source.y >= 0
                && source.x == dest.x) {
            steps = tracer(source, dest);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new PawnWhite(dest);
    }
}
