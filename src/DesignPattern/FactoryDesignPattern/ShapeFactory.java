package DesignPattern.FactoryDesignPattern;

public class ShapeFactory {
Shape getShape(String input){

    switch (input){
        case "Circle":
        return new Circle();

        case "Squre":
        return new Squre();

        default:
            return null;
    }
}
}
