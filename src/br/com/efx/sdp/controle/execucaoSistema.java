package br.com.efx.sdp.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.efx.sdp.modelo.item;
import br.com.efx.sdp.modelo.materiaPrima;

public class execucaoSistema {
	
	private List<Integer> itensProduzidos = new ArrayList<>();
	private List<Integer> totalRefugo = new ArrayList<Integer>();
	
	Scanner teclado = new Scanner(System.in);
	String resposta;
	String codItem;
	String codMP;
	String cliente;
	int etapa;
	int loteMP;
	int loteItem;
	int qtdRefugo;
	
	public execucaoSistema() {}

	public void run() {
		identificandoItem();
		identificandoMP();
		
		boolean prosseguir = true;
		
		while(prosseguir) {
			System.out.println("Informe a quantidade de itens produzidos: ");
			addPecas(teclado.nextInt());
			
			informeRefugo();
			
			System.out.println("Prossegue ? (S/N)");
			resposta = teclado.next();
			
			if("N".equalsIgnoreCase(resposta)) {
				prosseguir = false;
			}
			
			itensProduzidos
			.stream()
			.reduce((ac, n) -> ac + n)
			.ifPresent(System.out::println);
			
			
			totalRefugo
			.stream()
			.reduce((ac, n) -> ac + n)
			.ifPresent(System.out::println);
		}
		
		item i = new item(cliente, codItem, etapa, loteItem);
		System.out.println(i.toString());
		
		materiaPrima MP = new materiaPrima(codMP, loteMP);
		System.out.println(MP.toString());
	}

	private void informeRefugo() {
		System.out.println("Informe a quantidade de refugo:");
		qtdRefugo = teclado.nextInt();
		
		if(qtdRefugo > 0){
			System.out.println("Informe o código do refugo: ");
			resposta = teclado.next();
		}
		addRefugo(qtdRefugo);
	}

	private void addPecas (int pecas) {
		if (pecas >= 0) {
		this.itensProduzidos.add(pecas);
		}
	}
	
	private void addRefugo (int qtdRefugo) {
		if (qtdRefugo >= 0) {
		this.totalRefugo.add(qtdRefugo);
		}
	}
	
	public void identificandoItem() {
		System.out.println("Identifique o item à ser produzido: ");
		codItem = teclado.nextLine();
		
		System.out.println("Informe o cliente: ");
		cliente = teclado.nextLine();
		
		System.out.println("Informe a etapa: ");
		etapa = teclado.nextInt();
		
		System.out.println("Digite o número da ordem: ");
		loteItem = teclado.nextInt();
	}
	
	public void identificandoMP() {
		System.out.println("Digite o código do material: ");
		codMP = teclado.nextLine();
		
		teclado.nextLine();
		
		System.out.println("Informe o lote do material: ");
		loteMP = teclado.nextInt();
	}
}
