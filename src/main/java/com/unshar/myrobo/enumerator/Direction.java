package com.unshar.myrobo.enumerator;

public enum Direction {

    NORTH, EAST, SOUTH, WEST;

    private Direction left;
    private Direction right;

    static {
        NORTH.setNeighbors(WEST, EAST);
        EAST.setNeighbors(NORTH, SOUTH);
        SOUTH.setNeighbors(EAST, WEST);
        WEST.setNeighbors(SOUTH, NORTH);
    }

    private void setNeighbors(Direction left, Direction right) {
        this.left = left;
        this.right = right;
    }

    public Direction turnLeft() {
        return this.left;
    }

    public Direction turnRight() {
        return this.right;
    }
}
