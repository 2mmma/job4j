package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNotFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * //TODO add comments.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;


    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException,
            OccupiedWayException, FigureNotFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            BiPredicate<Cell, Cell> biPredicate = (source1, dest1) -> steps.length > 0
                    && steps[steps.length - 1].equals(dest);
            if (biPredicate.test(source, dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            }
        }
        return rst;
    }

    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        Predicate<Cell> predicate = position -> this.figures[index] != null
                && this.figures[index].position().equals(cell);
        for (int index = 0; index != this.figures.length; index++) {
            if (predicate.test(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
