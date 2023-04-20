import java.util.ArrayList;
import java.util.List;


public class Main {
    static List<Dog> dP = new ArrayList<>();
    static List<Cat> cP = new ArrayList<>();
    static List<Hamster> hP = new ArrayList<>();

    public static void main(String[] args) throws emptyLineException {
       Consol.startMenu();
    }


    public static Dog new_Dog(String nameP, String bithday) throws emptyLineException {
        Dog d = null;
        try (Pet.CounterP c = new Pet.CounterP()) {
            if (nameP == "" | bithday == "") {
                throw new emptyLineException("1");
            }
            d = new Dog(nameP, bithday);
            System.out.println("Питомец " + nameP + " успешно зарегистрирован.");
        } catch (Exception e) {
        }
        return d;
    }

    public static Dog new_Dog(String nameP, String bithday, String commands) throws emptyLineException {
        Dog d = new Dog(nameP, bithday, commands);
        return d;
    }

    public static Cat new_Cat(String nameP, String bithday) throws emptyLineException {
        Cat d = null;
        try (Pet.CounterP c = new Pet.CounterP()) {
            if (nameP == "" | bithday == "") {
                throw new emptyLineException("1");
            }
            d = new Cat(nameP, bithday);
            System.out.println("Питомец " + nameP + " успешно зарегистрирован.");
        } catch (Exception e) {
        }
        return d;
    }
    public static Cat new_Cat(String nameP, String bithday, String commands) throws emptyLineException {
        Cat c = new Cat(nameP, bithday, commands);
        return c;
    }
    public static Hamster new_Hamster(String nameP, String bithday) throws emptyLineException {
        Hamster d = null;
        try (Pet.CounterP c = new Pet.CounterP()) {
            if (nameP == "" | bithday == "") {
                throw new emptyLineException("1");
            }
            d = new Hamster(nameP, bithday);
            System.out.println("Питомец " + nameP + " успешно зарегистрирован.");
        } catch (Exception e) {
        }
        return d;
    }
    public static Hamster new_Hamster(String nameP, String bithday, String commands) throws emptyLineException {
        Hamster h = new Hamster(nameP, bithday, commands);
        return h;
    }
}