package com.chelkatrao;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetAndRead {

    private int[] bestPointTop;
    private int[] bestPointRight;
    private int[] bestPointBottom;
    private int[] bestPointLeft;

    public int[] getBestPointTop() {
        return bestPointTop;
    }

    public void setBestPointTop(int[] bestPointTop) {
        this.bestPointTop = bestPointTop;
    }

    public int[] getBestPointRight() {
        return bestPointRight;
    }

    public void setBestPointRight(int[] bestPointRight) {
        this.bestPointRight = bestPointRight;
    }

    public int[] getBestPointLeft() {
        return bestPointLeft;
    }

    public void setBestPointLeft(int[] bestPointLeft) {
        this.bestPointLeft = bestPointLeft;
    }

    public int[] getBestPointBottom() {
        return bestPointBottom;
    }

    public void setBestPointBottom(int[] bestPointBottom) {
        this.bestPointBottom = bestPointBottom;
    }

    public static Color[][] loadPixelsFromImage(File file) throws IOException {

        BufferedImage image = ImageIO.read(file);
        Color[][] colors = new Color[image.getWidth()][image.getHeight()];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                colors[x][y] = new Color(image.getRGB(x, y));
            }
        }
        return colors;
    }

    public void getPosition() throws IOException {
        Color[][] colors = loadPixelsFromImage(new File("image.png"));
        int[] asColorPointTop = new int[100];
        int sanoqColorTop = 0;
        //      tepadan pastga qarab(1)
        M:
        for (int i = 0; i < 700; i++) {
            for (int j = 0; j < 600; j++) {
                if ((colors[i][j].getRGB() == Color.WHITE.getRGB()) ||
                        (colors[i][j].getRGB() == Color.RED.getRGB())) {
                    if ((colors[i][j].getRGB() == Color.RED.getRGB())) {
                        asColorPointTop[sanoqColorTop++] = i;
                        asColorPointTop[sanoqColorTop++] = j;
                        System.out.println(i + " : " + j);
                    }
                    continue M;
                }
            }
        }
        setBestPointTop(asColorPointTop);

        //      o'ngdan chapga qarab(2)
        int[] asColorPointRight = new int[100];
        int sanoqColorRight = 0;
        M:
        for (int i = 599; i > 0; i--) {
            for (int j = 699; j > 0; j--) {
                if ((colors[j][i].getRGB() == Color.WHITE.getRGB()) ||
                        (colors[j][i].getRGB() == Color.RED.getRGB())) {
                    if ((colors[j][i].getRGB() == Color.RED.getRGB())) {
                        asColorPointRight[sanoqColorRight++] = j;
                        asColorPointRight[sanoqColorRight++] = i;
                        System.out.println(j + " : " + i);
                    }
                    continue M;
                }
            }
        }
        setBestPointRight(asColorPointRight);
        //      pastdan tepaga qaratib(3)
        int[] asColorPointBottom = new int[100];
        int sanoqColorBottom = 0;
        M:
        for (int i = 0; i < 700; i++) {
            for (int j = 599; j > 0; --j) {
                if ((colors[i][j].getRGB() == Color.WHITE.getRGB()) ||
                        (colors[i][j].getRGB() == Color.RED.getRGB())) {
                    if ((colors[i][j].getRGB() == Color.RED.getRGB())) {
                        asColorPointBottom[sanoqColorBottom++] = i;
                        asColorPointBottom[sanoqColorBottom++] = j;
                        System.out.println(i + " : " + j);
                    }
                    continue M;
                }
            }
        }
        setBestPointBottom(asColorPointBottom);
        //      chapdan o'nga qarab (4)
        int[] asColorPointLeft = new int[100];
        int sanoqColorLeft = 0;
        M:
        for (int i = 0; i < 600; i++) {
            for (int j = 0; j < 700; j++) {
                if ((colors[j][i].getRGB() == Color.WHITE.getRGB()) ||
                        (colors[j][i].getRGB() == Color.RED.getRGB())) {
                    if ((colors[j][i].getRGB() == Color.RED.getRGB())) {
                        asColorPointLeft[sanoqColorLeft++] = j;
                        asColorPointLeft[sanoqColorLeft++] = i;
                        System.out.println(j + " : " + i);
                    }
                    continue M;
                }
            }
        }
        setBestPointLeft(asColorPointLeft);
    }
}
