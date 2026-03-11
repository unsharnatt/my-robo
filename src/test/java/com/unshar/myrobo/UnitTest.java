package com.unshar.myrobo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.unshar.myrobo.enumerator.Direction;
import com.unshar.myrobo.service.RobotService;

class UnitTest {

    private RobotService robotService;

    @BeforeEach
    void setup() {
        robotService = new RobotService();
    }

    @Test
    void testPlace_shouldValid_whenValidInput() {

        robotService.place(0, 0, Direction.NORTH);

        String result = robotService.report();
        assertNotNull(result);
        assertEquals("0,0,NORTH", result);
    }

    @Test
    void testPlace_shouldBlank_whenInValidInput() {

        robotService.place(0, 5, Direction.NORTH);

        String result = robotService.report();
        assertNull(result);
    }

    @Test
    void testMoveNorth_shouldMove_whenValidInput() {

        robotService.place(0, 0, Direction.NORTH);

        robotService.move();

        String result = robotService.report();
        assertNotNull(result);
        assertEquals("0,1,NORTH", result);
    }

    @Test
    void testMoveBlocked_shouldNotMove_whenInvalidPositionYInput() {

        robotService.place(0, 0, Direction.SOUTH);

        robotService.move();

        String result = robotService.report();
        assertNotNull(result);
        assertEquals("0,0,SOUTH", result);
    }

    @Test
    void testMoveBlocked_shouldNotMove_whenInvalidPositionXInput() {

        robotService.place(0, 0, Direction.WEST);

        robotService.move();

        String result = robotService.report();
        assertNotNull(result);
        assertEquals("0,0,WEST", result);
    }

    @Test
    void testMove_shouldBlank_whenNoPlace() {

        robotService.move();

        String result = robotService.report();
        assertNull(result);
    }

    @Test
    void testTurnLeft_shouldTurned_whenValidInput() {

        robotService.place(0, 0, Direction.NORTH);

        robotService.turnLeft();

        String result = robotService.report();
        assertNotNull(result);
        assertEquals("0,0,WEST", result);
    }

    @Test
    void testTurnLeft_shouldBlank_whenNoPlace() {

        robotService.turnLeft();

        String result = robotService.report();
        assertNull(result);
    }

    @Test
    void testTurnRight_shouldTurned_whenValidInput() {

        robotService.place(0, 0, Direction.NORTH);

        robotService.turnRight();
        
        String result = robotService.report();
        assertNotNull(result);
        assertEquals("0,0,EAST", result);
    }

    @Test
    void testTurnRight_shouldBlank_whenNoPlace() {

        robotService.turnRight();

        String result = robotService.report();
        assertNull(result);
    }

    @Test
    void testReport_shouldValid_whenValidMultipleInput() {

        robotService.place(1, 2, Direction.EAST);

        robotService.move();
        robotService.move();
        robotService.turnLeft();
        robotService.move();
        
        String result = robotService.report();
        assertNotNull(result);
        assertEquals("3,3,NORTH", result);

        robotService.turnLeft();
        robotService.move();
        assertEquals("2,3,WEST", robotService.report());
    }

}
