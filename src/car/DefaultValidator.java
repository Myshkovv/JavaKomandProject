package Car;

public class DefaultValidator implements Validator{
    @Override
    public void validate(String name, String number, String color) throws IllegalArgumentException{
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (number == null || number.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер не может быть пустым");
        }
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Цвет не может быть пустым");
        }
    }
}