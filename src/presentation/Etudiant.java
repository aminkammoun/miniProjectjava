package presentation;

public class Etudiant {
    String name, lastname;

    public Etudiant(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Etudiant() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", lastname='" + lastname + '\'';
    }
}
