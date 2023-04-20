import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
public class DB
{   private static Statement stmt;
    private static ResultSet rs;

    private static String url = "jdbc:mysql://192.168.1.85:3306/Human_Friends";
    private static String username = "root";
    private static String password = "1";
    private static int bdHasBeenRead= -1;


    public static void main (String[] args) {}
    public static void clearDB(){
        String query = "DELETE FROM All_animals_simple WHERE type_name IN ('Собака','Кошка','Хомяк')";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    public static void readDB(){

        String query = "SELECT * FROM All_animals_simple;";
        System.out.println("Connecting database...");


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                String type_name = rs.getString(2);
                String name_animal = rs.getString(3);
                String birthday = rs.getString(4);
                String name_command = rs.getString(5);

                if (type_name.equals("Собака")){
                    Main.dP.add(Main.new_Dog(name_animal,birthday,name_command));
                    bdHasBeenRead = 1;
                } else if (type_name.equals("Кошка")){
                    Main.cP.add(Main.new_Cat(name_animal,birthday,name_command));
                    bdHasBeenRead = 1;
                } else if (type_name.equals("Хомяк")){
                    Main.hP.add(Main.new_Hamster(name_animal,birthday,name_command));
                    bdHasBeenRead = 1;
                }

//                System.out.println(type_name + " "  + " " + name_animal + " " + birthday + " "  + " " + name_command);
            }
            if (bdHasBeenRead == 1){
                System.out.println("Данные успешно загружены из базы");
            } else
                System.out.println("Данных в базе нет");

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (emptyLineException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeDB(){
        if (bdHasBeenRead == 1){
            clearDB();
        };
        String query = "INSERT All_animals_simple(type_name,name_animal,birthday,name_command) VALUES (?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            int i = 0;
            if (Main.dP.size() > 0) {
                for (int i1 = 0; i1 < Main.dP.size(); i1++) {
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, "Собака");
                    pst.setString(2, Main.dP.get(i1).getName());
                    pst.setString(3, Main.dP.get(i1).getBirthday());
                    pst.setString(4, Main.dP.get(i1).getCommands());
                    i += pst.executeUpdate();
                }
                if (i != 0) {
                    System.out.println("Dogs added");
                } else {
                    System.out.println("failed to add");
                }
            }
            if (Main.cP.size() > 0) {
                i = 0;
                for (int i2 = 0; i2 < Main.cP.size(); i2++) {
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, "Кошка");
                    pst.setString(2, Main.cP.get(i2).getName());
                    pst.setString(3, Main.cP.get(i2).getBirthday());
                    pst.setString(4, Main.cP.get(i2).getCommands());
                    i += pst.executeUpdate();
                }
                if (i != 0) {
                    System.out.println("Cats added");
                } else {
                    System.out.println("Cats failed to add");
                }
            }
            if (Main.hP.size() > 0) {
                i = 0;
                for (int i3 = 0; i3 < Main.hP.size(); i3++) {
                    PreparedStatement pst = connection.prepareStatement(query);
                    pst.setString(1, "Хомяк");
                    pst.setString(2, Main.hP.get(i3).getName());
                    pst.setString(3, Main.hP.get(i3).getBirthday());
                    pst.setString(4, Main.hP.get(i3).getCommands());
                    i += pst.executeUpdate();
                }
                if (i != 0) {
                    System.out.println("Hamsters added");
                } else {
                    System.out.println("Hamsters failed to add");
                }
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }



    }
}