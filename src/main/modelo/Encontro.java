public class Servico {
    private int id;
    private ServicoTipo tipo;
    private Mae maeResponsavel;
    private String descricao;

    public Servico() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public ServicoTipo getTipo() {
        return tipo;
    }
    public void setTipo(ServicoTipo tipo) {
        this.tipo = tipo;
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
