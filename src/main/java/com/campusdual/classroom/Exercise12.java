package com.campusdual.classroom;

public class Exercise12 {
    public static void main(String[] args) {
        Car lambo = new Car("Lamborghini", "Diablo", "Gasolina");
        //Un metodo booleano que verifique si el valor del tacómetro es cero
        //Encender el coche comprobando el valor correcto del tacómetro (investigar cuál es el valor correcto)
        lambo.start();
        //Encender el coche cuando ya está encendido (comprobar que no se puede encender si ya está encendido)
        lambo.start();
        //Apagar el coche comprobando que el valor del tacómetro es correcto
        lambo.stop();
        //Apagar el coche mientras todavía está en movimiento (y comprobar que no se puede)
        lambo.start();
        lambo.accelerate();
        lambo.stop();
        //Acelerar el coche
        lambo.accelerate();
        //Acelerar hasta intentar superar la velocidad máxima (y comprobar que no se puede)
        while (lambo.getSpeedometer() != Car.MAX_SPEED) {
            lambo.accelerate();
        }
        lambo.accelerate();
        //Frenar la velocidad
        do{
            lambo.brake();
        }while(lambo.getSpeedometer() > 0)
        ;
        //Frenar hasta un valor negativo (y comprobar que no se puede)
        lambo.brake();
        //Girar el volante 20 grados
        lambo.turnAngleOfWheels(20);
        //Girar el volante más de 45 grados ó -45 grados (y comprobar que no se puede)
        lambo.turnAngleOfWheels(30);
        //Detener el coche y poner marcha atrás
        lambo.brake();
        lambo.setReverse(true);
        //Poner marcha atrás mientras el coche está en movimiento marcha adelante (y comprobar que no se puede)
        lambo.setReverse(false);
        lambo.accelerate();
        lambo.setReverse(true);

        lambo.showDetails();
    }

}