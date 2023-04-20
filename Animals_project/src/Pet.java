import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pet {
    private String name;
    private String birthday;
    private List<String> listOfCommands = new ArrayList<>();

    protected void eat() {
        System.out.println("Ам, ам");
    }

    protected void sleep() {
        System.out.println("Xp.р.р.р");
    }

    protected void addCommand(String commanda) {
        listOfCommands.add(commanda);
    }

    public Pet(String name, String birthday) throws emptyLineException {

        this.name = name;
        this.birthday = birthday;
        CounterP.add();

    }

    protected String getCommands() {
        if (listOfCommands.isEmpty()) {
            System.out.println("Список команд пуст");
            return "";
        }
        String temp = new String();
        for (int i = 0; i < listOfCommands.size(); i++) {
            temp += listOfCommands.get(i) + " ";
//            System.out.println(listOfCommands.get(i));
        }
        return temp;
    }

    public String getInfo() {
        return "Кличка: " + name + ", " + "Дата рождения: " + birthday + " Изученные команды: " + getCommands();
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getListOfCommands() {
        return listOfCommands;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setListOfCommands(List<String> listOfCommands) {
        this.listOfCommands = listOfCommands;
    }

    public static class CounterP implements AutoCloseable {
        private static int count = 0;

        public CounterP() {
            add();
        }

        public static void add() {
            count += 1;

        }

        public static int getCount() {
            return count;
        }

        @Override
        public void close() throws Exception {
            count -= 1;
        }
    }


}
