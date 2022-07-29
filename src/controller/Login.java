package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.DaftarTransaksi;
import model.SimpanXML;
import model.booleanAdmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    MouseEvent event;

    @FXML
    private Label a1;

    @FXML
    private Label a2;

    @FXML
    private Label b1;

    @FXML
    private Label b2;

    @FXML
    private JFXButton btnsignin;

    @FXML
    private JFXButton btnsignup;

    @FXML
    private Label l1;

    @FXML
    private Label l11;

    @FXML
    private Label l2;

    @FXML
    private Label l3;

    @FXML
    private AnchorPane layer1;

    @FXML
    private AnchorPane layer2;

    @FXML
    private AnchorPane layersignup;

    @FXML
    private TextField n1;

    @FXML
    private PasswordField n2;

    @FXML
    private Label n3;

    @FXML
    private Label s1;

    @FXML
    private Label s11 ;

    @FXML
    private Label s2;

    @FXML
    private Label s3;

    @FXML
    private JFXButton signin;

    @FXML
    private JFXButton signup;

    @FXML
    private TextField u1;

    @FXML
    private TextField u2;

    @FXML
    private PasswordField u3;

    @FXML
    private PasswordField u4;

    @FXML
    void btn(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(500);
        slide.play();

        layer1.setTranslateX(-300);
        btnsignin.setVisible(true);
        b1.setVisible(true);
        b2.setVisible(true);

        s1.setVisible(true);
        s11.setVisible(true);
        s2.setVisible(true);
        s3.setVisible(true);
        signup.setVisible(true);
        l1.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        signin.setVisible(false);
        a1.setVisible(false);
        a2.setVisible(false);
        btnsignup.setVisible(false);
        n1.setVisible(true);
        n2.setVisible(true);
        n3.setVisible(true);
        u1.setVisible(false);
        u2.setVisible(false);
        u3.setVisible(false);
        u4.setVisible(false);

        slide.setOnFinished((e->{

        }));
    }

    @FXML
    void btn2(MouseEvent event) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.7));
        slide.setNode(layer2);

        slide.setToX(0);
        slide.play();

        layer1.setTranslateX(0);
        btnsignin.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        s1.setVisible(false);
        s11.setVisible(false);
        s2.setVisible(false);
        s3.setVisible(false);
        signup.setVisible(false);
        l1.setVisible(true);
        l2.setVisible(true);
        l3.setVisible(true);
        signin.setVisible(true);
        a1.setVisible(true);
        a2.setVisible(true);
        btnsignup.setVisible(true);
        n1.setVisible(false);
        n2.setVisible(false);
        n3.setVisible(false);
        u1.setVisible(true);
        u2.setVisible(true);
        u3.setVisible(true);
        u4.setVisible(true);

        slide.setOnFinished((e->{

        }));
    }

    @FXML
    void btnsignup(ActionEvent event) {
        try {
            String name = u1.getText() ;
            String userName = u2.getText();
            String password =  u3.getText();
            String confirmPass = u4.getText();

            if (!password.equals(confirmPass)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Error!");
                alert.setHeaderText("Password Anda tidak sama");
                alert.setContentText("Mohon isi ulang password Anda");
                alert.showAndWait();

            } else {
                if(DaftarTransaksi.getDataAdmin().size() != 0) {
                    System.out.println("DATA ADMIN: " + DaftarTransaksi.getDataAdmin().size());
                    DaftarTransaksi.tambahCalonAdmin(name,userName,password);
                    SimpanXML.simpanKeXML(DaftarTransaksi.getCalonAdmin(),DaftarTransaksi.getFileNameCalonAdmin());
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Pendaftaran sukses!");
                    alert.setHeaderText("Data Anda akan dikonfirmasi!" );
                    alert.setContentText("Admin Jariyah akan mengkonfirmasi data Anda, sebelum Anda bisa login!");
                    alert.showAndWait();
                } else {
                    DaftarTransaksi.tambahAdmin(name,userName,password);
                    DaftarTransaksi.setSudahAdaAdmin(new booleanAdmin(true));
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Pendaftaran sukses!");
                    alert.setHeaderText("Anda berhasil membuat akun baru!");
                    alert.setContentText("Selamat datang, " + name +"! Anda bisa langsung login ke Jariyah!");
                    alert.showAndWait();
                }


            }
        } catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Ada data yang masing kosong!");
            alert.setContentText("Mohon cek ulang lagi!!");
            alert.showAndWait();

        }







    }

    @FXML
    void click(ActionEvent event) {

    }

    @FXML
    void sign(MouseEvent event) {

    }

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;
    @FXML
    private JFXButton buttonSubmit;

    @FXML
    private TextField tfPassword;




    @FXML
    private TextField tfUserName;

    @FXML
    private Parent root;



    public void submit(ActionEvent event) throws IOException {

        int indeks = DaftarTransaksi.konfirmasi(n1.getText(),n2.getText());
        if(indeks != -1) {
            DaftarTransaksi.setAdminSkrg(DaftarTransaksi.getDataAdmin().get(indeks));
            System.out.println("IAM HERE");
            root = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sukses");
            alert.setHeaderText("Anda berhasil masuk");
            alert.setContentText("Selamat datang " + DaftarTransaksi.getDataAdmin().get(indeks).getNama());
            alert.showAndWait();


        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error!");
            alert.setHeaderText("Akun tidak terdaftar");
            alert.setContentText("Mohon cek ulang isian data Anda!!!");
            alert.showAndWait();
            n1.setText("");
            n2.setText("");
        }



    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btn(event);
    }
}
