package emploi.com.tn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ESP_Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_dept;
    private String libelle_dept;

    @JsonIgnore
    @OneToMany(mappedBy = "espdept", cascade = CascadeType.ALL)
    private List<Classe> classes;

    @JsonIgnore
    @OneToMany(mappedBy = "espdept", cascade = CascadeType.ALL)
    private List<UP> ups;

    public int getCode_dept() {
        return code_dept;
    }
    public void setCode_dept(int code_dept) {
        this.code_dept = code_dept;
    }
    public String getLibelle_dept() {
        return libelle_dept;
    }
    public void setLibelle_dept(String libelle_dept) {
        this.libelle_dept = libelle_dept;
    }
    public List<Classe> getClasses() {
        return classes;
    }
    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public List<UP> getUps() {
        return ups;
    }

    public void setUps(List<UP> ups) {
        this.ups = ups;
    }
}
