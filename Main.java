import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Cadastrar funcionario");
            System.out.println("4 - Listar usuários");
            System.out.println("5 - Listar livros");
            System.out.println("6 - Listar funcionario");
            System.out.println("7 - Cadastrar exemplar");
            System.out.println("8 - Listar exemplares disponíveis");
            System.out.println("9 - Realizar empréstimo");
            System.out.println("10 - Realizar devolução");
            System.out.println("0 - Sair");

            try {
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Digite um número válido!");
                sc.nextLine();
                opcao = -1;
                continue;
            }

            sc.nextLine(); // limpar buffer do scanner

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeUser = sc.nextLine();

                    System.out.print("Nascimento: ");
                    String nascimentoUser = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefoneUser = sc.nextLine();

                    int idUser = 0;
                    if (!b.getUsuarios().isEmpty()) {
                        int maxId = 0;
                        for (Usuario usuario : b.getUsuarios()) {
                            if (usuario.getId() > maxId) maxId = usuario.getId();
                        }
                        idUser = maxId + 1;
                    }

                    Usuario user = new Usuario(nomeUser, nascimentoUser, telefoneUser, idUser);
                    b.cadastrarUsuario(user);
                    break;

                case 2:
                    System.out.print("Título: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor: ");
                    String autor = sc.nextLine();

                    int ano = 0;
                    try {
                        System.out.print("Ano: ");
                        ano = sc.nextInt();
                    } catch (Exception ex) {
                        System.out.println("Digite um número válido para o ano.");
                        sc.nextLine();
                        break;
                    }

                    int codigoLivro = 0;
                    if (!b.getLivros().isEmpty()) {
                        int maxId = 0;
                        for (Livro livro : b.getLivros()) {
                            if (livro.getIdLivro() > maxId) maxId = livro.getIdLivro();
                        }
                        codigoLivro = maxId + 1;
                    }

                    Livro l = new Livro(codigoLivro, titulo, autor, ano);
                    b.cadastrarLivro(l);
                    break;

                case 3:
                    System.out.print("Nome: ");
                    String nomeFuncionario = sc.nextLine();

                    System.out.print("Nascimento: ");
                    String nascimentoFuncionario = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefoneFuncionario = sc.nextLine();

                    int idFuncionario = 0;
                    if (!b.getFuncionarios().isEmpty()) {
                        int maxId = 0;
                        for (Funcionario f : b.getFuncionarios()) {
                            if (f.getId() > maxId) maxId = f.getId();
                        }
                        idFuncionario = maxId + 1;
                    }

                    Funcionario func = new Funcionario(nomeFuncionario, nascimentoFuncionario, telefoneFuncionario, idFuncionario);
                    b.cadastrarFuncionario(func);
                    break;

                case 4:
                    b.listarUsuarios();
                    break;

                case 5:
                    b.listarLivros();
                    break;

                case 6:
                    b.listarFuncionarios();
                    break;

               case 7:
                    int codLivro = 0;
                    try {
                        System.out.print("Código do livro: ");
                        codLivro = sc.nextInt();
                    } catch (Exception ex) {
                        System.out.println("Digite um número válido para o código do livro.");
                        sc.nextLine();
                        break;
                    }

                    Livro livroSelecionado = b.buscarLivro(codLivro);
                    if (livroSelecionado == null) {
                        System.out.println("Livro não encontrado.");
                        sc.nextLine();
                        break;
                    }

                    int codExemplar = 0;
                    if (!livroSelecionado.getExemplares().isEmpty()) {
                        int maxId = 0;
                        for (Exemplar ex : livroSelecionado.getExemplares()) {
                            if (ex.getCodigo() > maxId) maxId = ex.getCodigo();
                        }
                        codExemplar = maxId + 1;
                    }

                    Exemplar e = new Exemplar(codExemplar);
                    b.cadastrarExemplar(codLivro, e);
                    System.out.println("Exemplar cadastrado com código automático: " + codExemplar);
                    sc.nextLine();
                    break;
                case 8:
                    int codBusca = 0;
                    try {
                        System.out.print("Código do livro: ");
                        codBusca = sc.nextInt();
                    } catch (Exception ex) {
                        System.out.println("Digite um número válido!");
                        sc.nextLine();
                        break;
                    }
                    b.listarExemplaresDisponiveis(codBusca);
                    sc.nextLine();
                    break;

                case 9:
                    System.out.print("Código do exemplar: ");
                    int codEmp = sc.nextInt();

                    System.out.print("ID do usuário: ");
                    int idEmp = sc.nextInt();

                    b.realizarEmprestimo(codEmp, idEmp);
                    sc.nextLine();
                    break;

                case 10:
                    System.out.print("Código do exemplar: ");
                    int codDev = sc.nextInt();

                    b.realizarDevolucao(codDev);
                    sc.nextLine();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}