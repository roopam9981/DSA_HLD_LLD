package DesignPattern.FactoryDesignPattern;


// yaha sabse pehele humne Shapw interface banaya then uski Implemented class Circle ans Squre
// but we want ki inimplemented class ka object kisii condition per hi create ho
//so humne 1 factory  class banai  jisme humne 1 method bani jiska return tyoe interface class ho ,
// vaha oer humne swithc case laga ker condition put kari ki return kerna object of child classes on some constion;
//and we call the method of that child class at main method.
public class MainClass {
public static void main (String [] args){
    ShapeFactory shapeFactoryObjt = new ShapeFactory();
    Shape shape =shapeFactoryObjt.getShape("Circle");
    shape.draw();
}
}
