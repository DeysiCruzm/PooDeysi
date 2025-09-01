package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepositorio {
    public List<Participante> listaEstudiantes= new ArrayList<>();

    public List<Participante> findAll(){
        listaEstudiantes.add(
                new Participante(
                        new SimpleStringProperty("dey"),
                        new SimpleBooleanProperty(true)
                )
        );
        return listaEstudiantes;

    }
}
