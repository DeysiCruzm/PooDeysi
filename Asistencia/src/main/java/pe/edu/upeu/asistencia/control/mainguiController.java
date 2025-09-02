package pe.edu.upeu.asistencia.control;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.io.IOException;
import java.util.Map;


@Controller
public class mainguiController {
    @FXML
    private BorderPane bp;
    @FXML
    MenuBar menuBar;
    @FXML
    TabPane tabPane;
    @FXML
    MenuItem munuItem1,ItemClose;
    @Autowired
    ApplicationContext context;

    @FXML
    public void initialize(){
        MenuItemListener mIL=new MenuItemListener();
        munuItem1.setOnAction((mIL::handle));
        ItemClose.setOnAction((mIL::handle));

    }
    class MenuItemListener {
        Map<String,String[]> menuConfig=Map.of(
                "munuItem1" , new String[]{"/fxml/main_participante.fxml","reg.Participante","T"},
                "ItemClose" , new String[]{"/fxml/login.fxml","salir","C"}
        );

        public void handle(ActionEvent e){
            String id=((MenuItem)e.getSource()).getId();
            if (menuConfig.containsKey(id)){
                String[] items=menuConfig.get(id);
                if(items[2].equals("C")){
                    Platform.exit();
                    System.exit(0);

                }else{
                    abrirTabPaneFXML(items[0],items[1]);
                }
            }

        }
        private void abrirTabPaneFXML(String fxmlPath, String title){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));
                fxmlLoader.setControllerFactory(context::getBean);
                Parent root = fxmlLoader.load();
                ScrollPane scrollpane=new ScrollPane(root);
                scrollpane.setFitToWidth(true);
                scrollpane.setFitToHeight(true);
                Tab newTab=new Tab(title, scrollpane);
                tabPane.getTabs().clear();
                tabPane.getTabs().add(newTab);

            }catch (IOException ex){
                throw new RuntimeException();

            }

        }



    }
    class MenuListener  {
        public void handle(Event e){}

    }


}
