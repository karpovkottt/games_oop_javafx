package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void whenPositionEqual() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        Cell ps = bishopBlack.position();
        Cell expected = Cell.C8;
        assertThat(ps).isEqualTo(expected);
    }

    @Test
    void whenCopyEqual() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A8);
        Figure movedBB = bishopBlack.copy(Cell.A6);
        Cell ps = movedBB.position();
        Cell expected = Cell.A6;
        assertThat(ps).isEqualTo(expected);
    }

    @Test
    void whenWayIsTrue() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] steps = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(steps).containsExactly(expected);
    }

    @Test
    void whenWayIsFalse() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    bishopBlack.way(Cell.C2);
                }
        );
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to C2");
    }
}