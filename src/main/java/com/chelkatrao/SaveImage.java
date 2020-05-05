package com.chelkatrao;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class SaveImage {

    private int[] returnRandom;

    public int[] getReturnRandom() {
        return returnRandom;
    }

    public void setReturnRandom(int[] returnRandom) {
        this.returnRandom = returnRandom;
    }

    public void setPosition() throws IOException {
        int witdh = 700;
        int height = 600;

        BufferedImage buffImg = new BufferedImage(witdh, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = buffImg.createGraphics();

        Random random = new Random();
        int[] mas = new int[1000];
        int countMass = 0;

        for (int i = 0; i < 10; i++) {
            int x1 = 50 + random.nextInt(500);
            mas[countMass] = x1;
            countMass++;
            int y1 = 50 + random.nextInt(500);
            mas[countMass] = y1;
            countMass++;
            g2d.setColor(Color.WHITE);
            g2d.drawLine(x1, y1, x1, y1);
        }
        int vectorX;
        int vectorY;
        for (int i = 0; i < 20; i++) {
            int lift1 = mas[i];
            int lift2 = mas[++i];
            for (int j = 0; j < 20; j++) {
                vectorX = mas[j];
                vectorY = mas[++j];
                g2d.drawLine(lift1, lift2, vectorX, vectorY);
                g2d.setColor(Color.WHITE);
            }
        }
        int countSon = 0;
        for (int i = 0; i < 10; i++) {
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

        setReturnRandom(mas);
    }
}
