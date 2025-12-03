public class TelaMae extends JFrame {

    private JTextField txtNome;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private JTextField txtDataAniversario;

    public TelaMae() {
        setTitle("Cadastro de Mãe");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        txtNome = new JTextField(20);
        txtTelefone = new JTextField(20);
        txtEndereco = new JTextField(20);
        txtDataAniversario = new JTextField(10);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarMae());

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 2));

        painel.add(new JLabel("Nome:"));
        painel.add(txtNome);

        painel.add(new JLabel("Telefone:"));
        painel.add(txtTelefone);

        painel.add(new JLabel("Endereço:"));
        painel.add(txtEndereco);

        painel.add(new JLabel("Aniversário (DD-MM-AAAA):"));
        painel.add(txtDataAniversario);

        painel.add(btnSalvar);

        add(painel);
        setVisible(true);
    }

    private void salvarMae() {
        try {
            Mae m = new Mae();
            m.setNome(txtNome.getText());
            m.setTelefone(txtTelefone.getText());
            m.setEndereco(txtEndereco.getText());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate data = LocalDate.parse(txtDataAniversario.getText(), formatter);

            m.setDataAniversario(data);

            MaeDAO dao = new MaeDAO();
            dao.inserir(m);

            JOptionPane.showMessageDialog(this, "Mãe cadastrada!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Data inválida! Use o formato DD-MM-AAAA.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
