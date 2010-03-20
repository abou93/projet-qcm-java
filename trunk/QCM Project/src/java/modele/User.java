package modele;

/**
 *
 * @author Maria Rabarison et Lou Ferrand
 */
public class User {
    private Integer idUser;
    private String login;
    private String password;
    private String email;

    public User(Integer idUser, String login, String password) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        assert invariant();
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        assert idUser>0;
        this.idUser = idUser;
        assert invariant();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        assert login != null && !login.matches("^\\s*$") : "Le login ne doit être ni null ni vide";
        this.login = login;
        assert invariant();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        assert password != null && !password.matches("^\\s*$") : "Le t de passe ne doit être ni null ni vide";
        this.password = password;
        assert invariant();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        assert email != null && !email.matches("^[a-z0-9._#&*-]+@[a-z0-9.#&*-]{2,}\\.[a-z]{2,4}$") : "L'email ne doit être ni null ni non valide ";
        this.email = email;
        assert invariant();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        if(this.login.equals(other.login) || this.email.equals(other.email)){
            return true;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.login != null ? this.login.hashCode() : 0);
        hash = 19 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }


    protected boolean invariant(){
        assert getIdUser()==null || getIdUser()>0;
        assert getLogin() != null && !getLogin().matches("^\\s*$") : "Le getLogin() ne doit être ni null ni vide";
        assert getPassword() != null && !getPassword().matches("^\\s*$") : "Le getLogin() ne doit être ni null ni vide";
        assert getEmail() != null && !getEmail().matches("^[a-z0-9._#&*-]+@[a-z0-9.#&*-]{2,}\\.[a-z]{2,4}$") : "L'email ne doit être ni null ni non valide ";

        return true;
    }

}
