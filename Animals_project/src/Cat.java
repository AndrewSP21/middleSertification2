public class Cat extends Pet  {


    public Cat(String name, String birthday) throws emptyLineException {
        super(name, birthday);
        super.addCommand("Мурлыкать");
        super.addCommand("Ловить мышей");
    }
    public void mew(){
        System.out.println("Мяю, мяяяу");
    }

    public Cat(String name, String birthday, String commands) throws emptyLineException {
        super(name, birthday);
        super.addCommand(commands);

    }
}
