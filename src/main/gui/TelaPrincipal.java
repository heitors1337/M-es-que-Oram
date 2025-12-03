public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        setTitle("Sistema - Mães que Oram pelos Filhos");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton btnMae = new JButton("Cadastrar Mãe");
        JButton btnEncontro = new JButton("Cadastrar Encontro");

        JPanel painel = new JPanel();
        painel.add(btnMae);
        painel.add(btnEncontro);

        add(painel);

        setVisible(true);
    }
}
