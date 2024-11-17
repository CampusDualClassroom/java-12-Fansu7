package com.campusdual.classroom;

public class Car {
  public static final int MAX_SPEED = 120;

  public String brand;
  public String model;
  public String fuel;
  public int speedometer = 0;
  public int tachometer = 0;
  public String gear = "N";
  public boolean reverse = false;
  public int wheelsAngle = 0;

  public Car() {
  }

  public Car(String brand, String model, String fuel) {
    this.brand = brand;
    this.model = model;
    this.fuel = fuel;
  }

  public int getTachometer() {
    return this.tachometer;
  }

  public int getSpeedometer() {
    return this.speedometer;
  }

  public void start() {
    if (this.getTachometer() == 0) {
      setTachometer(1000);
      System.out.println("Vehículo encendido");
    } else {
      System.out.println("El vehículo ya está encendido");
    }
  }

  public void stop() {
    if (this.speedometer == 0) {
      setTachometer(0);
      System.out.println("Vehículo apagado");
    } else {
      System.out.println("No se puede apagar el vehículo, primero tiene que estar detenido");
    }
  }

  public void accelerate() {
    if (this.speedometer == Car.MAX_SPEED) {
      System.out.println("Velocidade máxima alcanzada");
    } else {
      if (this.isReverse() && this.speedometer == 25) {
        System.out.println("O vehículo non pode ir a máis velocidade marcha atrás.");
      } else {
        this.speedometer += 5;
        System.out.println("A nova velocidade é " + this.speedometer);
      }
    }
  }

  public void brake() {
    if (this.speedometer == 0) {
      System.out.println("O vehículo xa está detido");
    } else {
      this.speedometer -= 5;
      System.out.println("A nova velocidade é " + this.speedometer);
    }
  }

  public void turnAngleOfWheels(int angle) {
    //0 -> posición central
    //+45 -> máximo giro a la derecha
    //-45 -> máximo giro a la izquierda
//    if (this.wheelsAngle < 45 && this.wheelsAngle > -45) {
    if (this.wheelsAngle + angle > 45) {
      this.wheelsAngle = 45;
    } else if (this.wheelsAngle + angle < -45) {
      this.wheelsAngle = -45;
    } else {
      this.wheelsAngle = angle;
    }
//    } else {
//      System.out.println("O volante non pode xirar máis. Xa está ao máximo de xiro.");
//    }
  }

  public String showSteeringWheelDetail() {
    StringBuilder builder = new StringBuilder();
    builder.append("O volante está ");

    if (this.wheelsAngle == 0) {
      builder.append("no centro.");
    } else if (this.wheelsAngle > 0) {
      builder.append("xirado á dereita.");
    } else {
      builder.append("xirado á esquerda.");
    }
    builder.append(" O ángulo de xiro do volante é " + this.wheelsAngle);

    return builder.toString();
  }

  //Comprueba que el tacometro sea 0 o no.
  public boolean isTachometerGreaterThanZero() {
    return this.getTachometer() > 0;
  }

  public boolean isTachometerEqualToZero() {
    return this.getTachometer() == 0;
  }

  private boolean isReverse() {
    return this.reverse;
  }

  public void setTachometer(int tachometer) {
    this.tachometer = tachometer;
  }

  public void setReverse(boolean reverse) {
    if (this.isTachometerGreaterThanZero() && this.getSpeedometer() == 0) {
      if (this.isReverse() == reverse) {
        System.out.println("O vehículo xa ten esa marcha indicada.");
      } else {
        this.reverse = reverse;
      }
    } else {
      System.out.println("O vehiculo ten que estar detido para cambiar entre reverse e adiante");
    }

    if (this.isReverse()) {
      this.gear = "R";
    } else {
      this.gear = "N";
      System.out.println("Punto morto ou adiante");
    }
    System.out.println("A marcha engranada e " + this.gear);
  }//setReverse()

  public void showDetails() {
    StringBuilder builder = new StringBuilder();
    builder.append("O coche marca ");
    builder.append(this.brand);
    builder.append(" modelo ");
    builder.append(this.model);
    builder.append(" ten unha velocidade de ");
    builder.append(this.speedometer);
    builder.append(".\nO tacógrafo marca ");
    builder.append(this.tachometer);
    builder.append(". O sentido da marcha é ");
    builder.append(this.gear);
    builder.append(". O ángulo de xiro do volante é ");
    builder.append(this.wheelsAngle);
    builder.append(".");
    System.out.println(builder.toString());
  }
}
