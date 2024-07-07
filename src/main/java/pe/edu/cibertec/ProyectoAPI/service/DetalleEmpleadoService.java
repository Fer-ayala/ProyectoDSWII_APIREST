package pe.edu.cibertec.ProyectoAPI.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.ProyectoAPI.model.bd.Empleado;
import pe.edu.cibertec.ProyectoAPI.model.bd.Rol;
import pe.edu.cibertec.ProyectoAPI.model.bd.Usuario;
import pe.edu.cibertec.ProyectoAPI.repository.EmpleadoRepository;
import pe.edu.cibertec.ProyectoAPI.repository.UsuarioRepository;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DetalleEmpleadoService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;
    private EmpleadoRepository empleadoRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Usuario usuario =obtenerUsuarioXNomusuario(username);
        Empleado empleado = empleadoRepository.findByUsuarioNomusuario(username);
        return autenticacionUsuario(
                usuario,
                obtenerListaRoles(empleado.getRol())
        );
    }
    public Usuario obtenerUsuarioXNomusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    public Empleado obtenerEmpleadoxNomusuario(String nomusuario){
        return empleadoRepository.findByUsuarioNomusuario(nomusuario);
    }

    public List<GrantedAuthority> obtenerListaRoles(Rol rol){
        List<GrantedAuthority> authorityList = new ArrayList<>();
            authorityList.add(new
                    SimpleGrantedAuthority("ROLE_"+rol.getNomrol()));
        return  authorityList;
    }

    private UserDetails autenticacionUsuario(
            Usuario usuario, List<GrantedAuthority> authorityList
    ){
        return new User(
                usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(),
                true, true, true,
                authorityList
        );
    }
}
