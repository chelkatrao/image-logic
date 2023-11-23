package com.chelkatrao;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import static com.chelkatrao.ApplicationRunner.*;

public class DrawImageService {

    private int[] returnRandom;

    public void drawFile() throws IOException {
        BufferedImage buffImg = new BufferedImage(WIDTH,
                                                  HEIGHT,
                                                  BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = buffImg.createGraphics();

        Random random = new Random();
        int[] mas = new int[10000000];
        int countMass = 0;

        for (int i = 0; i < TOTAL_POINT; i++) {
            int x1 = random.nextInt(WIDTH);

            if (x1 <= (ApplicationRunner.WIDTH / 20)) {
                x1 = x1 + (ApplicationRunner.WIDTH / 20);
            }
            mas[countMass] = x1;
            countMass++;

            int y1 = random.nextInt(HEIGHT);

            if (y1 <= (ApplicationRunner.HEIGHT / 20)) {
                y1 = y1 + (ApplicationRunner.HEIGHT / 20);
            }
            mas[countMass] = y1;
            countMass++;

            g2d.setColor(Color.WHITE);
            g2d.drawLine(x1, y1, x1, y1);
        }
        int vectorX;
        int vectorY;
        for (int i = 0; i < TOTAL_POINT * 2; i++) {
            int lift1 = mas[i];
            int lift2 = mas[++i];
            for (int j = 0; j < TOTAL_POINT * 2; j++) {
                vectorX = mas[j];
                vectorY = mas[++j];

                g2d.drawLine(lift1, lift2, vectorX, vectorY);
                g2d.setColor(Color.WHITE);
            }
        }
        int countSon = 0;
        for (int i = 0; i < TOTAL_POINT; i++) {
            int x = mas[countSon];
            countSon++;

            int y = mas[countSon];
            countSon++;

            g2d.setColor(Color.RED);

            g2d.drawLine(x, y, x, y);
        }

        g2d.dispose();

        File file = new File("image.png");
        ImageIO.write(buffImg, "png", file);

        this.returnRandom = mas;
    }

    public int[] getReturnRandom() {
        return returnRandom;
    }

}
