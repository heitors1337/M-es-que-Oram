import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encontro {
    private int id;
    private LocalDate data;
    private Status status;
    private List<Servico> servicos;

    public Encontro() {
        servicos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
}
