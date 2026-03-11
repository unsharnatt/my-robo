package com.unshar.myrobo.model;

import com.unshar.myrobo.enumerator.Direction;

public class Robot {

    private Position position;
    private Direction direction;

    public void place(int x, int y, Direction direction) {
        this.position = new Position(x, y);
        this.direction = direction;
    }

    public boolean isPlaced() {
        return position != null;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
