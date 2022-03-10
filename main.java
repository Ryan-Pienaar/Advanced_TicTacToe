import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

public class main
{

    static final int canvasWidth = 300;
    static final int canvasHeight = 650;

    static final int ARRDEPTH = 4;
    static final int ARRWIDTH = 5;
    static final int ARRHEIGHT = 9;


    public static void drawBackground(int canvasHeight, int canvasWidth)
    {

        StdDraw.clear(StdDraw.LIGHT_GRAY);
        //Canvas Border
        StdDraw.setPenRadius(0.01);
        StdDraw.line(0, 0, canvasWidth, 0);
        StdDraw.line(0, canvasHeight, canvasWidth, canvasHeight);
        StdDraw.line(0, canvasHeight, 0, 0);
        StdDraw.line(canvasWidth, canvasHeight, canvasWidth, 0);

        //Top text
        Font font = new Font("SansSerif", Font.PLAIN, 20);
        StdDraw.setFont(font);
        StdDraw.text(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, "Have Fun! :D");

        //Main bottom square
        double sqrSize = (canvasWidth - canvasWidth * 0.025) / 2;
        StdDraw.setPenRadius(0.015);
        StdDraw.square(canvasWidth / 2, canvasWidth / 2, sqrSize);
        StdDraw.setPenRadius(0.006);
        //Grid squares
        for (double i = 256.875; i > 0; i -= 71.25)
        {
            for (double j = 43.125; j < canvasWidth; j += 71.25)
            {
                StdDraw.square(j, i, 35.625);
            }
        }

        //Object grid
        Font font1 = new Font("SansSerif", Font.PLAIN, 18);
        Font font2 = new Font("SansSerif", Font.PLAIN, 23);
        StdDraw.setFont(font1);
        StdDraw.text(39.375, canvasWidth / 2 * 3 + canvasWidth * 0.25, "Stacks:");
        StdDraw.text(39.375, canvasWidth / 2 * 2.78, "Object 1:");
        StdDraw.text(39.375, canvasWidth / 2 * 2.3, "Object 2:");
        StdDraw.setFont(font2);
        StdDraw.text(114.375, canvasWidth / 2 * 3 + canvasWidth * 0.4, "A");
        StdDraw.text(185.625, canvasWidth / 2 * 3 + canvasWidth * 0.4, "B");
        StdDraw.text(256.875, canvasWidth / 2 * 3 + canvasWidth * 0.4, "C");
        StdDraw.text(114.375, canvasWidth / 2 * 3 + canvasWidth * 0.055, "t");
        StdDraw.text(185.625, canvasWidth / 2 * 3 + canvasWidth * 0.055, "b");
        StdDraw.text(256.875, canvasWidth / 2 * 3 + canvasWidth * 0.055, "r");
        StdDraw.picture(114.375, canvasWidth / 2 * 2.78, "resources/transporter.png", 68, 68);
        StdDraw.picture(114.375, canvasWidth / 2 * 2.3, "resources/transporter.png", 68, 68);
        StdDraw.picture(185.625, canvasWidth / 2 * 2.78, "resources/bomb.png", 68, 68);
        StdDraw.picture(185.625, canvasWidth / 2 * 2.3, "resources/bomb.png", 68, 68);
        StdDraw.picture(256.875, canvasWidth / 2 * 2.78, "resources/shifter.png", 68, 68);
        StdDraw.picture(256.875, canvasWidth / 2 * 2.3, "resources/shifter.png", 68, 68);

        for (double i = canvasWidth + canvasWidth * 0.03 ; i <= canvasWidth / 2 * 3 + canvasWidth * 0.05; i += canvasWidth * 0.2375)
        {
            StdDraw.line(canvasWidth * 0.025 + 71.25, i, canvasWidth - canvasWidth * 0.025, i);
        }

        for (double i = canvasWidth * 0.025 + 71.25; i <= canvasWidth; i += canvasWidth * 0.2375)
        {
            StdDraw.line(i, canvasWidth + canvasWidth * 0.03, i, canvasWidth / 2 * 3 + canvasWidth * 0.005);
        }
        StdDraw.show(0);

    }

    public static void drawCircle(double x, double y, String s)
    {
        if (s.contains("B"))
        {
            StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        }
        else if (s.contains("G"))
        {
            StdDraw.setPenColor(StdDraw.GREEN);
        }

        if (s.contains("1"))
        {
            StdDraw.filledCircle(x, y, 30);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.circle(x, y, 30);
        }
        if (s.contains("2"))
        {
            StdDraw.filledCircle(x, y, 25);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.circle(x, y, 25);
        }
        if (s.contains("3"))
        {
            StdDraw.filledCircle(x, y, 20);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.circle(x, y, 20);
        }
        if (s.contains("4"))
        {
            StdDraw.filledCircle(x, y, 15);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.circle(x, y, 15);
        }
    }

    public static void drawStackCircles(int turn, String[][][] externalStack)
    {

        int stackTurn = 0;

        if (turn % 2 == 0)
        {
            stackTurn = 0;
        }
        else if (turn % 2 != 0)
        {
            stackTurn = 1;
        }

        for (int j = 4; j > 0; j--)
        {
            if (externalStack[0][0][j - 1] != null)
            {
                drawCircle(114.375, canvasWidth / 2 * 3 + canvasWidth * 0.25, externalStack[stackTurn][0][j - 1]);
            }
            if (externalStack[0][1][j - 1] != null)
            {
                drawCircle(185.625, canvasWidth / 2 * 3 + canvasWidth * 0.25, externalStack[stackTurn][1][j - 1]);
            }
            if (externalStack[0][2][j - 1] != null)
            {
                drawCircle(257.125, canvasWidth / 2 * 3 + canvasWidth * 0.25, externalStack[stackTurn][2][j - 1]);
            }
        }
        StdDraw.show(0);
    }

    public static void objectsUsed(String turnLetter, Stack blueTransporter, Stack blueBomb, Stack blueShifter, Stack greenTransporter,Stack greenBomb, Stack greenShifter)
    {
        StdDraw.setPenColor(StdDraw.BLACK);
        if (turnLetter == "B")
        {
            if (blueTransporter.isEmpty())
            {
                StdDraw.filledSquare(114.375, canvasWidth / 2 * 2.78, 35.625);
                StdDraw.filledSquare(114.375, canvasWidth / 2 * 2.3, 35.625);
            }
            else if (blueTransporter.peek() == "T2")
            {
                StdDraw.filledSquare(114.375, canvasWidth / 2 * 2.78, 35.625);
            }
            if (blueShifter.isEmpty())
            {
                StdDraw.filledSquare(256.875, canvasWidth / 2 * 2.78, 35.625);
                StdDraw.filledSquare(256.875, canvasWidth / 2 * 2.3, 35.625);
            }
            else if (blueShifter.peek() == "S2")
            {
                StdDraw.filledSquare(256.875, canvasWidth / 2 * 2.78, 35.625);
            }

            if (blueBomb.isEmpty())
            {
                StdDraw.filledSquare(185.625, canvasWidth / 2 * 2.78, 35.625);
                StdDraw.filledSquare(185.625, canvasWidth / 2 * 2.3, 35.625);
            }
            else if (blueBomb.peek() == "BOMB2")
            {
                StdDraw.filledSquare(185.625, canvasWidth / 2 * 2.78, 35.625);
            }

        }
        else if (turnLetter == "G")
        {
            if (greenTransporter.isEmpty())
            {
                StdDraw.filledSquare(114.375, canvasWidth / 2 * 2.78, 35.625);
                StdDraw.filledSquare(114.375, canvasWidth / 2 * 2.3, 35.625);
            }
            else if (greenTransporter.peek() == "T2")
            {
                StdDraw.filledSquare(114.375, canvasWidth / 2 * 2.78, 35.625);
            }

            if (greenShifter.isEmpty())
            {
                StdDraw.filledSquare(256.875, canvasWidth / 2 * 2.78, 35.625);
                StdDraw.filledSquare(256.875, canvasWidth / 2 * 2.3, 35.625);
            }
            else if (greenShifter.peek() == "S2")
            {
                StdDraw.filledSquare(256.875, canvasWidth / 2 * 2.78, 35.625);
            }
            if (greenBomb.isEmpty())
            {
                StdDraw.filledSquare(185.625, canvasWidth / 2 * 2.78, 35.625);
                StdDraw.filledSquare(185.625, canvasWidth / 2 * 2.3, 35.625);
            }
            else if (greenBomb.peek() == "BOMB2")
            {
                StdDraw.filledSquare(185.625, canvasWidth / 2 * 2.78, 35.625);
            }
        }
    }


    public static void main(String[] args)
    {
        /** Visual Mode */
        if (args.length == 0)
        {
            // Variable List
            int turn = 0;
            int stackNum = 0;
            int stackTurn = 0;
            int movePiece = 0;
            int invalid = 0;
            int greenWin = 0;
            int blueWin = 0;
            int noStack = 0;
            int quit = 0;
            int reRun = 0;
            int fromStack = 0;
            int ySelect = 1;
            int xSelect = 1;
            int objectChoose = 0;
            int boardAmount = 0;
            int transportAmount = 0;
            int shifterRotation = 0;
            double sqr_xPos = 43.125;
            double sqr_yPos = 256.875;
            String empty = "__";
            String turnLetter = "";
            String invTurnLetter = "";

            //Objects Stack
            Stack greenBomb = new Stack();
            greenBomb.push("BOMB2");
            greenBomb.push("BOMB1");

            Stack greenTransporter = new Stack();
            greenTransporter.push("T2");
            greenTransporter.push("T1");

            Stack greenPaintbrush = new Stack();
            greenPaintbrush.push("P2");
            greenPaintbrush.push("P1");

            Stack greenShifter = new Stack();
            greenShifter.push("S2");
            greenShifter.push("S1");

            Stack blueBomb = new Stack();
            blueBomb.push("BOMB2");
            blueBomb.push("BOMB1");

            Stack blueTransporter = new Stack();
            blueTransporter.push("T2");
            blueTransporter.push("T1");

            Stack bluePaintbrush = new Stack();
            bluePaintbrush.push("P2");
            bluePaintbrush.push("P1");

            Stack blueShifter = new Stack();
            blueShifter.push("S2");
            blueShifter.push("S1");

            //For temporary usage
            Stack tempStack = new Stack();

            // Blue External Stack & Green External Stack 3D Array
            String[][][] externalStack = new String[2][3][4];
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    for (int k = 0; k < 4; k++)
                    {
                        if (i == 0)
                        {
                            externalStack[i][j][k] = "B" + (k + 1);
                        }
                        if (i == 1)
                        {
                            externalStack[i][j][k] = "G" + (k + 1);
                        }
                    }
                }
            }

            //Game Board Array
            String[][][] gameBoard = new String[ARRDEPTH][ARRWIDTH][ARRHEIGHT];
            for (int i = 0; i < ARRDEPTH; i++)
            {
                for (int j = 0; j < ARRWIDTH; j++)
                {
                    for (int k = 0; k < ARRHEIGHT; k++)
                    {
                        if (j == 0)
                            if (k == 0)
                                gameBoard[i][j][k] = "   ";
                            else if (k % 2 == 1)
                                gameBoard[i][j][k] = "c" + (k / 2 + 1);
                            else
                                gameBoard[i][j][k] = " ";
                        else if (k == 0)
                            gameBoard[i][j][k] = "r" + j + " ";
                        else if (k % 2 == 0)
                            gameBoard[i][j][k] = "|";
                        else
                            gameBoard[i][j][k] = "__";
                    }
                }
            }
            Font font = new Font("SansSerif", Font.PLAIN, 20);

            StdDraw.enableDoubleBuffering();
            StdDraw.setCanvasSize(canvasWidth, canvasHeight);
            StdDraw.setXscale(0, canvasWidth);
            StdDraw.setYscale(0, canvasHeight);
            drawBackground(canvasHeight, canvasWidth);
            drawStackCircles(turn, externalStack);
            StdDraw.show(0);

            // To print the empty game board at start
            for (int j = 0; j < ARRWIDTH; j++)
            {
                for (int z = 0; z < ARRHEIGHT; z++)
                {
                    System.out.print(gameBoard[0][j][z] + "");
                }
                System.out.println();
            }
            System.out.println();



            if (greenWin == 0 && blueWin == 0)
            {

                while (true)
                {

                    //2nd Variable List
                    int xPosPlaced = 1;
                    int yPosPlaced = 1;

                    if (turn % 2 == 0)
                    {
                        stackTurn = 0;
                        turnLetter = "B";
                        invTurnLetter = "G";
                    }
                    else if (turn % 2 != 0)
                    {
                        stackTurn = 1;
                        turnLetter = "G";
                        invTurnLetter = "B";
                    }
                    //Draw Stack Circles
                    drawStackCircles(turn, externalStack);
                    //Powerups Used
                    objectsUsed(turnLetter, blueTransporter, blueBomb, blueShifter, greenTransporter, greenBomb, greenShifter);
                    StdDraw.show(0);

                    while (!StdDraw.hasNextKeyTyped()) ;
                    char stackChoose = StdDraw.nextKeyTyped();
                    while (true)
                    {
                        if (stackChoose == 'q')
                        {
                        quit++;
                        break;
                        }
                        else if (stackChoose == 'A')
                        {
                            stackNum = 0;
                            fromStack = 1;
                            StdDraw.square(114.375, canvasWidth / 2 * 3 + canvasWidth * 0.41, 12);
                            StdDraw.show(0);
                            break;
                        }
                        else if (stackChoose == 'B')
                        {
                            stackNum = 1;
                            fromStack = 1;
                            StdDraw.square(185.625, canvasWidth / 2 * 3 + canvasWidth * 0.41, 12);
                            StdDraw.show(0);
                            break;
                        }
                        else if (stackChoose == 'C')
                        {
                            stackNum = 2;
                            fromStack = 1;
                            StdDraw.square(256.875, canvasWidth / 2 * 3 + canvasWidth * 0.41, 12);
                            StdDraw.show(0);
                            break;
                        }
                        else if (stackChoose == 'w' || stackChoose == 'a' || stackChoose == 's' || stackChoose == 'd')
                        {
                            StdDraw.setPenColor(StdDraw.RED);
                            StdDraw.setPenRadius(0.003);
                            StdDraw.square(sqr_xPos, sqr_yPos, 35);
                            StdDraw.show();
                            noStack = 1;
                            movePiece = 1;
                            break;
                        }
                        else if (stackChoose == 't')
                        {
                            fromStack = 2;
                            objectChoose = 1;
                            StdDraw.square(114.375, canvasWidth / 2 * 3 + canvasWidth * 0.06, 10);
                            break;
                        }
                        else if (stackChoose == 'b')
                        {
                            fromStack = 2;
                            objectChoose = 2;
                            StdDraw.square(185.625, canvasWidth / 2 * 3 + canvasWidth * 0.06, 10);
                            StdDraw.show(0);
                            break;
                        }
                        else if (stackChoose == 'r')
                        {
                            fromStack = 2;
                            objectChoose = 3;
                            StdDraw.square(257.875, canvasWidth / 2 * 3 + canvasWidth * 0.06, 10);
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.filledRectangle(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, 100, 25);
                            StdDraw.setPenColor(StdDraw.BLACK);
                            Font font2 = new Font("SansSerif", Font.PLAIN, 20);
                            StdDraw.setFont(font2);
                            StdDraw.text(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, "Clockwise [9], Anti-Clockwise [0]");
                            StdDraw.show(0);
                            while (true)
                            {
                                while (!StdDraw.hasNextKeyTyped()) ;
                                char rotationSelect = StdDraw.nextKeyTyped();
                                if (rotationSelect == '9')
                                {
                                    shifterRotation = 1;
                                    break;
                                }
                                else if (rotationSelect == '0')
                                {
                                    shifterRotation = 0;
                                    break;
                                }
                                else
                                {
                                    continue;
                                }
                            }
                            break;
                        }
                        else
                        {
                            continue;
                        }
                    }
                    StdDraw.setPenRadius(0.006);

                    if (quit == 1)
                    {
                        drawStackCircles(turn, externalStack);
                        StdDraw.setFont(font);
                        System.out.println("Quit!");
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.filledRectangle(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, 100, 25);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, "Quit!");
                        quit = 0;
                        StdDraw.show(0);
                        break;
                    }


                    while (true)
                    {
                        drawStackCircles(turn, externalStack);
                        objectsUsed(turnLetter, blueTransporter, blueBomb, blueShifter, greenTransporter, greenBomb, greenShifter);
                        StdDraw.show(0);
                        reRun = 0;
                        while (!StdDraw.hasNextKeyTyped()) ;
                        char input = ' ';
                        if (noStack == 0)
                        {
                            while (!StdDraw.hasNextKeyTyped()) ;
                            input = StdDraw.nextKeyTyped();
                        }
                        else if (noStack == 1)
                        {
                            input = stackChoose;
                            noStack = 0;
                        }

                        if (input == 'w' || input == 'a' || input == 's' || input == 'd')
                        {
                            while (input == 'w' || input == 'a' || input == 's' || input == 'd')
                            {
                                StdDraw.setPenRadius(0.006);
                                StdDraw.setPenColor(StdDraw.BLACK);
                                for (int i = 1; i < 5; i++)
                                {
                                    for (int j = 1; j < 5; j++)
                                    {
                                        if (gameBoard[0][i][2 * j - 1] != empty)
                                        {
                                            drawCircle(43.375 + (j - 1) * 71.25, 256.875 - (i - 1) * 71.25, gameBoard[0][i][2 * j - 1]);
                                        }
                                    }
                                }
                                StdDraw.show(0);
                                StdDraw.setPenColor(StdDraw.BLACK);
                                StdDraw.setPenRadius(0.006);

                                //Grid squares
                                for (double i = 256.875; i > 0; i -= 71.25)
                                {
                                    for (double j = 43.125; j < canvasWidth; j += 71.25)
                                    {
                                        StdDraw.square(j, i, 35.625);
                                    }
                                }
                                StdDraw.setPenColor(StdDraw.RED);
                                StdDraw.setPenRadius(0.003);
                                StdDraw.square(sqr_xPos, sqr_yPos, 35);
                                StdDraw.setPenRadius(0.006);
                                StdDraw.show();

                                while (!StdDraw.hasNextKeyTyped()) ;
                                char input2 = StdDraw.nextKeyTyped();
                                if (input2 != '\n')
                                {
                                    if (input2 == 'w' && sqr_yPos < 256.875)
                                    {
                                        sqr_yPos += 71.25;
                                        if (movePiece == 0)
                                        {
                                            yPosPlaced -= 1;
                                        }
                                        if (movePiece == 1)
                                        {
                                            ySelect -= 1;
                                        }

                                    }
                                    else if (input2 == 'a' && sqr_xPos > 43.125)
                                    {
                                        sqr_xPos -= 71.25;
                                        if (movePiece == 0)
                                        {
                                            xPosPlaced -= 2;
                                        }
                                        if (movePiece == 1)
                                        {
                                            xSelect -= 2;
                                        }
                                    }
                                    else if (input2 == 'a' && sqr_xPos == 43.125)
                                    {
                                        sqr_xPos += 213.75;
                                        if (movePiece == 0)
                                        {
                                            xPosPlaced += 6;
                                        }
                                        if (movePiece == 1)
                                        {
                                            xSelect += 6;
                                        }
                                    }
                                    else if (input2 == 's' && sqr_yPos > 43.125)
                                    {
                                        sqr_yPos -= 71.25;
                                        if (movePiece == 0)
                                        {
                                            yPosPlaced += 1;
                                        }
                                        if (movePiece == 1)
                                        {
                                            ySelect += 1;
                                        }
                                    }
                                    else if (input2 == 'd' && sqr_xPos < 256.875)
                                    {

                                        sqr_xPos += 71.25;
                                        if (movePiece == 0)
                                        {
                                            xPosPlaced += 2;
                                        }
                                        if (movePiece == 1)
                                        {
                                            xSelect += 2;
                                        }
                                    }
                                    else if (input2 == 'd' && sqr_xPos == 256.875)
                                    {
                                        sqr_xPos -= 213.75;
                                        if (movePiece == 0)
                                        {
                                            xPosPlaced -= 6;
                                        }
                                        if (movePiece == 1)
                                        {
                                            xSelect -= 6;
                                        }
                                    }

                                }
                                else if (input2 == '\n')
                                {
                                    StdDraw.setPenColor(StdDraw.BLACK);
                                    drawBackground(canvasHeight, canvasWidth);
                                    for (int i = 1; i < 5; i++)
                                    {
                                        for (int j = 1; j < 5; j++)
                                        {
                                            if (gameBoard[0][i][2 * j - 1] != empty)
                                            {
                                                drawCircle(43.375 + (j - 1) * 71.25, 256.875 - (i - 1) * 71.25, gameBoard[0][i][2 * j - 1]);
                                            }
                                        }
                                    }
                                    //Draw Sinkholes
                                    for (int i = 1; i < 5; i++)
                                    {
                                        for (int j = 1; j < 5; j++)
                                        {
                                            if (gameBoard[0][i][2 * j - 1] == "SH")
                                            {
                                                StdDraw.setPenColor(StdDraw.RED);
                                                StdDraw.filledSquare(43.375 + (j - 1) * 71.25, 256.875 - (i - 1) * 71.25, 34);
                                            }
                                        }
                                    }
                                    StdDraw.setPenColor(StdDraw.BLACK);
                                    objectsUsed(turnLetter, blueTransporter, blueBomb, blueShifter, greenTransporter, greenBomb, greenShifter);
                                    //Draw Stack Circles
                                    drawStackCircles(turn, externalStack);
                                    StdDraw.show();
                                    break;
                                }
                            }

                        }
                        else if (input != 'w' || input != 'a' || input != 's' || input != 'd')
                        {
                            reRun = 1;
                        }

                        if (movePiece == 1)
                        {
                            reRun = 1;
                            sqr_xPos = 43.125;
                            sqr_yPos = 256.875;
                            movePiece = 0;
                        }

                        if (reRun == 0)
                        {
                            break;
                        }
                        else
                        {
                            continue;
                        }
                    }

                    if (fromStack == 1)
                    {
                        if (gameBoard[0][yPosPlaced][xPosPlaced] != empty && gameBoard[0][yPosPlaced][xPosPlaced] != "SH" && externalStack[stackTurn][stackNum][0] != "")
                        {
                            int a = Integer.parseInt(externalStack[stackTurn][stackNum][0].substring(1));
                            int b = Integer.parseInt(gameBoard[0][yPosPlaced][xPosPlaced].substring(1));
                            if (a < b)
                            {
                                int hCount = 0;
                                int vCount = 0;
                                int dCountRight = 0;
                                int dCountLeft = 0;
                                //Horizontal
                                for (int i = 1; i < 5; i++)
                                {
                                    if (gameBoard[0][yPosPlaced][2 * i - 1].contains(invTurnLetter))
                                    {
                                        hCount++;
                                    }
                                }
                                //Vertical
                                for (int i = 1; i < 5; i++)
                                {
                                    if (gameBoard[0][i][xPosPlaced].contains(invTurnLetter))
                                    {
                                        vCount++;
                                    }
                                }
                                //Major Diagonal From Right
                                for (int i = 1; i < 5; i++)
                                {
                                    int k = 2 * i - 1;
                                    if (xPosPlaced == k && yPosPlaced == i)
                                    {
                                        for (int j = 1; j < 5; j++)
                                        {
                                            if (gameBoard[0][j][2 * j - 1].contains(invTurnLetter))
                                            {
                                                dCountRight++;
                                            }
                                        }
                                    }
                                }
                                //Top Minor Diagonal From Right
                                for (int i = 2; i < 5; i++)
                                {
                                    int k = 2 * i - 1;
                                    int z = i - 1;
                                    if (xPosPlaced == k && yPosPlaced == z)
                                    {
                                        for (int j = 2; j < 5; j++)
                                        {
                                            int m = j - 1;
                                            if (gameBoard[0][m][2 * j - 1].contains(invTurnLetter))
                                            {
                                                dCountRight++;
                                            }
                                        }
                                    }
                                }
                                //Bottom Minor Diagonal From Right
                                for (int i = 1; i < 4; i++)
                                {
                                    int k = 2 * i - 1;
                                    int z = i + 1;
                                    if (xPosPlaced == k && yPosPlaced == z)
                                    {
                                        for (int j = 1; j < 4; j++)
                                        {
                                            int m = j + 1;
                                            if (gameBoard[0][m][2 * j - 1].contains(invTurnLetter))
                                            {
                                                dCountRight++;
                                            }
                                        }
                                    }
                                }
                                //Major Diagonal From Left
                                for (int i = 1; i < 5; i++)
                                {
                                    int k = 9 - 2 * i;
                                    if (xPosPlaced == k && yPosPlaced == i)
                                    {
                                        for (int j = 1; j < 5; j++)
                                        {
                                            if (gameBoard[0][j][9 - 2 * j].contains(invTurnLetter))
                                            {
                                                dCountLeft++;
                                            }
                                        }
                                    }
                                }
                                //Top Minor Diagonal From Left
                                for (int i = 2; i < 5; i++)
                                {
                                    int k = 9 - 2 * i;
                                    int z = i - 1;
                                    if (xPosPlaced == k && yPosPlaced == z)
                                    {
                                        for (int j = 2; j < 5; j++)
                                        {
                                            int m = j - 1;
                                            if (gameBoard[0][m][9 - 2 * j].contains(invTurnLetter))
                                            {
                                                dCountLeft++;
                                            }
                                        }
                                    }
                                }
                                //Bottom Minor Diagonal From Left
                                for (int i = 1; i < 4; i++)
                                {
                                    int k = 9 - 2 * i;
                                    int z = i + 1;
                                    if (xPosPlaced == k && yPosPlaced == z)
                                    {
                                        for (int j = 1; j < 4; j++)
                                        {
                                            int m = j + 1;
                                            if (gameBoard[0][m][9 - 2 * j].contains(invTurnLetter))
                                            {
                                                dCountLeft++;
                                            }
                                        }
                                    }
                                }

                                if ((hCount == 3) || (vCount == 3) || (dCountRight == 3) || (dCountLeft == 3))
                                {
                                    for (int i = 3; i > 0; i--)
                                    {
                                        gameBoard[i][yPosPlaced][xPosPlaced] = gameBoard[i - 1][yPosPlaced][xPosPlaced];
                                    }
                                    gameBoard[0][yPosPlaced][xPosPlaced] = externalStack[stackTurn][stackNum][0];
                                    for (int i = 0; i < 3; i++)
                                    {
                                        externalStack[stackTurn][stackNum][i] = externalStack[stackTurn][stackNum][i + 1];
                                    }
                                    externalStack[stackTurn][stackNum][3] = "";
                                }
                                else
                                {
                                    invalid++;
                                }
                                hCount = 0;
                                vCount = 0;
                                dCountRight = 0;
                                dCountLeft = 0;
                            }
                            else if (a >= b)
                            {
                                invalid++;
                            }
                        }
                        else if (gameBoard[0][yPosPlaced][xPosPlaced] == empty && externalStack[stackTurn][stackNum][0] != "")
                        {
                            gameBoard[0][yPosPlaced][xPosPlaced] = externalStack[stackTurn][stackNum][0];
                            for (int i = 0; i < 1; i++)
                            {
                                for (int j = 0; j < 3; j++)
                                {
                                    externalStack[stackTurn][stackNum][j] = externalStack[stackTurn][stackNum][j + 1];
                                }
                                externalStack[stackTurn][stackNum][3] = "";
                            }
                        }
                        else if (gameBoard[0][yPosPlaced][xPosPlaced] == "SH" && externalStack[stackTurn][stackNum][0] != "")
                        {
                            gameBoard[0][yPosPlaced][xPosPlaced] = empty;
                        }
                        else if (externalStack[stackTurn][stackNum][0] == "")
                        {
                            invalid++;
                        }
                        fromStack = 0;
                    }
                    else if (fromStack == 0)
                    {
                        if (gameBoard[0][yPosPlaced][xPosPlaced] != empty && gameBoard[0][yPosPlaced][xPosPlaced] != "SH" && gameBoard[0][ySelect][xSelect] != empty && gameBoard[0][ySelect][xSelect] != "SH")
                        {
                            int a = Integer.parseInt(gameBoard[0][ySelect][xSelect].substring(1));
                            int b = Integer.parseInt(gameBoard[0][yPosPlaced][xPosPlaced].substring(1));
                            if (a < b && gameBoard[0][ySelect][xSelect].contains(turnLetter))
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    gameBoard[i][yPosPlaced][xPosPlaced] = gameBoard[i - 1][yPosPlaced][xPosPlaced];
                                }
                                gameBoard[0][yPosPlaced][xPosPlaced] = gameBoard[0][ySelect][xSelect];
                                for (int i = 0; i < 3; i++)
                                {
                                    gameBoard[i][ySelect][xSelect] = gameBoard[i + 1][ySelect][xSelect];
                                }
                                gameBoard[3][ySelect][xSelect] = "__";
                            }
                            else if (a >= b || gameBoard[0][ySelect][xSelect].contains(invTurnLetter))
                            {
                                invalid++;
                            }
                        }
                        else if (gameBoard[0][yPosPlaced][xPosPlaced] == empty && gameBoard[0][ySelect][xSelect] != empty && gameBoard[0][ySelect][xSelect] != "SH")
                        {
                            if (gameBoard[0][ySelect][xSelect].contains(turnLetter))
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    gameBoard[i][yPosPlaced][xPosPlaced] = gameBoard[i - 1][yPosPlaced][xPosPlaced];
                                }
                                gameBoard[0][yPosPlaced][xPosPlaced] = gameBoard[0][ySelect][xSelect];
                                for (int i = 0; i < 3; i++)
                                {
                                    gameBoard[i][ySelect][xSelect] = gameBoard[i + 1][ySelect][xSelect];
                                }
                                gameBoard[3][ySelect][xSelect] = "__";
                            }
                            else if (gameBoard[0][ySelect][xSelect].contains(invTurnLetter))
                            {
                                invalid++;
                            }

                        }
                        else if (gameBoard[0][yPosPlaced][xPosPlaced] == "SH" && gameBoard[0][ySelect][xSelect] != empty && gameBoard[0][ySelect][xSelect] != "SH")
                        {
                            tempStack.push(gameBoard[0][ySelect][xSelect]);
                            gameBoard[0][yPosPlaced][xPosPlaced] = empty;
                            for (int i = 0; i < 3; i++)
                            {
                                gameBoard[i][ySelect][xSelect] = gameBoard[i + 1][ySelect][xSelect];
                            }
                            gameBoard[3][ySelect][xSelect] = "__";
                        }
                        else if (gameBoard[0][ySelect][xSelect] == empty || gameBoard[0][ySelect][xSelect] == "SH")
                        {
                            invalid++;
                        }
                    }
                    else if (fromStack == 2)
                    {
                        //Transporter
                        if (objectChoose == 1)
                        {
                            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                            StdDraw.filledRectangle(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, 100, 25);
                            StdDraw.setPenColor(StdDraw.BLACK);

                            for (int i = 0; i < 4; i++)
                            {
                                if (gameBoard[i][yPosPlaced][xPosPlaced] != empty)
                                {
                                    boardAmount++;
                                }
                            }
                            Font font2 = new Font("SansSerif", Font.PLAIN, 18);
                            StdDraw.setFont(font2);
                            StdDraw.text(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, "Stack Total: " + boardAmount + " [Select Amount]");
                            StdDraw.show(0);
                            while (!StdDraw.hasNextKeyTyped()) ;
                            char amountTyped = StdDraw.nextKeyTyped();
                            if (amountTyped == '1')
                            {
                                transportAmount = 1;
                            }
                            else if (amountTyped == '2')
                            {
                                transportAmount = 2;
                            }
                            else if (amountTyped == '3')
                            {
                                transportAmount = 3;
                            }
                            else if (amountTyped == '4')
                            {
                                transportAmount = 4;
                            }


                            if (turnLetter == "B" && !blueTransporter.isEmpty() || (turnLetter == "G" && !greenTransporter.isEmpty()))
                            {
                                if (gameBoard[0][yPosPlaced][xPosPlaced] != empty)
                                {
                                    if (gameBoard[0][yPosPlaced][xPosPlaced].contains(invTurnLetter))
                                    {
                                        int selectAmount = 0;

                                        selectAmount = transportAmount;

                                        if (selectAmount <= boardAmount)
                                        {
                                            int finalXPos = 0;
                                            int finalYPos = 0;
                                            int distanceSum = 0;
                                            int newDistanceSum = 6;
                                            int newDistanceX = 0;
                                            int newDistanceY = 0;
                                            boolean transported = false;


                                            for (int i = 1; i < 5; i++)
                                            {
                                                for (int j = 1; j < 5; j++)
                                                {
                                                    if (gameBoard[0][i][2 * j - 1].equals(empty))
                                                    {
                                                        distanceSum = newDistanceSum;
                                                        newDistanceX = Math.abs((xPosPlaced + 1) / 2 - j);
                                                        newDistanceY = Math.abs(yPosPlaced - i);
                                                        newDistanceSum = newDistanceX + newDistanceY;

                                                        if (gameBoard[0][i][2 * j - 1].equals(empty))
                                                        {
                                                            if (newDistanceSum < distanceSum)
                                                            {
                                                                finalXPos = 2 * j - 1;
                                                                finalYPos = i;
                                                                transported = true;
                                                            }
                                                            else if (newDistanceSum > distanceSum)
                                                            {
                                                                newDistanceSum = distanceSum;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                                System.out.println(finalYPos);
                                                System.out.println(finalXPos);

                                            if (transported)
                                            {
                                                for (int i = 0; i < selectAmount; i++)
                                                {
                                                    gameBoard[i][finalYPos][finalXPos] = gameBoard[i][yPosPlaced][xPosPlaced];
                                                }
                                                for (int i = 0; i < selectAmount; i++)
                                                {
                                                    for (int j = 0; j < 3; j++)
                                                    {
                                                        gameBoard[j][yPosPlaced][xPosPlaced] = gameBoard[j + 1][yPosPlaced][xPosPlaced];
                                                    }
                                                    gameBoard[3][yPosPlaced][xPosPlaced] = "__";
                                                }
                                            }
                                        }
                                        else if (selectAmount > boardAmount)
                                        {
                                            invalid++;
                                        }
                                    }
                                    else if (gameBoard[0][yPosPlaced][xPosPlaced].contains(turnLetter))
                                    {
                                        invalid++;
                                    }
                                }
                            }

                            else
                            {
                                invalid++;
                            }


                            if (turnLetter == "B")
                            {
                                if (!blueTransporter.isEmpty())
                                {
                                    blueTransporter.pop();
                                }
                            }
                            else if (turnLetter == "G")
                            {
                                if (!greenTransporter.isEmpty())
                                {
                                    greenTransporter.pop();
                                }
                            }
                            fromStack = 0;
                            objectChoose = 0;
                            boardAmount = 0;
                        }
                        //Shifter
                        else if (objectChoose == 3)
                        {
                            if (turnLetter == "B" && !blueShifter.isEmpty() || (turnLetter == "G" && !greenShifter.isEmpty()))
                            {
                                if (gameBoard[0][yPosPlaced][xPosPlaced] == empty)
                                {
                                    int left = -2;
                                    int right = 2;
                                    int up = -1;
                                    int down = 1;

                                    if (xPosPlaced == 1)
                                    {
                                        left = 6;
                                    }

                                    if (xPosPlaced == 4)
                                    {
                                        right = -6;
                                    }

                                    if (yPosPlaced == 1)
                                    {
                                        up = 3;
                                    }

                                    if (yPosPlaced == 4)
                                    {
                                        down = -3;
                                    }
                                    //clockwise
                                    if (shifterRotation == 1)
                                    {
                                        for (int i = 0; i < 4; i++)
                                        {
                                            String finalPiece = "";
                                            finalPiece = gameBoard[i][yPosPlaced + up][xPosPlaced + right];
                                            gameBoard[i][yPosPlaced + up][xPosPlaced + right] = gameBoard[i][yPosPlaced + up][xPosPlaced];
                                            gameBoard[i][yPosPlaced + up][xPosPlaced] = gameBoard[i][yPosPlaced + up][xPosPlaced + left];
                                            gameBoard[i][yPosPlaced + up][xPosPlaced + left] = gameBoard[i][yPosPlaced][xPosPlaced + left];
                                            gameBoard[i][yPosPlaced][xPosPlaced + left] = gameBoard[i][yPosPlaced + down][xPosPlaced + left];
                                            gameBoard[i][yPosPlaced + down][xPosPlaced + left] = gameBoard[i][yPosPlaced + down][xPosPlaced];
                                            gameBoard[i][yPosPlaced + down][xPosPlaced] = gameBoard[i][yPosPlaced + down][xPosPlaced + right];
                                            gameBoard[i][yPosPlaced + down][xPosPlaced + right] = gameBoard[i][yPosPlaced][xPosPlaced + right];
                                            gameBoard[i][yPosPlaced][xPosPlaced + right] = finalPiece;
                                        }
                                    }
                                    //anti clockwise
                                    else if (shifterRotation == 0)
                                    {
                                        for (int i = 0; i < 4; i++)
                                        {
                                            String finalPiece = "";
                                            finalPiece = gameBoard[i][yPosPlaced + up][xPosPlaced + right];
                                            gameBoard[i][yPosPlaced + up][xPosPlaced + right] = gameBoard[i][yPosPlaced][xPosPlaced + right];
                                            gameBoard[i][yPosPlaced][xPosPlaced + right] = gameBoard[i][yPosPlaced + down][xPosPlaced + right];
                                            gameBoard[i][yPosPlaced + down][xPosPlaced + right] = gameBoard[i][yPosPlaced + down][xPosPlaced];
                                            gameBoard[i][yPosPlaced + down][xPosPlaced] = gameBoard[i][yPosPlaced + down][xPosPlaced + left];
                                            gameBoard[i][yPosPlaced + down][xPosPlaced + left] = gameBoard[i][yPosPlaced][xPosPlaced + left];
                                            gameBoard[i][yPosPlaced][xPosPlaced + left] = gameBoard[i][yPosPlaced + up][xPosPlaced + left];
                                            gameBoard[i][yPosPlaced + up][xPosPlaced + left] = gameBoard[i][yPosPlaced + up][xPosPlaced];
                                            gameBoard[i][yPosPlaced + up][xPosPlaced] = finalPiece;
                                        }
                                    }

                                    if (turnLetter == "B")
                                    {
                                        if (!blueShifter.isEmpty())
                                        {
                                            blueShifter.pop();
                                        }
                                    }
                                    else if (turnLetter == "G")
                                    {
                                        if (!greenShifter.isEmpty())
                                        {
                                            greenShifter.pop();
                                        }
                                    }
                                }
                                else if (gameBoard[0][yPosPlaced][xPosPlaced] != empty)
                                {
                                    invalid++;
                                }
                            }
                            else
                            {
                                invalid++;
                            }
                        }
                        //Bomb
                        else if (objectChoose == 2)
                        {

                            int left = -2;
                            int right = 2;
                            int up = -1;
                            int down = 1;

                            if (xPosPlaced == 1)
                            {
                                left = 6;
                            }

                            if (xPosPlaced == 7)
                            {
                                right = -6;
                            }

                            if (yPosPlaced == 1)
                            {
                                up = 3;
                            }

                            if (yPosPlaced == 4)
                            {
                                down = -3;
                            }

                            if (blueBomb.isEmpty() || greenBomb.isEmpty())
                            {
                                if (turnLetter == "B")
                                {
                                    if (blueBomb.isEmpty())
                                    {
                                        invalid++;
                                    }
                                }
                                else if (turnLetter == "G")
                                {
                                    if (greenBomb.isEmpty())
                                    {
                                        invalid++;
                                    }
                                }
                            }

                            if (gameBoard[0][yPosPlaced][xPosPlaced].contains(turnLetter) && invalid == 0)
                            {

                                for (int i = 0; i < 4; i++)
                                {
                                    if (gameBoard[i][yPosPlaced][xPosPlaced] != empty)
                                        boardAmount++;
                                }

                                for (int i = 0; i < boardAmount; i++)
                                {
                                    tempStack.push(gameBoard[0][yPosPlaced][xPosPlaced]);
                                    for (int j = 0; j < 3; j++)
                                    {
                                        gameBoard[j][yPosPlaced][xPosPlaced] = gameBoard[j + 1][yPosPlaced][xPosPlaced];
                                    }
                                    gameBoard[3][yPosPlaced][xPosPlaced] = "__";
                                }
                                boardAmount = 0;

                                int upDown = 0;
                                int leftRight = 0;
                                for (int i = 0; i < 8; i++)
                                {
                                    if (i == 0)
                                    {
                                        leftRight = left;
                                        upDown = up;
                                    }
                                    else if (i == 1)
                                    {
                                        leftRight = 0;
                                        upDown = up;
                                    }
                                    else if (i == 2)
                                    {
                                        leftRight = right;
                                        upDown = up;
                                    }
                                    else if (i == 3)
                                    {
                                        leftRight = right;
                                        upDown = 0;
                                    }
                                    else if (i == 4)
                                    {
                                        leftRight = right;
                                        upDown = down;
                                    }
                                    else if (i == 5)
                                    {
                                        leftRight = 0;
                                        upDown = down;
                                    }
                                    else if (i == 6)
                                    {
                                        leftRight = left;
                                        upDown = down;
                                    }
                                    else if (i == 7)
                                    {
                                        leftRight = left;
                                        upDown = 0;
                                    }

                                    if (gameBoard[0][yPosPlaced + upDown][xPosPlaced + leftRight].contains(empty) || gameBoard[0][yPosPlaced + upDown][xPosPlaced + leftRight].contains("SH"))
                                    {
                                        gameBoard[0][yPosPlaced + upDown][xPosPlaced + leftRight] = "SH";
                                    }
                                    else if (!gameBoard[0][yPosPlaced + upDown][xPosPlaced + leftRight].contains(empty))
                                    {
                                        tempStack.push(gameBoard[0][yPosPlaced + upDown][xPosPlaced + leftRight]);
                                        for (int j = 0; j < 3; j++)
                                        {
                                            gameBoard[j][yPosPlaced + upDown][xPosPlaced + leftRight] = gameBoard[j + 1][yPosPlaced + upDown][xPosPlaced + leftRight];
                                        }
                                        gameBoard[3][yPosPlaced + upDown][xPosPlaced + leftRight] = "__";
                                    }

                                }

                            }
                            else
                            {
                                invalid = 1;
                            }

                            if (turnLetter == "B")
                            {
                                if (!blueBomb.isEmpty())
                                {
                                    blueBomb.pop();
                                }
                            }
                            else if (turnLetter == "G")
                            {
                                if (!greenBomb.isEmpty())
                                {
                                    greenBomb.pop();
                                }
                            }
                        }
                    }

                    ySelect = 1;
                    xSelect = 1;
                    sqr_xPos = 43.125;
                    sqr_yPos = 256.875;

                    String topPiece = "";
                    while (!tempStack.isEmpty())
                    {
                        boolean BS1DoesContain = false;
                        boolean BS2DoesContain = false;
                        boolean BS3DoesContain = false;
                        boolean GS1DoesContain = false;
                        boolean GS2DoesContain = false;
                        boolean GS3DoesContain = false;
                        topPiece = tempStack.peek().toString();
                        tempStack.pop();

                        if (topPiece.contains("B"))
                        {
                            //Stack 1
                            for (int i = 0; i < 4; i++)
                            {
                                if (externalStack[0][0][i].contains(topPiece))
                                {
                                    BS1DoesContain = true;
                                }
                            }
                            if (!BS1DoesContain)
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    externalStack[0][0][i] = externalStack[0][0][i - 1];
                                }
                                externalStack[0][0][0] = topPiece;
                                topPiece = "";
                            }

                            //Stack 2
                            for (int i = 0; i < 4; i++)
                            {
                                if (externalStack[0][1][i].contains(topPiece))
                                {
                                    BS2DoesContain = true;
                                }
                            }
                            if (!BS2DoesContain)
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    externalStack[0][1][i] = externalStack[0][1][i - 1];
                                }
                                externalStack[0][1][0] = topPiece;
                                topPiece = "";
                            }

                            //Stack 3
                            for (int i = 0; i < 4; i++)
                            {
                                if (externalStack[0][2][i].contains(topPiece))
                                {
                                    BS3DoesContain = true;
                                }
                            }
                            if (!BS3DoesContain)
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    externalStack[0][2][i] = externalStack[0][2][i - 1];
                                }
                                externalStack[0][2][0] = topPiece;
                                topPiece = "";
                            }
                        }
                        else if (topPiece.contains("G"))
                        {
                            //Stack 1
                            for (int i = 0; i < 4; i++)
                            {
                                if (externalStack[1][0][i].contains(topPiece))
                                {
                                    GS1DoesContain = true;
                                }
                            }
                            if (!GS1DoesContain)
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    externalStack[1][0][i] = externalStack[1][0][i - 1];
                                }
                                externalStack[1][0][0] = topPiece;
                                topPiece = "";
                            }
                            //Stack 2
                            for (int i = 0; i < 4; i++)
                            {
                                if (externalStack[1][1][i].contains(topPiece))
                                {
                                    GS2DoesContain = true;
                                }
                            }
                            if (!GS2DoesContain)
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    externalStack[1][1][i] = externalStack[1][1][i - 1];
                                }
                                externalStack[1][1][0] = topPiece;
                                topPiece = "";
                            }

                            //Stack 3
                            for (int i = 0; i < 4; i++)
                            {
                                if (externalStack[1][2][i].contains(topPiece))
                                {
                                    GS3DoesContain = true;
                                }
                            }
                            if (!GS3DoesContain)
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    externalStack[1][2][i] = externalStack[1][2][i - 1];
                                }
                                externalStack[1][2][0] = topPiece;
                                topPiece = "";
                            }
                        }

                    }

                    //External Stack Array Rearrange
                    String temp;
                    for (int i = 0; i < 2; i++)
                    {
                        for (int j = 0; j < 3; j++)
                        {
                            for (int k = 0; k < 3; k++)
                            {
                                int a = 0;
                                if (!externalStack[i][j][k + 1].equals(""))
                                {
                                    a = Integer.parseInt(externalStack[i][j][k].substring(1));
                                }
                                int b = 0;
                                if (!externalStack[i][j][k + 1].equals(""))
                                {
                                    b = Integer.parseInt(externalStack[i][j][k + 1].substring(1));
                                }
                                if (a > b)
                                {
                                    temp = externalStack[i][j][k];
                                    externalStack[i][j][k] = externalStack[i][j][k + 1];
                                    externalStack[i][j][k + 1] = temp;
                                    k = -1;
                                }
                            }
                        }
                    }

                    if (invalid == 0)
                    {
                        for (int j = 0; j < ARRWIDTH; j++)
                        {
                            for (int z = 0; z < ARRHEIGHT; z++)
                            {
                                System.out.print(gameBoard[0][j][z] + "");
                            }
                            System.out.println();
                        }
                        System.out.println();
                    }

                    //Draw Circles
                    drawBackground(canvasHeight, canvasWidth);
                    for (int i = 1; i < 5; i++)
                    {
                        for (int j = 1; j < 5; j++)
                        {
                            if (gameBoard[0][i][2 * j - 1] != empty)
                            {
                                drawCircle(43.375 + (j - 1) * 71.25, 256.875 - (i - 1) * 71.25, gameBoard[0][i][2 * j - 1]);
                            }
                        }
                    }
                    //Draw Sinkholes
                    for (int i = 1; i < 5; i++)
                    {
                        for (int j = 1; j < 5; j++)
                        {
                            if (gameBoard[0][i][2 * j - 1] == "SH")
                            {
                                StdDraw.setPenColor(StdDraw.RED);
                                StdDraw.filledSquare(43.375 + (j - 1) * 71.25, 256.875 - (i - 1) * 71.25, 34);
                            }
                        }
                    }
                    StdDraw.show(0);


                    // Blue Vertical Check
                    for (int i = 1; i < 4; i++)
                    {
                        int bVerCount = 0;
                        for (int j = 1; j < 5; j++)
                        {
                            int k = 2 * i - 1;
                            if (gameBoard[0][j][k].contains("B"))
                            {
                                bVerCount++;
                            }
                            if (bVerCount == 4)
                            {
                                blueWin++;
                            }
                        }
                        bVerCount = 0;
                    }

                    // Blue Horizontal Check
                    for (int i = 1; i < 4; i++)
                    {
                        int bHorCount = 0;
                        for (int j = 1; j < 5; j++)
                        {
                            int k = 2 * j - 1;
                            if (gameBoard[0][i][k].contains("B"))
                            {
                                bHorCount++;
                            }
                            if (bHorCount == 4)
                            {
                                blueWin++;
                            }
                        }
                        bHorCount = 0;
                    }

                    // Blue Diagonal Check
                    int bDiagCount1 = 0;
                    for (int i = 1; i < 5; i++)
                    {
                        int j = 2 * i - 1;
                        if (gameBoard[0][i][j].contains("B"))
                        {
                            bDiagCount1++;
                        }
                        if (bDiagCount1 == 4)
                        {
                            blueWin++;
                        }
                    }
                    int bDiagCount2 = 0;
                    for (int i = 1; i < 5; i++)
                    {
                        int j = 9 - 2 * i;
                        if (gameBoard[0][i][j].contains("B"))
                        {
                            bDiagCount2++;
                        }
                        if (bDiagCount2 == 4)
                        {
                            blueWin++;
                        }
                    }

                    // Green Vertical Check
                    int gVerCount = 0;
                    for (int i = 1; i < 5; i++)
                    {
                        for (int j = 1; j < 5; j++)
                        {
                            int k = 2 * i - 1;
                            if (gameBoard[0][j][k].contains("G"))
                            {
                                gVerCount++;
                            }
                            if (gVerCount == 4)
                            {
                                greenWin++;
                            }
                        }
                        gVerCount = 0;
                    }

                    // Green Horizontal Check
                    int gHorCount = 0;
                    for (int i = 1; i < 5; i++)
                    {
                        for (int j = 1; j < 5; j++)
                        {
                            int k = 2 * j - 1;
                            if (gameBoard[0][i][k].contains("G"))
                            {
                                gHorCount++;
                            }
                            if (gHorCount == 4)
                            {
                                greenWin++;
                            }
                        }
                        gHorCount = 0;
                    }

                    // Green Diagonal Check
                    int gDiagCount1 = 0;
                    for (int i = 1; i < 5; i++)
                    {
                        int j = 2 * i - 1;
                        if (gameBoard[0][i][j].contains("G"))
                        {
                            gDiagCount1++;
                        }
                        if (gDiagCount1 == 4)
                        {
                            greenWin++;
                        }
                    }

                    int gDiagCount2 = 0;
                    for (int i = 1; i < 5; i++)
                    {
                        int j = 9 - 2 * i;
                        if (gameBoard[0][i][j].contains("G"))
                        {
                            gDiagCount2++;
                        }
                        if (gDiagCount2 == 4)
                        {
                            greenWin++;
                        }
                    }

                    // Win or Quit condition check
                    if (quit == 1)
                    {
                        System.out.println("Quit");
                        break;
                    }
                    else if ((blueWin >= 1) && (greenWin >= 1))
                    {
                        drawStackCircles(turn, externalStack);
                        StdDraw.setFont(font);
                        System.out.println("Draw!");
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.filledRectangle(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, 100, 25);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, "Draw!");
                        blueWin = 0;
                        greenWin = 0;
                        StdDraw.show(0);
                        break;
                    }
                    else if (blueWin >= 1)
                    {
                        drawStackCircles(turn, externalStack);
                        StdDraw.setFont(font);
                        System.out.println("Blue wins!");
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.filledRectangle(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, 100, 25);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, "Blue Wins!");
                        blueWin = 0;
                        StdDraw.show(0);
                        break;
                    }
                    else if (greenWin >= 1)
                    {
                        drawStackCircles(turn, externalStack);
                        StdDraw.setFont(font);
                        System.out.println("Green Wins!");
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                        StdDraw.filledRectangle(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, 100, 25);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.text(canvasWidth / 2, canvasHeight - canvasHeight * 0.05, "Green Wins!");
                        greenWin = 0;
                        StdDraw.show(0);
                        break;
                    }
                    else if (invalid == 1)
                    {
                        System.out.println("Invalid move");
                        invalid--;
                    }
                    turn += 1;
                }
            }
            StdDraw.pause(2500);
            System.exit(0);
        }

        /** Text Mode */
        if (args.length == 1)
        {

            // Blue External Stack & Green External Stack 3D Array
            String[][][] externalStack = new String[2][3][4];
            for (int i = 0; i < 2; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    for (int k = 0; k < 4; k++)
                    {
                        if (i == 0)
                        {
                            externalStack[i][j][k] = "B" + (k + 1);
                        }
                        if (i == 1)
                        {
                            externalStack[i][j][k] = "G" + (k + 1);
                        }
                    }
                }
            }

            //Objects Stack
            Stack greenBomb = new Stack();
            greenBomb.push("BOMB2");
            greenBomb.push("BOMB1");

            Stack greenTransporter = new Stack();
            greenTransporter.push("T2");
            greenTransporter.push("T1");

            Stack greenPaintbrush = new Stack();
            greenPaintbrush.push("P2");
            greenPaintbrush.push("P1");

            Stack greenShifter = new Stack();
            greenShifter.push("S2");
            greenShifter.push("S1");

            Stack blueBomb = new Stack();
            blueBomb.push("BOMB2");
            blueBomb.push("BOMB1");

            Stack blueTransporter = new Stack();
            blueTransporter.push("T2");
            blueTransporter.push("T1");

            Stack bluePaintbrush = new Stack();
            bluePaintbrush.push("P2");
            bluePaintbrush.push("P1");

            Stack blueShifter = new Stack();
            blueShifter.push("S2");
            blueShifter.push("S1");

            //For temporary usage
            Stack tempStack = new Stack();


            //Game Board Array
            String[][][] gameBoard = new String[ARRDEPTH][ARRWIDTH][ARRHEIGHT];
            for (int i = 0; i < ARRDEPTH; i++)
            {
                for (int j = 0; j < ARRWIDTH; j++)
                {
                    for (int k = 0; k < ARRHEIGHT; k++)
                    {
                        if (j == 0)
                            if (k == 0)
                                gameBoard[i][j][k] = "   ";
                            else if (k % 2 == 1)
                                gameBoard[i][j][k] = "c" + (k / 2 + 1);
                            else
                                gameBoard[i][j][k] = " ";
                        else if (k == 0)
                            gameBoard[i][j][k] = "r" + j + " ";
                        else if (k % 2 == 0)
                            gameBoard[i][j][k] = "|";
                        else
                            gameBoard[i][j][k] = "__";
                    }
                }
            }

            // To print the empty game board at start
            for (int j = 0; j < ARRWIDTH; j++)
            {
                for (int z = 0; z < ARRHEIGHT; z++)
                {
                    System.out.print(gameBoard[0][j][z] + "");
                }
                System.out.println();
            }
            System.out.println();


            // Input Array
            In in = new In(args[0]);

            int inputLength = 0;
            int inputLengthString = 0;


            char[] mainInput = new char[256];
            int iMainCount = 0;
            while (in.hasNextChar())
            {
                char input = in.readChar();
                if (input != ' ')
                {
                    mainInput[iMainCount] = input;
                    iMainCount++;
                }
            }

            for (int i = 0; i < mainInput.length; i++)
            {
                if (Character.isDigit(mainInput[i]))
                {
                    inputLength++;

                }
                else if (Character.isLetter(mainInput[i]))
                {
                    inputLengthString++;
                }
            }

            int[] inputArray = new int[inputLength];
            String[] inputArrayString = new String[inputLengthString];

            int iCount = 0;
            int jCount = 0;

            for (int i = 0; i < mainInput.length; i++)
            {
                if (Character.isDigit(mainInput[i]))
                {
                    inputArray[iCount] = Integer.parseInt(Character.toString(mainInput[i]));
                    iCount++;
                }
                else if (Character.isLetter(mainInput[i]))
                {
                    inputArrayString[jCount] = Character.toString(mainInput[i]);
                    jCount++;
                }
            }


            // Variable List
            int turn = 0;
            int stackNum = 0;
            int stackTurn = 0;
            int inputRead = 0;
            int stringRead = 0;
            int invalid = 0;
            int greenWin = 0;
            int blueWin = 0;
            int quit = 0;
            int paintDNE = 0;
            String empty = "__";
            String turnLetter = "";
            String invTurnLetter = "";

            // Game System
            while (inputRead < inputArray.length)
            {

                int xRead = 2 * inputArray[inputRead + 2] - 1;
                int yRead = inputArray[inputRead + 1];

                // Quit Code Check
                if (inputArray[inputRead + 1] == -1)
                {
                    quit++;
                }

                // Stack number check
                for (int i = 1; i < 4; i++)
                {
                    if (inputArray[inputRead] == i)
                    {
                        stackNum = i - 1;
                    }
                }

                if (turn % 2 == 0)
                {
                    stackTurn = 0;
                    turnLetter = "B";
                    invTurnLetter = "G";
                }
                else if (turn % 2 != 0)
                {
                    stackTurn = 1;
                    turnLetter = "G";
                    invTurnLetter = "B";
                }

                if (inputArray[inputRead] > 0 && inputArray[inputRead] < 4)
                {
                    if (gameBoard[0][yRead][xRead] != empty && gameBoard[0][yRead][xRead] != "SH" && externalStack[stackTurn][stackNum][0] != "")
                    {
                        int a = Integer.parseInt(externalStack[stackTurn][stackNum][0].substring(1));
                        int b = Integer.parseInt(gameBoard[0][yRead][xRead].substring(1));
                        if (a < b)
                        {
                            int hCount = 0;
                            int vCount = 0;
                            int dCountRight = 0;
                            int dCountLeft = 0;
                            //Horizontal
                            for (int i = 1; i < 5; i++)
                            {
                                if (gameBoard[0][yRead][2 * i - 1].contains(invTurnLetter))
                                {
                                    hCount++;
                                }
                            }
                            //Vertical
                            for (int i = 1; i < 5; i++)
                            {
                                if (gameBoard[0][i][xRead].contains(invTurnLetter))
                                {
                                    vCount++;
                                }
                            }
                            //Major Diagonal From Right
                            for (int i = 1; i < 5; i++)
                            {
                                int k = 2 * i - 1;
                                if (xRead == k && yRead == i)
                                {
                                    for (int j = 1; j < 5; j++)
                                    {
                                        if (gameBoard[0][j][2 * j - 1].contains(invTurnLetter))
                                        {
                                            dCountRight++;
                                        }
                                    }
                                }
                            }
                            //Top Minor Diagonal From Right
                            for (int i = 2; i < 5; i++)
                            {
                                int k = 2 * i - 1;
                                int z = i - 1;
                                if (xRead == k && yRead == z)
                                {
                                    for (int j = 2; j < 5; j++)
                                    {
                                        int m = j - 1;
                                        if (gameBoard[0][m][2 * j - 1].contains(invTurnLetter))
                                        {
                                            dCountRight++;
                                        }
                                    }
                                }
                            }
                            //Bottom Minor Diagonal From Right
                            for (int i = 1; i < 4; i++)
                            {
                                int k = 2 * i - 1;
                                int z = i + 1;
                                if (xRead == k && yRead == z)
                                {
                                    for (int j = 1; j < 4; j++)
                                    {
                                        int m = j + 1;
                                        if (gameBoard[0][m][2 * j - 1].contains(invTurnLetter))
                                        {
                                            dCountRight++;
                                        }
                                    }
                                }
                            }
                            //Major Diagonal From Left
                            for (int i = 1; i < 5; i++)
                            {
                                int k = 9 - 2 * i;
                                if (xRead == k && yRead == i)
                                {
                                    for (int j = 1; j < 5; j++)
                                    {
                                        if (gameBoard[0][j][9 - 2 * j].contains(invTurnLetter))
                                        {
                                            dCountLeft++;
                                        }
                                    }
                                }
                            }
                            //Top Minor Diagonal From Left
                            for (int i = 2; i < 5; i++)
                            {
                                int k = 9 - 2 * i;
                                int z = i - 1;
                                if (xRead == k && yRead == z)
                                {
                                    for (int j = 2; j < 5; j++)
                                    {
                                        int m = j - 1;
                                        if (gameBoard[0][m][9 - 2 * j].contains(invTurnLetter))
                                        {
                                            dCountLeft++;
                                        }
                                    }
                                }
                            }
                            //Bottom Minor Diagonal From Left
                            for (int i = 1; i < 4; i++)
                            {
                                int k = 9 - 2 * i;
                                int z = i + 1;
                                if (xRead == k && yRead == z)
                                {
                                    for (int j = 1; j < 4; j++)
                                    {
                                        int m = j + 1;
                                        if (gameBoard[0][m][9 - 2 * j].contains(invTurnLetter))
                                        {
                                            dCountLeft++;
                                        }
                                    }
                                }
                            }

                            if ((hCount == 3) || (vCount == 3) || (dCountRight == 3) || (dCountLeft == 3))
                            {
                                for (int i = 3; i > 0; i--)
                                {
                                    gameBoard[i][yRead][xRead] = gameBoard[i - 1][yRead][xRead];
                                }
                                gameBoard[0][yRead][xRead] = externalStack[stackTurn][stackNum][0];
                                for (int i = 0; i < 3; i++)
                                {
                                    externalStack[stackTurn][stackNum][i] = externalStack[stackTurn][stackNum][i + 1];
                                }
                                externalStack[stackTurn][stackNum][3] = "";
                            }
                            else
                            {
                                invalid++;
                            }
                            hCount = 0;
                            vCount = 0;
                            dCountRight = 0;
                            dCountLeft = 0;
                        }
                        else if (a >= b)
                        {
                            invalid++;
                        }
                    }
                    else if (gameBoard[0][yRead][xRead] == empty && externalStack[stackTurn][stackNum][0] != "")
                    {
                        gameBoard[0][yRead][xRead] = externalStack[stackTurn][stackNum][0];
                        for (int i = 0; i < 1; i++)
                        {
                            for (int j = 0; j < 3; j++)
                            {
                                externalStack[stackTurn][stackNum][j] = externalStack[stackTurn][stackNum][j + 1];
                            }
                            externalStack[stackTurn][stackNum][3] = "";
                        }
                    }
                    else if (gameBoard[0][yRead][xRead] == "SH" && externalStack[stackTurn][stackNum][0] != "")
                    {
                        gameBoard[0][yRead][xRead] = "__";
                    }
                    else if (externalStack[stackTurn][stackNum][0] != "")
                    {
                        invalid++;
                    }
                    inputRead = inputRead + 3;
                }
                else if (inputArray[inputRead] == 4)
                {
                    int x2Read = 2 * inputArray[inputRead + 4] - 1;
                    int y2Read = inputArray[inputRead + 3];

                    if (gameBoard[0][y2Read][x2Read] != empty && gameBoard[0][y2Read][x2Read] != "SH" && gameBoard[0][yRead][xRead] != empty && gameBoard[0][yRead][xRead] != "SH")
                    {
                        int a = Integer.parseInt(gameBoard[0][yRead][xRead].substring(1));
                        int b = Integer.parseInt(gameBoard[0][y2Read][x2Read].substring(1));
                        if (a < b && gameBoard[0][yRead][xRead].contains(turnLetter))
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                gameBoard[i][y2Read][x2Read] = gameBoard[i - 1][y2Read][x2Read];
                            }
                            gameBoard[0][y2Read][x2Read] = gameBoard[0][yRead][xRead];
                            for (int i = 0; i < 3; i++)
                            {
                                gameBoard[i][yRead][xRead] = gameBoard[i + 1][yRead][xRead];
                            }
                            gameBoard[3][yRead][xRead] = "__";
                        }
                        else if (a >= b || gameBoard[0][yRead][xRead].contains(invTurnLetter))
                        {
                            invalid++;
                        }
                    }
                    else if (gameBoard[0][y2Read][x2Read] == empty && gameBoard[0][yRead][xRead] != empty && gameBoard[0][yRead][xRead] != "SH")
                    {
                        if (gameBoard[0][yRead][xRead].contains(turnLetter))
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                gameBoard[i][y2Read][x2Read] = gameBoard[i - 1][y2Read][x2Read];
                            }
                            gameBoard[0][y2Read][x2Read] = gameBoard[0][yRead][xRead];
                            for (int i = 0; i < 3; i++)
                            {
                                gameBoard[i][yRead][xRead] = gameBoard[i + 1][yRead][xRead];
                            }
                            gameBoard[3][yRead][xRead] = "__";
                        }
                        else if (gameBoard[0][yRead][xRead].contains(invTurnLetter))
                        {
                            invalid++;
                        }

                    }
                    else if (gameBoard[0][y2Read][x2Read] == "SH" && gameBoard[0][yRead][xRead] != empty && gameBoard[0][yRead][xRead] != "SH")
                    {
                        tempStack.push(gameBoard[0][yRead][xRead]);
                        gameBoard[0][y2Read][x2Read] = empty;
                        for (int i = 0; i < 3; i++)
                        {
                            gameBoard[i][yRead][xRead] = gameBoard[i + 1][yRead][xRead];
                        }
                        gameBoard[3][yRead][xRead] = "__";
                    }
                    else if (gameBoard[0][yRead][xRead] == empty || gameBoard[0][yRead][xRead] == "SH")
                    {
                        invalid++;
                    }
                    inputRead = inputRead + 5;
                }
                else if (inputArray[inputRead] == 5)
                {
                    if (inputArrayString[stringRead].contains("T"))
                    {
                        if (turnLetter == "B" && !blueTransporter.isEmpty() || (turnLetter == "G" && !greenTransporter.isEmpty()))
                        {
                            if (gameBoard[0][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] != empty)
                            {
                                if (gameBoard[0][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1].contains(invTurnLetter))
                                {
                                    int boardAmount = 0;
                                    int selectAmount = 0;

                                    for (int i = 0; i < 4; i++)
                                    {
                                        if (gameBoard[i][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] != empty)
                                            boardAmount++;
                                    }

                                    selectAmount = inputArray[inputRead + 3];

                                    if (selectAmount <= boardAmount)
                                    {
                                        int finalXPos = 0;
                                        int finalYPos = 0;
                                        int distanceSum = 0;
                                        int newDistanceSum = 8;
                                        int distanceX = 0;
                                        int distanceY = 0;
                                        int newDistanceX = 0;
                                        int newDistanceY = 0;
                                        boolean transported = false;


                                        while (true)
                                        {
                                            for (int i = 1; i < 5; i++)
                                            {
                                                for (int j = 1; j < 5; j++)
                                                {
                                                    if (gameBoard[0][i][2 * j - 1].equals(empty))
                                                    {
                                                        newDistanceX = Math.abs(inputArray[inputRead + 2] - j);
                                                        newDistanceY = Math.abs(inputArray[inputRead + 1] - i);
                                                        distanceSum = newDistanceSum;
                                                        newDistanceSum = newDistanceX + newDistanceY;

                                                        if (gameBoard[0][i][2 * j - 1].equals(empty))
                                                        {
                                                            if (newDistanceSum < distanceSum)
                                                            {
                                                                finalXPos = 2 * j - 1;
                                                                finalYPos = i;
                                                                transported = true;
                                                                break;
                                                            }
                                                            else if (newDistanceSum > distanceSum)
                                                            {
                                                                newDistanceSum = distanceSum;
                                                            }

                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }


                                        if (transported)
                                        {
                                            for (int i = 0; i < selectAmount; i++)
                                            {
                                                gameBoard[i][finalYPos][finalXPos] = gameBoard[i][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1];
                                            }
                                            for (int i = 0; i < selectAmount; i++)
                                            {
                                                for (int j = 0; j < 3; j++)
                                                {
                                                    gameBoard[j][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] = gameBoard[j + 1][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1];
                                                }
                                                gameBoard[3][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] = "__";
                                            }
                                        }
                                    }
                                    else if (selectAmount > boardAmount)
                                    {
                                        invalid++;
                                    }
                                }
                                else if (gameBoard[0][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1].contains(turnLetter))
                                {
                                    invalid++;
                                }
                            }
                        }

                        else
                        {
                            invalid++;
                        }

                        if (turnLetter == "B")
                        {
                            if (!blueTransporter.isEmpty())
                            {
                                blueTransporter.pop();
                            }
                        }
                        else if (turnLetter == "G")
                        {
                            if (!greenTransporter.isEmpty())
                            {
                                greenTransporter.pop();
                            }
                        }

                        inputRead = inputRead + 4;
                    }

                    else if (inputArrayString[stringRead].contains("S"))
                    {
                        if (turnLetter == "B" && !blueShifter.isEmpty() || (turnLetter == "G" && !greenShifter.isEmpty()))
                        {
                            if (gameBoard[0][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] == empty)
                            {
                                int left = -2;
                                int right = 2;
                                int up = -1;
                                int down = 1;

                                if (inputArray[inputRead + 2] == 1)
                                {
                                    left = 6;
                                }

                                if (inputArray[inputRead + 2] == 4)
                                {
                                    right = -6;
                                }

                                if (inputArray[inputRead + 1] == 1)
                                {
                                    up = 3;
                                }

                                if (inputArray[inputRead + 1] == 4)
                                {
                                    down = -3;
                                }
                                //clockwise
                                if (inputArray[inputRead + 3] == 0)
                                {
                                    for (int i = 0; i < 4; i++)
                                    {
                                        String finalPiece = "";
                                        finalPiece = gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + right];
                                        gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + right] = gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1)];
                                        gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1)] = gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + left];
                                        gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + left] = gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + left];
                                        gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + left] = gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + left];
                                        gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + left] = gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1)];
                                        gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1)] = gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + right];
                                        gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + right] = gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + right];
                                        gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + right] = finalPiece;
                                    }
                                }
                                //anti-clockwise
                                else if (inputArray[inputRead + 3] == 1)
                                {
                                    for (int i = 0; i < 4; i++)
                                    {
                                        String finalPiece = "";
                                        finalPiece = gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + right];
                                        gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + right] = gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + right];
                                        gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + right] = gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + right];
                                        gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + right] = gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1)];
                                        gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1)] = gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + left];
                                        gameBoard[i][inputArray[inputRead + 1] + down][(2 * inputArray[inputRead + 2] - 1) + left] = gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + left];
                                        gameBoard[i][inputArray[inputRead + 1]][(2 * inputArray[inputRead + 2] - 1) + left] = gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + left];
                                        gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1) + left] = gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1)];
                                        gameBoard[i][inputArray[inputRead + 1] + up][(2 * inputArray[inputRead + 2] - 1)] = finalPiece;
                                    }
                                }

                                if (turnLetter == "B")
                                {
                                    if (!blueShifter.isEmpty())
                                    {
                                        blueShifter.pop();
                                    }
                                }
                                else if (turnLetter == "G")
                                {
                                    if (!greenShifter.isEmpty())
                                    {
                                        greenShifter.pop();
                                    }
                                }
                            }
                            else if (gameBoard[0][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] != empty)
                            {
                                invalid++;
                            }
                        }
                        else
                        {
                            invalid++;
                        }

                        inputRead = inputRead + 4;
                    }

                    else if (inputArrayString[stringRead].contains("B"))
                    {
                            int left = -2;
                            int right = 2;
                            int up = -1;
                            int down = 1;

                            if (inputArray[inputRead + 2] == 1)
                            {
                                left = 6;
                            }

                            if (inputArray[inputRead + 2] == 4)
                            {
                                right = -6;
                            }

                            if (inputArray[inputRead + 1] == 1)
                            {
                                up = 3;
                            }

                            if (inputArray[inputRead + 1] == 4)
                            {
                                down = -3;
                            }

                        if (gameBoard[0][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1].contains(turnLetter))
                        {

                            int boardAmount = 0;

                            for (int i = 0; i < 4; i++)
                            {
                                if (gameBoard[i][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] != empty)
                                    boardAmount++;
                            }
                            for (int i = 0; i < boardAmount; i++)
                            {

                            }
                            for (int i = 0; i < boardAmount; i++)
                            {
                                tempStack.push(gameBoard[0][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1]);
                                for (int j = 0; j < 3; j++)
                                {
                                    gameBoard[j][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] = gameBoard[j + 1][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1];
                                }
                                gameBoard[3][inputArray[inputRead + 1]][2 * inputArray[inputRead + 2] - 1] = "__";
                            }

                            int upDown = 0;
                            int leftRight = 0;
                            for (int i = 0; i < 8; i++)
                            {

                                if (i == 0)
                                {
                                    leftRight = left;
                                    upDown = up;
                                }
                                else if (i == 1)
                                {
                                    leftRight = 0;
                                    upDown = up;
                                }
                                else if (i == 2)
                                {
                                    leftRight = right;
                                    upDown = up;
                                }
                                else if (i == 3)
                                {
                                    leftRight = right;
                                    upDown = 0;
                                }
                                else if (i == 4)
                                {
                                    leftRight = right;
                                    upDown = down;
                                }
                                else if (i == 5)
                                {
                                    leftRight = 0;
                                    upDown = down;
                                }
                                else if (i == 6)
                                {
                                    leftRight = left;
                                    upDown = down;
                                }
                                else if (i == 7)
                                {
                                    leftRight = left;
                                    upDown = 0;
                                }

                                if (gameBoard[0][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight].contains(empty) || gameBoard[0][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight] == "SH")
                                {
                                    gameBoard[0][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight] = "SH";
                                }
                                else if (!gameBoard[0][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight].contains(empty))
                                {
                                    tempStack.push(gameBoard[0][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight]);
                                    for (int j = 0; j < 3; j++)
                                    {
                                        gameBoard[j][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight] = gameBoard[j + 1][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight];
                                    }
                                    gameBoard[3][inputArray[inputRead + 1] + upDown][(2 * inputArray[inputRead + 2] - 1) + leftRight] = "__";
                                }

                            }

                        }
                        else
                        {
                            invalid++;
                        }

                        if (turnLetter == "B")
                        {
                            if (!blueBomb.isEmpty())
                            {
                                blueBomb.pop();
                            }
                        }
                        else if (turnLetter == "G")
                        {
                            if (!greenBomb.isEmpty())
                            {
                                greenBomb.pop();
                            }
                        }
                        inputRead = inputRead + 3;
                    }

                    else if (inputArrayString[stringRead].contains("P"))
                    {
                        if (turnLetter == "B")
                        {
                            bluePaintbrush.pop();
                        }
                        else if (turnLetter == "G")
                        {
                            greenPaintbrush.pop();
                        }
                        paintDNE++;
                        break;
                    }

                }

                String topPiece = "";
                while (!tempStack.isEmpty())
                {
                    boolean BS1DoesContain = false;
                    boolean BS2DoesContain = false;
                    boolean BS3DoesContain = false;
                    boolean GS1DoesContain = false;
                    boolean GS2DoesContain = false;
                    boolean GS3DoesContain = false;
                    topPiece = tempStack.peek().toString();
                    tempStack.pop();

                    if (topPiece.contains("B"))
                    {
                        //Stack 1
                        for (int i = 0; i < 4; i++)
                        {
                            if (externalStack[0][0][i].contains(topPiece))
                            {
                                BS1DoesContain = true;
                            }
                        }
                        if (!BS1DoesContain)
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                externalStack[0][0][i] = externalStack[0][0][i - 1];
                            }
                            externalStack[0][0][0] = topPiece;
                            topPiece = "";
                        }

                        //Stack 2
                        for (int i = 0; i < 4; i++)
                        {
                            if (externalStack[0][1][i].contains(topPiece))
                            {
                                BS2DoesContain = true;
                            }
                        }
                        if (!BS2DoesContain)
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                externalStack[0][1][i] = externalStack[0][1][i - 1];
                            }
                            externalStack[0][1][0] = topPiece;
                            topPiece = "";
                        }

                        //Stack 3
                        for (int i = 0; i < 4; i++)
                        {
                            if (externalStack[0][2][i].contains(topPiece))
                            {
                                BS3DoesContain = true;
                            }
                        }
                        if (!BS3DoesContain)
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                externalStack[0][2][i] = externalStack[0][2][i - 1];
                            }
                            externalStack[0][2][0] = topPiece;
                            topPiece = "";
                        }
                    }
                    else if (topPiece.contains("G"))
                    {
                        //Stack 1
                        for (int i = 0; i < 4; i++)
                        {
                            if (externalStack[1][0][i].contains(topPiece))
                            {
                                GS1DoesContain = true;
                            }
                        }
                        if (!GS1DoesContain)
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                externalStack[1][0][i] = externalStack[1][0][i - 1];
                            }
                            externalStack[1][0][0] = topPiece;
                            topPiece = "";
                        }
                        //Stack 2
                        for (int i = 0; i < 4; i++)
                        {
                            if (externalStack[1][1][i].contains(topPiece))
                            {
                                GS2DoesContain = true;
                            }
                        }
                        if (!GS2DoesContain)
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                externalStack[1][1][i] = externalStack[1][1][i - 1];
                            }
                            externalStack[1][1][0] = topPiece;
                            topPiece = "";
                        }

                        //Stack 3
                        for (int i = 0; i < 4; i++)
                        {
                            if (externalStack[1][2][i].contains(topPiece))
                            {
                                GS3DoesContain = true;
                            }
                        }
                        if (!GS3DoesContain)
                        {
                            for (int i = 3; i > 0; i--)
                            {
                                externalStack[1][2][i] = externalStack[1][2][i - 1];
                            }
                            externalStack[1][2][0] = topPiece;
                            topPiece = "";
                        }
                    }

                }

                //External Stack Array Rearrange
                String temp;
                for (int i = 0; i < 2; i++)
                {
                    for (int j = 0; j < 3; j++)
                    {
                        for (int k = 0; k < 3; k++)
                        {
                            int a = 0;
                            if(!externalStack[i][j][k + 1].equals(""))
                            {
                                a = Integer.parseInt(externalStack[i][j][k].substring(1));
                            }
                            int b = 0;
                            if(!externalStack[i][j][k + 1].equals(""))
                            {
                                b = Integer.parseInt(externalStack[i][j][k + 1].substring(1));
                            }
                            if(a > b)
                            {
                                temp = externalStack[i][j][k];
                                externalStack[i][j][k] = externalStack[i][j][k + 1];
                                externalStack[i][j][k + 1] = temp;
                                k=-1;
                            }
                        }
                    }
                }

                //Game Board Print
                if (invalid == 0)
                {
                    for (int j = 0; j < ARRWIDTH; j++)
                    {
                        for (int z = 0; z < ARRHEIGHT; z++)
                        {
                            System.out.print(gameBoard[0][j][z] + "");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                turn = turn + 1;

                // Blue Vertical Check
                for (int i = 1; i < 4; i++)
                {
                    int bVerCount = 0;
                    for (int j = 1; j < 5; j++)
                    {
                        int k = 2 * i - 1;
                        if (gameBoard[0][j][k].contains("B"))
                        {
                            bVerCount++;
                        }
                        if (bVerCount == 4)
                        {
                            blueWin++;
                        }
                    }
                    bVerCount = 0;
                }

                // Blue Horizontal Check
                for (int i = 1; i < 4; i++)
                {
                    int bHorCount = 0;
                    for (int j = 1; j < 5; j++)
                    {
                        int k = 2 * j - 1;
                        if (gameBoard[0][i][k].contains("B"))
                        {
                            bHorCount++;
                        }
                        if (bHorCount == 4)
                        {
                            blueWin++;
                        }
                    }
                    bHorCount = 0;
                }

                // Blue Diagonal Check
                int bDiagCount1 = 0;
                for (int i = 1; i < 5; i++)
                {
                    int j = 2 * i - 1;
                    if (gameBoard[0][i][j].contains("B"))
                    {
                        bDiagCount1++;
                    }
                    if (bDiagCount1 == 4)
                    {
                        blueWin++;
                    }
                }
                int bDiagCount2 = 0;
                for (int i = 1; i < 5; i++)
                {
                    int j = 9 - 2 * i;
                    if (gameBoard[0][i][j].contains("B"))
                    {
                        bDiagCount2++;
                    }
                    if (bDiagCount2 == 4)
                    {
                        blueWin++;
                    }
                }

                // Green Vertical Check
                for (int i = 1; i < 4; i++)
                {
                    int gVerCount = 0;
                    for (int j = 1; j < 5; j++)
                    {
                        int k = 2 * i - 1;
                        if (gameBoard[0][j][k].contains("G"))
                        {
                            gVerCount++;
                        }
                        if (gVerCount == 4)
                        {
                            greenWin++;
                        }
                    }
                    gVerCount = 0;
                }

                // Green Horizontal Check
                for (int i = 1; i < 4; i++)
                {
                    int gHorCount = 0;
                    for (int j = 1; j < 5; j++)
                    {
                        int k = 2 * j - 1;
                        if (gameBoard[0][i][k].contains("G"))
                        {
                            gHorCount++;
                        }
                        if (gHorCount == 4)
                        {
                            greenWin++;
                        }
                    }
                    gHorCount = 0;
                }

                // Green Diagonal Check
                int gDiagCount1 = 0;
                for (int i = 1; i < 5; i++)
                {
                    int j = 2 * i - 1;
                    if (gameBoard[0][i][j].contains("G"))
                    {
                        gDiagCount1++;
                    }
                    if (gDiagCount1 == 4)
                    {
                        greenWin++;
                    }
                }

                int gDiagCount2 = 0;
                for (int i = 1; i < 5; i++)
                {
                    int j = 2 * i - 1;
                    if (gameBoard[0][i][j].contains("G"))
                    {
                        gDiagCount2++;
                    }
                    if (gDiagCount2 == 4)
                    {
                        greenWin++;
                    }
                }

                // Win or Quit condition check
                if (quit == 1)
                {
                    System.out.println("Quit");
                    break;
                }
                else if ((blueWin >= 1) && (greenWin >= 1))
                {
                    System.out.println("Draw!");
                    break;
                }
                else if (blueWin >= 1)
                {
                    System.out.println("Blue wins!");
                    break;
                }
                else if (greenWin >= 1)
                {
                    System.out.println("Green wins!");
                    break;
                }
                else if (invalid == 1)
                {
                    System.out.println("Invalid move");
                    invalid--;
                }
            }

            if (paintDNE == 1)
            {
                System.out.println("Paint function not implemented");
                System.out.println();
                paintDNE--;
            }

            // End of input file check
            if ((blueWin == 0) && (greenWin == 0) && (quit == 0))
            {
                System.out.println("No winner, input file ended");
            }


            // Pieces On Board Statistics
            System.out.println("Statistics for each stack present on the board");
            for (int i = 1; i < 5; i++)
            {
                for (int j = 1; j < 5; j++)
                {
                    int k = 2 * j - 1;
                    if (gameBoard[0][i][k] != empty && gameBoard[0][i][k] != "SH")
                    {
                        System.out.print(gameBoard[0][i][k] + " ");
                        if (gameBoard[1][i][2 * j - 1] != empty)
                        {
                            System.out.print(gameBoard[1][i][k] + " ");
                        }
                        if (gameBoard[2][i][2 * j - 1] != empty)
                        {
                            System.out.print(gameBoard[2][i][k] + " ");
                        }
                        if (gameBoard[3][i][2 * j - 1] != empty)
                        {
                            System.out.print(gameBoard[3][i][k] + " ");
                        }
                        System.out.println();
                    }
                }
            }


            //External Stack Statistics
            int rows = 3;
            int columns = 4;


            System.out.println("Statistics external stacks blue player");
            for (int i = 0; i < rows; i++)
            {
                System.out.print("Stack " + (i + 1) + ": ");
                for (int j = 0; j < columns; j++)
                {
                    System.out.print(externalStack[0][i][j] + " ");
                }
                System.out.println();
            }


            System.out.println("Statistics external stacks green player");
            for (int i = 0; i < rows; i++)
            {
                System.out.print("Stack " + (i + 1) + ": ");
                for (int j = 0; j < columns; j++)
                {
                    System.out.print(externalStack[1][i][j] + " ");
                }
                System.out.println();
            }

        }

        else
        {
            System.out.println("Incorrect number of command line arguments provided");
            System.exit(0);
        }
    }
}


