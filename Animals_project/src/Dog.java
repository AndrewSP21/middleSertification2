public class Dog extends Pet  {


    public Dog(String name, String birthday) throws emptyLineException {
        super(name, birthday);
        super.addCommand("Голос");
        super.addCommand("Лежать");
    }
    public void bark(){
        System.out.println("Гав - гав");
    }

    public Dog(String name, String birthday, String commands) throws emptyLineException {
        super(name, birthday);
        super.addCommand(commands);

    }
}

