import java.util.Objects;

public class Car {
    private String code;
    private String constructor;
    private int enginePower;
    private String color;

    public Car() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConstructor() {
        return constructor;
    }

    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getCode().equals(car.getCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    @Override
    public String toString() {
        return "Car{" +
                "code='" + code + '\'' +
                ", constructor='" + constructor + '\'' +
                ", enginePower=" + enginePower +
                ", color='" + color + '\'' +
                '}';
    }
}
