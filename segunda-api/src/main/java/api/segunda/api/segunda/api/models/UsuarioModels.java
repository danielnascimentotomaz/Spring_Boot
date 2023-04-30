package api.segunda.api.segunda.api.models;

import java.util.ArrayList;
import java.util.List;
// Aqui eu crie uma classe para criar um usuario ; se eu tivesse trabblhando com banco de dado
// eu ia criar uma classe entidade para cria minha tabela no banco de dado

public class UsuarioModels {
   // Atributos
    private Integer id;
    private String login;
    private String password;


    // Construtor vazio
    public UsuarioModels(){}

    // Construtor com parâmetro
    public UsuarioModels(String login, String password){
        this.login= login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
