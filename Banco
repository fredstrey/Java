import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface Transferir {
    void transferir(Conta contaDestinataria, double quantia);
}

class Conta implements Transferir {
    private String numeroConta;
    private String senha;
    private double saldo;

    public Conta(String numeroConta, String senha, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.senha = senha;
        this.saldo = saldoInicial;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean autentica(String numeroConta, String senha) {
        return this.numeroConta.equals(numeroConta) && this.senha.equals(senha);
    }

    public void depositar(double quantia) {
        saldo += quantia;
        System.out.println("Deposito de " + quantia + " feito com sucesso. saldo atual: " + saldo);
    }

    public void sacar(double quantia) {
        if (saldo >= quantia) {
            saldo -= quantia;
            System.out.println("Saque de " + quantia + " feito com sucesso. saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente, não foi possível realizar a operação");
        }
    }

    public void transferir(Conta contaDestinataria, double quantia) {
        if (saldo >= quantia) {
            saldo -= quantia;
            contaDestinataria.saldo += quantia;
            System.out.println("transferência de " + quantia + " feita com sucesso.");
            System.out.println("Saldo atual (" + numeroConta + "): " + saldo);
            System.out.println("Saldo da conta destinatária(" + contaDestinataria.getNumeroConta() + "): " + contaDestinataria.saldo);
        } else {
            System.out.println("Saldo insuficiente, não foi possível realizar a operação");
        }
    }
}

public class Main {
    private static Map<String, Conta> contas = new HashMap<>();

    public static void main(String[] args) {
       Conta conta1 = new Conta("1234567890", "senha1", 1000.0);
       Conta conta2 = new Conta("0987654321", "senha2", 500.0);

        contas.put(conta1.getNumeroConta(), conta1);
        contas.put(conta2.getNumeroConta(), conta2);

        Scanner scanner = new Scanner(System.in);
        try{
        System.out.print("Digite o número da sua conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        Conta contaDigitada = contas.get(numeroConta);

        if (numeroConta != null && contaDigitada.autentica(numeroConta, senha)) {
            System.out.println("Login realizado com sucesso.");
            fazerTransacao(contaDigitada, scanner);
        } else {
            System.out.println("Número da conta ou senha incorretos, não foi possível fazer login.");
        }}catch (Exception e) {
            System.out.println("Número da conta ou senha incorretos, não foi possível fazer login.");
        } finally {

        scanner.close();
    }}

    private static void fazerTransacao(Conta conta, Scanner scanner) {
        System.out.println("Número da conta: " + conta.getNumeroConta());
        System.out.println("Saldo atual: " + conta.getSaldo());

        System.out.print("Digite o valor que deseja depositar: ");
        double valorDeposito = scanner.nextDouble();
        conta.depositar(valorDeposito);

        System.out.print("Digite o valor que deseja sacar: ");
        double quantiaSaque = scanner.nextDouble();
        conta.sacar(quantiaSaque);

        System.out.print("Digite o número da conta destinatária: ");
        String contaDestinatariaDigitada = scanner.next();

        Conta contaDestinataria = contas.get(contaDestinatariaDigitada);

        if (contaDestinataria != null) {
            System.out.print("Digite a quantia que deseja transferir: ");
            double valorTranferir = scanner.nextDouble();
            conta.transferir(contaDestinataria, valorTranferir);
        } else {
            System.out.println("Número da conta inválida, não foi possível realizar a operação");
        }
    }
}
