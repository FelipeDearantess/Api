package br.com.meteora.api.model.produto;

import br.com.meteora.api.model.produto.*;
import jakarta.persistence.*;
import lombok.*;


@SuppressWarnings("unused")
@Table(name = "produtos")
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class ProdutoModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String tamanho;

    @Enumerated(EnumType.STRING)
    private Fabricante fabricante;

    private String modelo;
    private String descricao;
    private double preco;
    private String cor;

    public void atualizarInformacoes(DadosAtualizarProduto dados){
        if (dados.modelo() != null){
            this.modelo = dados.modelo();
        }
        if (dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.cor() != null){
            this.cor = dados.cor();
        }
    }
    

    public ProdutoModel(DadosCadastroProduto dados){
        this.nome = dados.nome();
        this.tamanho  =dados.tamanho();
        this.fabricante =dados.fabricante();
        this.modelo =dados.modelo();
        this.descricao = dados.descricao();
        this.preco = dados.preco();
        this.cor = dados.cor();
    }
}