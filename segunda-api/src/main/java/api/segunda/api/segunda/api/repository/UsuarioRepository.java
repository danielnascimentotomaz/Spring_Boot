package api.segunda.api.segunda.api.repository;

import api.segunda.api.segunda.api.models.UsuarioModels;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// Se eu tivesse trabalhando com banco de dado esse Repository ia ter uma Interface e ia herda JpaRepository
// Porque JpaRepository ja tem varios método para trabalhar com banco de dado.
@Repository
public class UsuarioRepository {
    private List<UsuarioModels> pesooas = new ArrayList<>();






    public void deleteById(Integer id) {
        Iterator<UsuarioModels> interetor = pesooas.iterator();
        while (interetor.hasNext()) {
            UsuarioModels i = interetor.next();
            if (i.getId().equals(id)) {
                interetor.remove();
            }}
    }

    public List<UsuarioModels> findAll() {
        return pesooas; // mim retoena a lista de pessoa
    }

    public UsuarioModels save(UsuarioModels usuarioModels){
        pesooas.add(usuarioModels);// adicionando um usuario na lista
        return usuarioModels;
    }
}
