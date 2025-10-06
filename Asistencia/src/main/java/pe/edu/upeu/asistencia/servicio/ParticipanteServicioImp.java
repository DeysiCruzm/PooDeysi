package pe.edu.upeu.asistencia.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.asistencia.modelo.Participante;
import pe.edu.upeu.asistencia.repositorio.ParticipanteIRepositorio;

import java.util.List;

@Service
public class ParticipanteServicioImp implements ParticipanteServicioI {

    @Autowired
    ParticipanteIRepositorio participanteRepositorio;

    @Override
    public void save(Participante participante) {
        participanteRepositorio.save(participante);
    }

    @Override
    public List<Participante> findAll() {
      return participanteRepositorio.findAll();
    }

    @Override
    public Participante update(Participante participante) {
       return participanteRepositorio.save(participante);
    }

    @Override
    public void delete(String dni) {
        participanteRepositorio.deleteById(dni);
    }

    @Override
    public Participante findById(String dni) {
        return participanteRepositorio.findById(dni).orElseThrow();
    }
}
