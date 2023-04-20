public class emptyLineException  extends Exception{
    public emptyLineException(String message) {
        super(message);
        System.out.println("Недостаточно данных для регистрации питомца");
    }
}
