package com.unshar.myrobo;

import java.util.Optional;
import java.util.Scanner;

import com.unshar.myrobo.enumerator.Direction;
import com.unshar.myrobo.service.RobotService;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to my-robo!");
        RobotService robotService = new RobotService();

        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {

                String command = scanner.nextLine();

                if (command.startsWith("PLACE")) {

                    String[] parts = command.substring(6).split(",");

                    int x = Integer.parseInt(parts[0]);
                    int y = Integer.parseInt(parts[1]);
                    Direction direction = Direction.valueOf(parts[2]);

                    robotService.place(x, y, direction);

                } else if (command.equals("MOVE")) {

                    robotService.move();

                } else if (command.equals("LEFT")) {

                    robotService.turnLeft();

                } else if (command.equals("RIGHT")) {

                    robotService.turnRight();

                } else if (command.equals("REPORT")) {

                    Optional.ofNullable(robotService.report())
                            .ifPresent(System.out::println);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
