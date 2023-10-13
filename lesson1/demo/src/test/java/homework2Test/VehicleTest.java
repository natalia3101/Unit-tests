package homework2Test;

import org.junit.jupiter.api.Test;

import homework2.Car;
import homework2.Motorcycle;
import homework2.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class VehicleTest {

    private Car car1;
    private Motorcycle motorcycle1;

    @BeforeEach
    public void setUp() {
        car1 = new Car("Toyota", "Camry", 2020);
        motorcycle1 = new Motorcycle("BMW", "M1000", 2018);
    }

    // - Проверить, что экземпляр объекта Car 
    // также является экземпляром транспортного средства (используя оператор instanceof).
    @Test
    public void carIsInstanceOfVehicle() {
        assertTrue(car1 instanceof Vehicle);
    }

    // - Проверить, что объект Car создается с 4-мя колесами.
    @Test
    public void carHasFourWheels() {
        assertTrue(car1.getNumWheels() == 4);
    }

    // - Проверить, что объект Motorcycle создается с 2-мя колесами.
    @Test
    public void motoHasTwoWheels() {
        assertTrue(motorcycle1.getNumWheels() == 2);
    }

    // - Проверить, что объект Car развивает скорость 60 в режиме 
    // тестового вождения (используя метод testDrive()).
    @Test
    public void carSpeedTest() {
        car1.testDrive();
        assertTrue(car1.getSpeed() == 60);
    }

    // - Проверить, что объект Motorcycle развивает скорость 75 в режиме 
    // тестового вождения (используя метод testDrive()).
    @Test
    public void motoSpeedTest() {
        motorcycle1.testDrive();
        assertTrue(motorcycle1.getSpeed() == 75);
    }

    // - Проверить, что в режиме парковки (сначала testDrive, потом park, 
    // т.е. эмуляция движения транспорта) машина останавливается (speed = 0).
    @Test
    public void carStopAfterParking() {
        car1.testDrive();
        car1.park();
        assertTrue(car1.getSpeed() == 0);
    }

    // - Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. 
    // эмуляция движения транспорта) мотоцикл останавливается (speed = 0).
    @Test
    public void motoStopAfterParking() {
        motorcycle1.testDrive();
        motorcycle1.park();
        assertTrue(motorcycle1.getSpeed() == 0);
    }

}