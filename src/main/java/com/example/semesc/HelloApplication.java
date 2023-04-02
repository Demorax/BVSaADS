package com.example.semesc;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
Tato aplikace využívá k ukládání dat binární vyhledávací strom.
Klíč je vždy generován v modelu GPS, vygenerujou se 2 int pro souřadnici N a E, pak se to převedou čísla na binární číslo
a postupně se tyto 2 birnání čísla prokládají do jednoho, aby se vytvořila jedinečný klíč pro danou souřadnici.

K vyhledávání nejbližší souřednice zadané uživatelem se používá levostranná halda na poli.
 */





public class HelloApplication extends Application{

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("SemesC");
        stage.setScene(scene);

        stage.show();

    }



    public static void main(String[] args) throws IOException {
        launch();
    }
}