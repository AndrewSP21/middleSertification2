public class Hamster extends Pet  {
    public Hamster(String name, String birthday) throws emptyLineException {
        super(name, birthday);
        super.addCommand("Есть");
        super.addCommand("Спать");
    }
    public void runInTheWheel(){
        System.out.println("Хомяк бежит");
    }

    public Hamster(String name, String birthday, String commands) throws emptyLineException {
        super(name, birthday);
        super.addCommand(commands);

    }


}
