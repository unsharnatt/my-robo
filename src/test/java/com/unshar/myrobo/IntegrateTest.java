package com.unshar.myrobo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class IntegrateTest {

    @Test
    void testMove_shouldValid_whenValidInput() {

        String input = String.join("\n",
                "PLACE 1,0,NORTH",
                "LEFT",
                "MOVE",
                "RIGHT",
                "REPORT") + "\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;
        java.io.InputStream originalIn = System.in;

         try (PrintStream ps = new PrintStream(out)) {
            System.setIn(in);
            System.setOut(new PrintStream(out));

            Main.main(new String[] {});

        } finally {
            System.setOut(originalOut);
            System.setIn(originalIn);
        }

        String output = out.toString();

        assertTrue(output.contains("Welcome to my-robo!"));
        assertTrue(output.contains("0,0,NORTH"));

    }
}
