package com.chelkatrao;

import java.io.IOException;

public class ApplicationRunner {

    public final static int WIDTH = 900;
    public final static int HEIGHT = 600;

    /**
     * max TOTAL_POINT should 8000
     */
    public final static int TOTAL_POINT = 1000;

    public static void main(String[] args) throws IOException {
        DrawImageService imageService = new DrawImageService();
        SearchPointService pointService = new SearchPointService();

        imageService.drawFile();
        pointService.search();

        PaintFinalResultService paintFinalResultService = new PaintFinalResultService(imageService.getReturnRandom(),
                                            pointService.getBestPointTop(),
                                            pointService.getBestPointRight(),
                                            pointService.getBestPointBottom(),
                                            pointService.getBestPointLeft());
        paintFinalResultService.build();
    }
}
