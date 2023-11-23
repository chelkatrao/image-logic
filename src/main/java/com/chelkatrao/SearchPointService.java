package com.chelkatrao;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SearchPointService {

    private int[] bestPointTop;
    private int[] bestPointRight;
    private int[] bestPointBottom;
    private int[] bestPointLeft;

    public void search() throws IOException {
        Color[][] colors = loadPixelsFromImage(new File("image.png"));

        int countColorTop = 0;
        int[] asColorPointTop = new int[100];

        M:
        for (int i = 0; i < ApplicationRunner.WIDTH; i++) {
            for (int j = 0; j < ApplicationRunner.HEIGHT; j++) {
                if ((colors[i][j].getRGB() == Color.WHITE.getRGB()) || (colors[i][j].getRGB() == Color.RED.getRGB())) {
                    if ((colors[i][j].getRGB() == Color.RED.getRGB())) {
                        asColorPointTop[countColorTop++] = i;
                        asColorPointTop[countColorTop++] = j;
                        System.out.println(i + " : " + j);
                    }
                    continue M;
                }
            }
        }
        this.bestPointTop = asColorPointTop;

        int[] asColorPointRight = new int[100];
        int countColorRight = 0;
        M:
        for (int i = (ApplicationRunner.HEIGHT - 1); i > 0; i--) {
            for (int j = (ApplicationRunner.WIDTH - 1); j > 0; j--) {
                if ((colors[j][i].getRGB() == Color.WHITE.getRGB()) || (colors[j][i].getRGB() == Color.RED.getRGB())) {
                    if ((colors[j][i].getRGB() == Color.RED.getRGB())) {
                        asColorPointRight[countColorRight++] = j;
                        asColorPointRight[countColorRight++] = i;
                        System.out.println(j + " : " + i);
                    }
                    continue M;
                }
            }
        }
        this.bestPointRight = asColorPointRight;

        int[] asColorPointBottom = new int[100];
        int countColorBottom = 0;
        M:
        for (int i = 0; i < ApplicationRunner.WIDTH; i++) {
            for (int j = (ApplicationRunner.HEIGHT - 1); j > 0; --j) {
                if ((colors[i][j].getRGB() == Color.WHITE.getRGB()) ||
                        (colors[i][j].getRGB() == Color.RED.getRGB())) {
                    if ((colors[i][j].getRGB() == Color.RED.getRGB())) {
                        asColorPointBottom[countColorBottom++] = i;
                        asColorPointBottom[countColorBottom++] = j;
                        System.out.println(i + " : " + j);
                    }
                    continue M;
                }
            }
        }
        this.bestPointBottom = asColorPointBottom;

        int[] asColorPointLeft = new int[100];
        int sanoqColorLeft = 0;
        M:
        for (int i = 0; i < ApplicationRunner.HEIGHT; i++) {
            for (int j = 0; j < ApplicationRunner.WIDTH; j++) {
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
        this.bestPointLeft = asColorPointLeft;
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

    public int[] getBestPointTop() {
        return bestPointTop;
    }

    public int[] getBestPointRight() {
        return bestPointRight;
    }

    public int[] getBestPointLeft() {
        return bestPointLeft;
    }

    public int[] getBestPointBottom() {
        return bestPointBottom;
    }

}

