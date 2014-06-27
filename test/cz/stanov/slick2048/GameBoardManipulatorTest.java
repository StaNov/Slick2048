package cz.stanov.slick2048;

import cz.stanov.slick2048.gameobject.Board;
import cz.stanov.slick2048.util.GameBoardCreator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GameBoardManipulatorTest {
    
    private GameBoardCreator boardCreator = new GameBoardCreator();


    @Test
    public void testMoveRight_moveNothing() throws Exception {
        Board board = boardCreator.create(
                "0,0,0,0," +
                "0,0,0,2," +
                "0,0,0,2," +
                "0,0,0,0");

        new GameBoardManipulator(board).moveRight();

        assertEquals(boardCreator.create(
                "0,0,0,0," +
                "0,0,0,2," +
                "0,0,0,2," +
                "0,0,0,0"),
                board);
    }

    @Test
    public void testMoveRight_onlyMove() throws Exception {
        Board board = boardCreator.create(
                "0,0,0,2," +
                "0,0,2,0," +
                "0,2,0,0," +
                "2,0,0,0");

        new GameBoardManipulator(board).moveRight();

        assertEquals(boardCreator.create(
                "0,0,0,2," +
                "0,0,0,2," +
                "0,0,0,2," +
                "0,0,0,2"),
                board);
    }

    @Test
    public void testMoveRight_dontMoveAndDontMerge() throws Exception {
        Board board = boardCreator.create(
                "0,0,2,4," +
                "0,4,8,2," +
                "0,0,0,0," +
                "0,0,0,0");

        new GameBoardManipulator(board).moveRight();

        assertEquals(boardCreator.create(
                "0,0,2,4," +
                "0,4,8,2," +
                "0,0,0,0," +
                "0,0,0,0"),
                board);
    }

    @Test
    public void testMoveRight_moveAndDontMerge() throws Exception {
        Board board = boardCreator.create(
                "0,4,2,0," +
                "2,0,0,8," +
                "0,0,0,0," +
                "0,0,0,0");

        new GameBoardManipulator(board).moveRight();

        assertEquals(boardCreator.create(
                "0,0,4,2," +
                "0,0,2,8," +
                "0,0,0,0," +
                "0,0,0,0"),
                board);
    }

    @Test
    public void testMoveRight_dontMoveAndMerge() throws Exception {
        Board board = boardCreator.create(
                "0,0,4,4," +
                "0,2,2,4," +
                "0,4,2,2," +
                "0,0,0,0");

        new GameBoardManipulator(board).moveRight();

        assertEquals(boardCreator.create(
                "0,0,0,8," +
                "0,0,4,4," +
                "0,0,4,4," +
                "0,0,0,0"),
                board);
    }

    @Test
    public void testMoveRight_moveAndMerge() throws Exception {
        Board board = boardCreator.create(
                "0,0,4,4," +
                "0,2,2,4," +
                "4,4,0,2," +
                "2,4,0,4");

        new GameBoardManipulator(board).moveRight();

        assertEquals(boardCreator.create(
                "0,0,0,8," +
                "0,0,4,4," +
                "0,0,8,2," +
                "0,0,2,8"),
                board);
    }
}
