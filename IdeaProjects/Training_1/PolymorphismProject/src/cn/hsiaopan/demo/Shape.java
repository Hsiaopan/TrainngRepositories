package cn.hsiaopan.demo;

class Shape {
    void draw(){}
}

class Circle extends Shape{
    @Override
    void draw() {
        System.out.println("Circle.draw");
    }
}

class Square extends Shape{
    @Override
    void draw() {
        System.out.println("Square.draw");
    }
}

class Triangle extends Shape{
    @Override
    void draw() {
        System.out.println("Triangle.draw");
    }
}