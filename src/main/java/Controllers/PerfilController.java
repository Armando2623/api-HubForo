package Controllers;


import com.example.demo.domain.perfiles.DatosRegistroPerfil;
import com.example.demo.domain.perfiles.Perfil;
import com.example.demo.domain.perfiles.PerfilRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private PerfilRepository repository;

    @PostMapping
    public Perfil registrar(@RequestBody @Valid DatosRegistroPerfil datos){
        var perfil = new Perfil(datos);
        return repository.save(perfil);

    }
}
