package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Dasha");

    Square s = new Square(5);
    System.out.println("Площадь квандата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + "  = " + r.area());

    Point p = new Point(3,10);
    System.out.println("Расстояние между двумя точками " + p.p2 +" и "+ p.p1 +" = "+ p.distance());

  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody + "!");
  }

}