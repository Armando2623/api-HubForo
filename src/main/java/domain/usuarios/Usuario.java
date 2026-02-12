package domain.usuarios;


import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.perfiles.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;

    private String contrasenia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;


    public Usuario(DatosRegistroUsuarios datos, Perfil perfil){
        this.nombre = datos.nombre();
        this.correo = datos.correo();
        this.contrasenia = datos.contrasenia();
        this.perfil = perfil;
    }



    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" +perfil.getNombre()));
    }

    @JsonIgnore
    @Override
    public  String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
//}
}