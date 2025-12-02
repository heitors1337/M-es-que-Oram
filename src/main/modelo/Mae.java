public class Mae {
    public int id;
    public String nome;
    public String telefone;
    public String endereco;
    public String dataAniversario;

    public Mae(int id, String nome, String telefone, String endereco, String dataAniversario){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataAniversario = dataAniversario;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getDataAniversario() {
        return dataAniversario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataAniversario(String dataAniversario) {
        this.dataAniversario = dataAniversario;
    }
}