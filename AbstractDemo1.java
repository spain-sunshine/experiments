// 抽象类 Shape，代表一个形状
abstract class Shape {
    // 抽象方法 getArea，用于计算形状的面积
    // 子类必须提供此方法的实现
    public abstract double getArea();

    // 抽象方法 getPerimeter，用于计算形状的周长
    // 子类必须提供此方法的实现
    public abstract double getPerimeter();
}

// Circle类，继承自Shape
class Circle extends Shape {
    private double radius;  // 圆的半径

    public Circle(double radius) {
        this.radius = radius;
    }

    // 提供getArea方法的具体实现
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // 提供getPerimeter方法的具体实现
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle类，继承自Shape
class Rectangle extends Shape {
    private double width, height;  // 矩形的宽和高

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 提供getArea方法的具体实现
    @Override
    public double getArea() {
        return width * height;
    }

    // 提供getPerimeter方法的具体实现
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

public class AbstractDemo1 {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Circle area: " + circle.getArea());        // 输出圆的面积
        System.out.println("Circle perimeter: " + circle.getPerimeter()); // 输出圆的周长

        Rectangle rectangle = new Rectangle(4, 7);
        System.out.println("Rectangle area: " + rectangle.getArea());      // 输出矩形的面积
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter()); // 输出矩形的周长
    }
}
