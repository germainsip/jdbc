package org.ger.gui;

import com.sun.javafx.collections.MappingChange;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.ger.model.Disc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.ResourceBundle;

public class TableauController implements Initializable {
    public TableView tableExemple;


    public TableColumn colTitre;
    public TableColumn colAnnee;
    public TableColumn colPrix;
    public Label labTitre;
    public Label labAnnee;
    public Label labLabel;
    public Label labPrix;
    public Label labArtiste;
    ObservableList listDisc = FXCollections.observableArrayList();
    HashMap<Integer, String> listArtists = new HashMap();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listDisc.addAll(
                new Disc("truc", 2021, "machin", "rock", 15, 22)
        );
        colTitre.setCellValueFactory(new PropertyValueFactory<Disc, String>("discTitle"));
        colAnnee.setCellValueFactory(new PropertyValueFactory<Disc, String>("discYear"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Disc, String>("discPrice"));
        tableExemple.setItems(listDisc);

        //loadDB();
        // loadDb2();
        // loadArtists();
    }

    public void loadDetails(MouseEvent mouseEvent) {
        Disc disc = (Disc) tableExemple.getSelectionModel().getSelectedItem();
        labTitre.setText(disc.getDiscTitle());
        labAnnee.setText(String.valueOf(disc.getDiscYear()));
        labPrix.setText(disc.getDiscPrice() + " €");
        labLabel.setText(disc.getDiscLabel());
        labArtiste.setText(disc.getArtistId() + "");
        // labArtiste.setText((String) listArtists.get(disc.getArtistId()));
        // System.out.println(listArtists.get(disc.getArtistId()));
    }

//    public void loadDB(){
//        String dest = "jdbc:mysql://localhost:3306/record";
//        String usr = "root";
//        String pass = "Grm1";
//        Connection con;
//        try {
//            con = DriverManager.getConnection(dest,usr,pass);
//            Statement stm = con.createStatement();
//            ResultSet resultSet = stm.executeQuery("SELECT * from disc");
//            while(resultSet.next()){
//                System.out.println(resultSet.getString("disc_title"));
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

      /*  public void loadDb2(){
        listDisc.clear();
        String dest = "jdbc:mysql://localhost:3306/record";
        String usr = "root";
        String pass = "Grm1";
        Connection con;
        try {
            con = DriverManager.getConnection(dest,usr,pass);
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * from disc");
            while(resultSet.next()){
                listDisc.add(
                        new Disc(
                                resultSet.getString("disc_title"),
                                resultSet.getInt("disc_year"),
                                resultSet.getString("disc_label"),
                                resultSet.getString("disc_genre"),
                                resultSet.getInt("disc_price"),
                                resultSet.getInt("artist_id")
                        )
                );
            }
           // System.out.println(listDisc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/

    /*
    public void loadArtists() {
        String dest = "jdbc:mysql://localhost:3306/record";
        String usr = "root";
        String pass = "Grm1";
        Connection con;
        try {
            con = DriverManager.getConnection(dest, usr, pass);
            Statement stm = con.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT * from artist");
            while (resultSet.next()) {
                listArtists.put(resultSet.getInt("artist_id"), resultSet.getString("artist_name"));
            }
            System.out.println(listArtists);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }*/
}
