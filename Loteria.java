import java.util.Random;
import java.util.Scanner;

public class Loteria {
    public static void main(String[] args) {
        int apostarZeroCem[] = new int[101];
        int quardaNum[] = new int[101];
        int cont = 0;
        int acerto = 0;
        int sorteia = 0;

        Scanner x = new Scanner(System.in);

        System.out.println("Digite o tipo de aposta (1 para 0 a 100, 2 para A a Z, 3 para Par ou Ímpar):");
        int tipoAposta = x.nextInt();

        switch (tipoAposta) {
            case 1:
                // Armazenando os números apostados
                System.out.println("Digite 15 números de 0 a 100:");
                while (cont < 15) {
                    apostarZeroCem[cont] = x.nextInt();
                    quardaNum[apostarZeroCem[cont]] = apostarZeroCem[cont];
                    cont++;
                }

                // Verificando os acertos
                Random random = new Random();
                cont = 0; // Reiniciando cont para uso no próximo loop
                while (cont < 15) {
                    sorteia = random.nextInt(101);
                    if (quardaNum[sorteia] == sorteia) {
                        acerto++;
                        quardaNum[sorteia] = -1; // Marcando o número sorteado como -1 para evitar repetições
                    }
                    cont++;
                }

                // Mostrando os números acertados
                System.out.println("Números acertados no sorteio:");
                cont = 0; // Reiniciando cont para uso no próximo loop
                while (cont < 101) {
                    if (quardaNum[cont] != 0 && quardaNum[cont] != -1) {
                        System.out.println(quardaNum[cont]);
                    }
                    cont++;
                }
                break;

            case 2:
                // Armazenando os caracteres apostados
                System.out.println("Digite 15 caracteres de A a Z:");
                while (cont < 15) {
                    char ch = x.next().charAt(0);
                    int asciiValue = (int) ch;
                    if (asciiValue >= 65 && asciiValue <= 90) {
                        apostarZeroCem[cont] = asciiValue;
                        quardaNum[apostarZeroCem[cont]] = apostarZeroCem[cont];
                        cont++;
                    } else {
                        System.out.println("Digite um caractere de A a Z.");
                    }
                }

                // Verificando os acertos
                random = new Random();
                cont = 0; // Reiniciando cont para uso no próximo loop
                while (cont < 15) {
                    sorteia = random.nextInt(26) + 65; // Gera um número ASCII entre 65 e 90 (A-Z)
                    if (quardaNum[sorteia] == sorteia) {
                        acerto++;
                        quardaNum[sorteia] = -1; // Marcando o número sorteado como -1 para evitar repetições
                    }
                    cont++;
                }

                // Mostrando os caracteres acertados
                System.out.println("Caracteres acertados no sorteio:");
                cont = 65; // ASCII de 'A'
                while (cont <= 90) { // ASCII de 'Z'
                    if (quardaNum[cont] != 0 && quardaNum[cont] != -1) {
                        System.out.println((char) cont);
                    }
                    cont++;
                }
                break;

            case 3:
                // Armazenando as apostas de Par ou Ímpar
                System.out.println("Digite 15 números para apostar se são Par ou Ímpar:");
                while (cont < 15) {
                    int numero = x.nextInt();
                    if (numero >= 0 && numero <= 100) {
                        apostarZeroCem[cont] = numero;
                        quardaNum[apostarZeroCem[cont]] = apostarZeroCem[cont];
                        cont++;
                    } else {
                        System.out.println("Digite um número de 0 a 100.");
                    }
                }

                // Verificando os acertos
                random = new Random();
                cont = 0; // Reiniciando cont para uso no próximo loop
                while (cont < 15) {
                    sorteia = random.nextInt(101);
                    if ((sorteia % 2 == 0 && quardaNum[sorteia] % 2 == 0) || (sorteia % 2 != 0 && quardaNum[sorteia] % 2 != 0)) {
                        acerto++;
                        quardaNum[sorteia] = -1; // Marcando o número sorteado como -1 para evitar repetições
                    }
                    cont++;
                }

                // Mostrando os números acertados
                System.out.println("Números acertados no sorteio:");
                cont = 0; // Reiniciando cont para uso no próximo loop
                while (cont < 101) {
                    if (quardaNum[cont] != 0 && quardaNum[cont] != -1) {
                        System.out.println(quardaNum[cont]);
                    }
                    cont++;
                }
                break;

            default:
                System.out.println("Tipo de aposta inválido.");
                break;
        }

        System.out.println("Número de acertos: " + acerto);
    }
}