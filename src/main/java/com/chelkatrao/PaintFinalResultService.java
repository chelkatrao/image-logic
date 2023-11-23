package com.chelkatrao;

import javax.swing.*;
import java.awt.*;

public class PaintFinalResultService extends Canvas {

    private final int[] retRandom;
    private final int[] pointTop;
    private final int[] pointRight;
    private final int[] pointBottom;
    private final int[] pointLeft;

    public PaintFinalResultService(int[] retRandom,
                                   int[] pointTop,
                                   int[] pointRight,
                                   int[] pointBottom,
                                   int[] pointLeft) {
        super();
        this.retRandom = retRandom;
        this.pointTop = pointTop;
        this.pointRight = pointRight;
        this.pointBottom = pointBottom;
        this.pointLeft = pointLeft;
    }

    public void build() {
        JFrame f = new JFrame();
        f.add(this);
        f.setSize(ApplicationRunner.WIDTH + (ApplicationRunner.WIDTH / 20),
                  ApplicationRunner.HEIGHT + (ApplicationRunner.HEIGHT / 5));
        f.setVisible(true);
    }

    public void paint(Graphics graphics) {
        paintBestPoint(pointLeft, graphics);
        paintBestPoint(pointRight, graphics);
        paintBestPoint(pointTop, graphics);
        paintBestPoint(pointBottom, graphics);
        int b = 0;
        for (int i = 0; i < ApplicationRunner.TOTAL_POINT * 2; i++) {
            int x = retRandom[b++];
            int y = retRandom[b++];
            graphics.drawLine(x, y, x, y);
            graphics.drawLine(x + 1, y, x, y - 1);
            graphics.drawLine(x, y - 1, x - 1, y);
            graphics.drawLine(x, y, x - 1, y - 1);
            graphics.drawLine(x + 1, y, x, y + 1);
            graphics.drawLine(x + 1, y - 1, x - 1, y + 1);
            graphics.drawLine(x + 1, y + 1, x, y);
            graphics.drawLine(x - 1, y - 1, x - 1, y - 1);
            graphics.drawLine(x + 1, y + 1, x + 1, y + 1);

            graphics.setColor(Color.RED);
        }
    }

    private void paintBestPoint(int[] bestPointTop, Graphics g) {
        int aTop = 0;
        for (int k : bestPointTop) {
            if (aTop != 0) aTop = aTop - 2;

            int x1 = bestPointTop[aTop++];
            int y1 = bestPointTop[aTop++];
            int x2 = bestPointTop[aTop++];
            int y2 = bestPointTop[aTop++];

            if (k == 0) break;

            g.setColor(Color.BLACK);
            if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0)
                g.drawLine(x1, y1, x2, y2);
        }
    }

}
