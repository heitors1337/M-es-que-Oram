public class TelaEncontro extends JFrame {

    private JTextField txtData;
    private JComboBox<Mae> comboMae;
    private JComboBox<ServicoTipo> comboServico;
    private JTextField txtDescricao;
    private JButton btnSalvar;

    public TelaEncontro() {
        setTitle("Cadastrar Encontro");
        setSize(500, 400);
        setLocationRelativeTo(null);

        txtData = new JTextField(10);
        comboMae = new JComboBox<>();
        comboServico = new JComboBox<>();
        txtDescricao = new JTextField(20);

        btnSalvar = new JButton("Salvar Encontro");

        btnSalvar.addActionListener(e -> salvarEncontro());

        carregarCombos();

        JPanel p = new JPanel();
        p.add(new JLabel("Data (DD-MM-AAAA):"));
        p.add(txtData);
        p.add(new JLabel("Mãe Responsável:"));
        p.add(comboMae);
        p.add(new JLabel("Serviço:"));
        p.add(comboServico);
        p.add(new JLabel("Descrição:"));
        p.add(txtDescricao);

        p.add(btnSalvar);
        add(p);

        setVisible(true);
    }

    private void carregarCombos() {
        // carregar mães
        MaeDAO mdao = new MaeDAO();
        for (Mae m : mdao.listar()) comboMae.addItem(m);

        // carregar serviços
        ServicoTipoDAO sdao = new ServicoTipoDAO();
        for (ServicoTipo st : sdao.listar()) comboServico.addItem(st);
    }

    private void salvarEncontro() {
        // depois implementamos
    }
}
