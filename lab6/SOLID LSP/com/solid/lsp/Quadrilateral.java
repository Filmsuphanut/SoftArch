package com.solid.lsp;

public class Quadrilateral extends Rectangle{

    Quadrilateral(int width, int height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public int getArea() {
        return getWidth() * getHeight();
    }

}
