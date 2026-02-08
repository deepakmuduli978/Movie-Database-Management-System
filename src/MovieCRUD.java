import java.math.BigDecimal;
import java.sql.*;
import java.util.Scanner;

public class MovieCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/movie";
    static final String USER = "root";
    static final String PASS = "Deepak@123";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            while (true) {

                System.out.println("\n===== MOVIE WATCH LIST =====");
                System.out.println("1. Insert Movie");
                System.out.println("2. Views all Movie ");
                System.out.println("3. Update Movie");
                System.out.println("4. Delete Movie");
                System.out.println("5. View particluar  a movie ");
                System.out.println("6. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        insertMovie();
                        break;

                    case 2:
                        viewMovies();
                        break;

                    case 3:
                        updateMovie();
                        break;

                    case 4:
                        deleteMovie();
                        break;

                    case 5:
                        particularmovie();
                        break;

                    case 6:
                        System.out.println("Thank You 😊");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice ❌");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ CREATE ============
    public static void insertMovie() {

        String sql = "INSERT INTO watch_list (sl, name, genre, rating, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Sl No: ");
            int sl = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Movie Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Genre: ");
            String genre = sc.nextLine();

            System.out.print("Enter Rating: ");
            double rating = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter Status: ");
            String status = sc.nextLine();

            ps.setInt(1, sl);
            ps.setString(2, name);
            ps.setString(3, genre);
            ps.setBigDecimal(4, BigDecimal.valueOf(rating));
            ps.setString(5, status);

            int rows = ps.executeUpdate();

            System.out.println(rows + " Movie Inserted ✅");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ READ ============
    public static void viewMovies() {

        String sql = "SELECT * FROM watch_list";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n----- MOVIE LIST -----");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("sl") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("genre") + " | " +
                        rs.getBigDecimal("rating") + " | " +
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ UPDATE ============
    public static void updateMovie() {

        String sql = "UPDATE watch_list SET name=?, genre=?, rating=?, status=? WHERE sl=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Sl No to Update: ");
            int sl = sc.nextInt();
            sc.nextLine();

            System.out.print("New Name: ");
            String name = sc.nextLine();

            System.out.print("New Genre: ");
            String genre = sc.nextLine();

            System.out.print("New Rating: ");
            double rating = sc.nextDouble();
            sc.nextLine();

            System.out.print("New Status: ");
            String status = sc.nextLine();

            ps.setString(1, name);
            ps.setString(2, genre);
            ps.setBigDecimal(3, BigDecimal.valueOf(rating));
            ps.setString(4, status);
            ps.setInt(5, sl);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Movie Updated ✅");
            else
                System.out.println("Movie Not Found ❌");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ============ DELETE ============
    public static void deleteMovie() {

        String sql = "DELETE FROM watch_list WHERE sl=?";

        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Sl No to Delete: ");
            int sl = sc.nextInt();

            ps.setInt(1, sl);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Movie Deleted ✅");
            else
                System.out.println("Movie Not Found ❌");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void particularmovie(){
        try{
          Connection con=DriverManager.getConnection(URL,USER,PASS);
          CallableStatement cs=con.prepareCall("{call getmovie(?)}");
          System.out.println("Enter the serial no:");
          int id=sc.nextInt();
          cs.setInt(1,id);
          ResultSet rs=cs.executeQuery();
          while (rs.next()) {
            System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getBigDecimal(4)+" "+rs.getString(5));
            
          }
          con.close();
        }
        catch(Exception e){
           e.getStackTrace();
        }
        }

    }
