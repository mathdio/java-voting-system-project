package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * The type Principal.
 */
public class Principal {

  /**
   * The entry point of application.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao votingManagement = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);
    byte firstStage;

    do {
      System.out.println("""
          Cadastrar pessoa candidata?
          1 - Sim
          2 - Não
          Entre com o número correspondente à opção desejada:""");
      firstStage = Byte.parseByte(scanner.nextLine());

      if (firstStage == 1) {
        Principal.registerCandidate(votingManagement, scanner);
      } else if (firstStage == 2) {
        break;
      } else {
        System.out.println("Entre com uma opção válida!");
        firstStage = 1;
      }
    } while (firstStage == 1);

    byte secondStage;

    do {
      System.out.println("""
          Cadastrar pessoa eleitora?
          1 - Sim
          2 - Não
          Entre com o número correspondente à opção desejada:""");
      secondStage = Byte.parseByte(scanner.nextLine());

      if (secondStage == 1) {
        Principal.registerVoter(votingManagement, scanner);
      } else if (secondStage == 2) {
        break;
      } else {
        System.out.println("Entre com uma opção válida!");
        secondStage = 1;
      }
    } while (secondStage == 1);

    scanner.close();
  }

  /**
   * Register candidate.
   */
  public static void registerCandidate(GerenciamentoVotacao votingManagement, Scanner scanner) {
    System.out.println("Entre com o nome da pessoa candidata:");
    String candidateName = scanner.nextLine();

    System.out.println("Entre com o número da pessoa candidata:");
    int candidateNumber = Integer.parseInt(scanner.nextLine());

    votingManagement.cadastrarPessoaCandidata(candidateName, candidateNumber);
  }

  /**
   * Register voter.
   */
  public static void registerVoter(GerenciamentoVotacao votingManagement, Scanner scanner) {
    System.out.println("Entre com o nome da pessoa eleitora:");
    String voterName = scanner.nextLine();

    System.out.println("Entre com o CPF da pessoa eleitora:");
    String voterCpf = scanner.nextLine();

    votingManagement.cadastrarPessoaEleitora(voterName, voterCpf);
  }

}
