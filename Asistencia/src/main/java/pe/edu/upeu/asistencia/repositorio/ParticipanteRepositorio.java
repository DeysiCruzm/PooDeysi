package pe.edu.upeu.asistencia.repositorio;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import pe.edu.upeu.asistencia.enums.CARRERA;
import pe.edu.upeu.asistencia.enums.TIPO_PARTICIPANTE;
import pe.edu.upeu.asistencia.modelo.Participante;

import java.util.ArrayList;
import java.util.List;

public abstract class ParticipanteRepositorio {
    public List<Participante> listaEstudiantes= new ArrayList<>();

    public List<Participante> findAll(){
        listaEstudiantes.add(
                new Participante(
                        new SimpleStringProperty("60527338"),
                        new SimpleStringProperty("Dey"),
                        new SimpleStringProperty("cruz"),
                        new SimpleBooleanProperty(true), CARRERA.Sistemas,
                        TIPO_PARTICIPANTE.organizador



                )
        );
        return listaEstudiantes;

    }
}
