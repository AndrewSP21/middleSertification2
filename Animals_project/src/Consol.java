import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Consol {
    /**
     * Метод передает приветствие и ожидает ввод пользователя в консоль
     * @param prompt Приветствие
     * @return Данные введеные пользователем в консоль
     */
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + "  ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 )  return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
    public static Integer whichPet(){
        /***
         * Метод определяет тип животного
         */

        Consol helper = new Consol();
        String typePet = "";
        int cont = -1;
        while (cont < 0) {
            typePet = helper.getUserInput("Введите 1,2 или 3 - вид питомца: Собака - 1, Кошка - 2, Хомяк - 3 ");
            if (typePet.equals("1") | typePet.equals("2") | typePet.equals("3") ) { //| typePet.equals("2") | typePet.equals("3")
                cont = 1;
            } else {
                System.out.println("Ошибка ввода - необходимо ввести число о 1 до 3");
                System.out.println(typePet + " не равно 1?");

            }

        }
        return Integer.parseInt(typePet);
    }

    public static String[] nameAndBorn(){
        /***
         * Метод запрашивает кличку и дату рождения питомца
         */
        Consol helper = new Consol();
        String[] result = new String[] {"",""};
        String nameP = "";
        String birthP = "";
        int cont = -1;
        while (cont < 0) {
            nameP = helper.getUserInput("Введите кличку питомца: ");
            birthP = helper.getUserInput("Дату рождения питомца: ");
            if (nameP.equals("") | birthP.equals("")) {
                System.out.println("Ошибка ввода - необходимо ввести кличку питомца и его дату рождения");
            } else {
                cont = 1;
            }
        }
        result[0]=nameP;
        result[1]=birthP;
        return result;
    }
    /**
     * Стартовое меню
     * @return Выбранный пункт меню
     */
    public static int menu(){
        String menu = """
                
                Реестр домашних живтоных.
                1. Зарегистрировать нового питомца
                2. Список команд которые выполняет питомец
                3. Обучить питомца новой команде
                4. Загрузить данные из базы
                5. Сохранить данные в базу
                6. Завершить
                
                """;
        System.out.println(menu);
        Consol helper = new Consol();
        String point = helper.getUserInput("Введите номер пункта меню: ");
        try {
            if (Integer.parseInt(point)<1 | Integer.parseInt(point)>6 ){
                System.out.println("Введен некорректный пункт меню.");
                return -1;
            }

        } catch (NumberFormatException e) {
            System.out.println("Введен некорректный пункт меню.");
            return -1;
        }
        return Integer.parseInt(point);
    }
    public static void startMenu() throws emptyLineException {
        int w = -1;
        while (w < 0){

            switch (menu()){
                case 1: {
                    createPet();
                    break;
                }
                case 2:{
                    petCommands();
                    break;
                }
                case 3:{
                    educationPet();
                    break;
                }
                case 4:{
                    DB.readDB();
                    break;
                }
                case 5:{
                    DB.writeDB();
                    break;
                }
                case 6:{
                    w = 0;
                    break;
                }
            }
        }
    }
    public static void createPet() throws emptyLineException {
        /***
         * Метод создает питомца и помещает его в массив
         */
        String[] nb = new String[]{"",""};
        Integer tp = -1;
        tp = whichPet();
        nb = nameAndBorn();
        if (tp == 1){
            Main.dP.add(Main.new_Dog(nb[0],nb[1]));
        } else if (tp == 2){
            Main.cP.add(Main.new_Cat(nb[0],nb[1]));
        } else if (tp == 3){
            Main.hP.add(Main.new_Hamster(nb[0],nb[1]));
        }

    }

    public static void petCommands(){
        /***
         * Метод ищет питомца по имени и показывает какие команды знает питомец
         */
        Integer p = -1;
        p = whichPet();
        Consol helper = new Consol();
        String nameP = "";
        nameP = helper.getUserInput("Введите кличку питомца: ");
        Integer j = -1;
        if (p == 1){
            for (int i = 0; i < Main.dP.size(); i++) {
                if (Main.dP.get(i).getName().equals(nameP)){
                    System.out.println(nameP + " умеет: ");
                    System.out.println(Main.dP.get(i).getCommands());
                    j = 1;
                }
            }
            if (j == -1){
                System.out.println("Питомца с именем " + nameP + " найти не удалось.");
            }
        } else if (p == 2) {
            for (int i = 0; i < Main.cP.size(); i++) {
                if (Main.cP.get(i).getName().equals(nameP)){
                    System.out.println(nameP + " умеет: ");
                    System.out.println(Main.cP.get(i).getCommands());
                    j = 1;
                }
            }
            if (j == -1){
                System.out.println("Питомца с именем " + nameP + " найти не удалось.");
            }

        } else if (p == 3) {
            for (int i = 0; i < Main.hP.size(); i++) {
                if (Main.hP.get(i).getName().equals(nameP)){
                    System.out.println(nameP + " умеет: ");
                    System.out.println(Main.hP.get(i).getCommands());
                    j = 1;
                }
            }
            if (j == -1){
                System.out.println("Питомца с именем " + nameP + " найти не удалось.");
            }

        }

    }

    public static void educationPet(){
        /***
         * Метод ищет питомца по имени и обучает его команде
         */
        Integer p = -1;
        p = whichPet();
        Consol helper = new Consol();
        String nameP = "", nameCommand = "";
        nameP = helper.getUserInput("Введите кличку питомца: ");
        nameCommand = helper.getUserInput("Введите команду, которой нужно обучить " + nameP +": ");
        Integer j = -1;
        if (p == 1){
            for (int i = 0; i < Main.dP.size(); i++) {
                if (Main.dP.get(i).getName().equals(nameP)){
                    Main.dP.get(i).addCommand(nameCommand);
                    System.out.println(nameP + " теперь умеет: ");
                    System.out.println(Main.dP.get(i).getCommands());
                    j = 1;
                }
            }
            if (j == -1){
                System.out.println("Питомца с именем " + nameP + " найти не удалось.");
            }
        } else if (p == 2) {
            for (int i = 0; i < Main.cP.size(); i++) {
                if (Main.cP.get(i).getName().equals(nameP)){
                    Main.cP.get(i).addCommand(nameCommand);
                    System.out.println(nameP + " теперь умеет: ");
                    System.out.println(Main.cP.get(i).getCommands());
                    j = 1;
                }
            }
            if (j == -1){
                System.out.println("Питомца с именем " + nameP + " найти не удалось.");
            }

        } else if (p == 3) {
            for (int i = 0; i < Main.hP.size(); i++) {
                if (Main.hP.get(i).getName().equals(nameP)){
                    Main.hP.get(i).addCommand(nameCommand);
                    System.out.println(nameP + " теперь умеет: ");
                    System.out.println(Main.hP.get(i).getCommands());
                    j = 1;
                }
            }
            if (j == -1){
                System.out.println("Питомца с именем " + nameP + " найти не удалось.");
            }

        }
    }
}
