package pe.edu.upeu.asistencia.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.repositorio.ParticipanteRepositorio;

import java.util.List;

@Service // para injección de dependencias
public class ParticipanteServicioImp extends ParticipanteRepositorio implements ParticipanteServicioI { // herencia e implementación

    //List<Estudiante> listaEstudiantes=new ArrayList<>();

    @Override
    public void save(Participante participante) { // Create
        listaEstudiantes.add(participante);
    }

    @Override
    public List<Participante> findAll() {// Read, Report
        if (listaEstudiantes.isEmpty()) {
            return super.findAll();
        }
        return listaEstudiantes;
    }

    @Override
    public void update(Participante participante, int index) { // Update
        listaEstudiantes.set(index, participante);
    }

    @Override
    public void delete(int index) { // Deleted
        listaEstudiantes.remove(index);
    }

    @Override
    public Participante findByID(int index) { // Search
        return listaEstudiantes.get(index);
    }
}
