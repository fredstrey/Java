import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/******************************************************************************
Este código cria uma lista com um determinado número clientes com atributos:
(nome, endereço, cpf),  pede que o usuário preencha os dados da lista e por fim, 
salva as informações num arquivo no formato SQL.
*******************************************************************************/

/*inicialmente é definida a classe cliente*/
class Cliente	{
			private	String nome;
			private	String endereço;
			private	String cpf;
			
        public String getnome(){return nome;}
        public String getendereço(){return endereço;}
        public String getcpf(){return cpf;}
        public Cliente(String nome, String endereço, String cpf)	{
								this.nome = nome;
								this.endereço = endereço;
								this.cpf = cpf;
				}
}



public class Main{
    public static void main(String[] args) {
        System.out.print("Quantos clientes deseja cadastrar?"); /*Aqui é definido quantos clientes o usuário deseja cadastrar*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Cliente[] fabric = new Cliente[n]; /*lista criada com tamanho especificado pelo usuário*/

        for (int i = 0; i < fabric.length; i++) { /*nesta interação for, o usuário preenche a lista de clientes*/
            System.out.print("Digite o nome do cliente " + (i + 1) + ": ");
            String nome = scanner.nextLine();
            
        
            System.out.print("Digite o endereço do cliente " + (i + 1) + ": ");
            String endereço = scanner.nextLine();
         
            
            System.out.print("Digite o cpf do cliente " + (i + 1) + ": ");
            String cpf = scanner.nextLine();
            
            fabric[i] = new Cliente(nome, endereço, cpf); 
        }
    System.out.println("Clientes cadastrados:"); /*a lista de clientes é mostrada na tela*/
        for (int i = 0; i < fabric.length; i++) {
            System.out.println("Nome do cliente " + (i + 1) + ": " + fabric[i].getnome());
            System.out.println("Endereço do cliente " + (i + 1) + ": " + fabric[i].getendereço());
            System.out.println("Cpf do cliente " + (i + 1) + ": " + fabric[i].getcpf());
        }    
    
    
    saveToSQLFile(fabric, "Clientes.sql"); /*por fim, é chamada a função que salvo a lista de clientes num arquivo com formato .sql*/
     System.out.println("lista de clientes salva num arquivo SQL.");
}
private static void saveToSQLFile(Cliente[] fabric, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) { /*o arquivo .sql é escrito "manualmente" pelo algoritmo*/
            for (Cliente cliente : fabric) {
                String sql = "INSERT INTO Clientes (nome, endereço, cpf) VALUES ('" + cliente.getnome() + "', '"
                        + cliente.getendereço() + "','" + cliente.getcpf() + "');";
                writer.write(sql);
                writer.write("\n"); /*adiciona uma linha no final de cada iteração, separando cada declaração no arquivo SQL */
            }
        } catch (IOException e) { /*caso ocorra algum erro, ele será especificado*/
            e.printStackTrace();
        }
    }
}    
