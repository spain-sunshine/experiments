interface IShape{
    double getArea();
    double getPerimeter();
}
class Circle implements IShape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
}
class Rectangle implements IShape{
    private double width, height;
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return width * height;
    }
    public double getPerimeter(){
        return 2 * (width + height);
    }
}

public class AbstractDemo2 {
    public static void main(String args){
        IShape circle = new Circle(5);
        System.out.println("Circle area: " + circle.getArea());        // 输出圆的面积
        System.out.println("Circle perimeter: " + circle.getPerimeter()); // 输出圆的周长

        IShape rectangle = new Rectangle(4, 7);
        System.out.println("Rectangle area: " + rectangle.getArea());      // 输出矩形的面积
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter()); // 输出矩形的周长
    }
}
