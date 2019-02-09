package ru.job4j.chess.figures;

public interface Figure {
    Cell position();

    Cell[] way(Cell source, Cell dest);

    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }

    default Cell[] tracer(Cell source, Cell dest) {
        int deltaX = Math.abs(source.x - dest.x);
        int deltaY = Math.abs(source.y - dest.y);
        int moveX = Integer.compare(dest.x, source.x);
        int moveY = Integer.compare(dest.y, source.y);
        int x = source.x;
        int y = source.y;
        int size = (deltaX > deltaY) ? deltaX : deltaY;
        Cell[] steps = new Cell[size];
        int index = 0;
        while (dest.y != y || dest.x != x) {
            x += moveX;
            y += moveY;
            steps[index++] =  Cell.findCell(x, y)[0];
        }
        return steps;
    }

    Figure copy(Cell dest);

}
