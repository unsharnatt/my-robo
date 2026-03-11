***My Robo Project***

# Compile via the command below:
```bash
./mvn compile
```
# Run/Execute via the command below:
```bash
./mvn exec:java
```

To move the robot on the table of 5X5, x,y values as shown below:
```
                    NORTH
        -------------------------------
        | 0,4 | 1,4 | 2,4 | 3,4 | 4,4 |
        -------------------------------
        | 0,3 | 1,3 | 2,3 | 3,3 | 4,3 |
        -------------------------------
WEST    | 0,2 | 1,2 | 2,2 | 3,2 | 4,2 |     EAST
        -------------------------------
        | 0,1 | 1,1 | 2,1 | 3,1 | 4,1 |
        -------------------------------
        | 0,0 | 1,0 | 2,0 | 3,0 | 4,0 |
        -------------------------------
                     SOUTH
```
To start the moving run PLACE command with parameters 'x,y,faceTo' for example 'PLACE 0,0,NORTH'
then you could make moves or turns continuously with commands: 
- MOVE to go 1 unit toward the direction that the robot faceTo 
- LEFT to turn the robot face 90 degree againt the clock
- RIGHT to turn the robot face 90 degree follow the clock
Whenever you would like to know the current position of the robot and his face direction run the command REPORT
To stop the program press CTRL+C

# Run Unit Test
- run the command
```Bash
 ./mvn test
```
- check the report at .\target\site\jacoco\index.html

# The system required
- JDK Java 11 
