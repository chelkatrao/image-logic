package com.chelkatrao;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Center extends Canvas {

    public static SaveImage saveImage = new SaveImage();

    public static GetAndRead getAndRead = new GetAndRead();

    private int[] retRandom = saveImage.getReturnRandom();

    private int[] bestPointTop = getAndRead.getBestPointTop();

    private int[] bestPointRight = getAndRead.getBestPointRight();

    private int[] bestPointBottom = getAndRead.getBestPointBottom();

    private int[] bestPointLeft = getAndRead.getBestPointLeft();

    public void paint(Graphics g) {
        int aTop = 0;
        for (int i = 0; i < bestPointTop.length; i++) {
            if (aTop != 0) {
                aTop = aTop - 2;
            }
            int x1 = bestPointTop[aTop++];
            int y1 = bestPointTop[aTop++];
            int x2 = bestPointTop[aTop++];
            int y2 = bestPointTop[aTop++];

            if (bestPointTop[i] == 0) {
                break;
            }
            g.setColor(Color.BLACK);
            if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0)
                g.drawLine(x1, y1, x2, y2);
        }
        int aRight = 0;
        for (int i = 0; i < bestPointRight.length; i++) {
            if (aRight != 0) {
                aRight = aRight - 2;
            }
            int x1 = bestPointRight[aRight++];
            int y1 = bestPointRight[aRight++];
            int x2 = bestPointRight[aRight++];
            int y2 = bestPointRight[aRight++];

            if (bestPointRight[i] == 0) {
                break;
            }
            g.setColor(Color.BLACK);
            if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0)
                g.drawLine(x1, y1, x2, y2);
        }
        int aBottom = 0;
        for (int i = 0; i < bestPointBottom.length; i++) {
            if (aBottom != 0) {
                aBottom = aBottom - 2;
            }
            int x1 = bestPointBottom[aBottom++];
            int y1 = bestPointBottom[aBottom++];
            int x2 = bestPointBottom[aBottom++];
            int y2 = bestPointBottom[aBottom++];

            if (bestPointBottom[i] == 0) {
                break;
            }
            g.setColor(Color.BLACK);
            if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0)
                g.drawLine(x1, y1, x2, y2);
        }
        int aLeft = 0;
        for (int i = 0; i < bestPointLeft.length; i++) {
            if (aLeft != 0) {
                aLeft = aLeft - 2;
            }
            int x1 = bestPointLeft[aLeft++];
            int y1 = bestPointLeft[aLeft++];
            int x2 = bestPointLeft[aLeft++];
            int y2 = bestPointLeft[aLeft++];

            if (bestPointLeft[i] == 0) {
                break;
            }
            g.setColor(Color.BLACK);
            if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0)
                g.drawLine(x1, y1, x2, y2);
        }
        int b = 0;
        for (int i = 0; i < 20; i++) {
            g.setColor(Color.RED);
            int x = retRandom[b++];
            int y = retRandom[b++];
            g.drawLine(x, y, x, y);
            g.drawLine(x + 1, y, x, y - 1);
            g.drawLine(x, y - 1, x - 1, y);
            g.drawLine(x, y, x - 1, y - 1);
            g.drawLine(x + 1, y, x, y + 1);
            g.drawLine(x + 1, y - 1, x - 1, y + 1);
            g.drawLine(x + 1, y + 1, x, y);
            g.drawLine(x - 1, y - 1, x - 1, y - 1);
            g.drawLine(x + 1, y + 1, x + 1, y + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        saveImage.setPosition();
        getAndRead.getPosition();

        Center center = new Center();
        JFrame f = new JFrame();
        f.add(center);
        f.setSize(700, 600);
        f.setVisible(true);
    }
}
