public class Servico {
    private int id;
    private String nome;
    private Mae maeResponsavel;
    private String descricao;

    public Servico() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Mae getMaeResponsavel() {
        return maeResponsavel;
    }

    public void setMaeResponsavel(Mae maeResponsavel) {
        this.maeResponsavel = maeResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}