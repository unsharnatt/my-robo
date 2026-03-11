package com.unshar.myrobo.service;

import com.unshar.myrobo.enumerator.Direction;
import com.unshar.myrobo.model.Position;
import com.unshar.myrobo.model.Robot;
import com.unshar.myrobo.model.Table;

public class RobotService {

    private Robot robot;
    private Table table;

    public RobotService() {
        this.robot = new Robot();
        this.table = new Table();
    }

    public void place(int x, int y, Direction direction) {

        if (table.isValidPosition(x, y)) {
            robot.place(x, y, direction);
        }
    }

    public void move() {

        if (!robot.isPlaced())
            return;

        int x = robot.getPosition().getX();
        int y = robot.getPosition().getY();

        switch (robot.getDirection()) {

            case NORTH:
                y++;
                break;

            case SOUTH:
                y--;
                break;

            case EAST:
                x++;
                break;

            case WEST:
                x--;
                break;
        }

        if (table.isValidPosition(x, y)) {
            robot.setPosition(new Position(x, y));
        }
    }

    public void turnLeft() {

        if (!robot.isPlaced())
            return;

        robot.setDirection(robot.getDirection().turnLeft());
    }

    public void turnRight() {

        if (!robot.isPlaced())
            return;

        robot.setDirection(robot.getDirection().turnRight());
    }

    public String report() {

        if (!robot.isPlaced())
            return null;

        Position p = robot.getPosition();

        return String.format("%s,%s,%s", p.getX(), p.getY(), robot.getDirection());
    }
}
