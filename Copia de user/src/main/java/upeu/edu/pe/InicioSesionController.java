package upeu.edu.pe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

        import java.io.*;
        import java.util.Scanner;

public class InicioSesionController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    public void login() {
        String user = txtUsuario.getText();
        String pass = txtPassword.getText();

        if (validateUser(user, pass)) {
            showAlert(Alert.AlertType.INFORMATION, "Bienvenido " + user);
        } else {
            showAlert(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos");
        }
    }

    private boolean validateUser(String user, String pass) {
        try (Scanner sc = new Scanner(new File("usuarios.txt"))) {
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                if (parts.length == 2 && parts[0].equals(user) && parts[1].equals(pass)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            return false;
        }
        return false;
    }

    @FXML
    public void goToRegister() {
        changeScene("upeu/edu/pe/InicioSesion.fxml");
    }

    private void changeScene(String fxml) {
        try {
            Stage stage = (Stage) txtUsuario.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(Alert.AlertType type, String msg) {
        Alert alert = new Alert(type, msg, ButtonType.OK);
        alert.showAndWait();
    }
    @FXML
    private void irARegistro(ActionEvent event) {
        try {
            // Cargar el archivo FXML de registrar
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/upeu/edu/pe/Register.fxml"));
            Scene scene = new Scene(loader.load());

            // Obtener la ventana actual y cambiarle la escena
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Registrar Usuario");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

