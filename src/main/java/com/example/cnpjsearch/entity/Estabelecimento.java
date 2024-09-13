package com.example.cnpjsearch.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="estabelecimento") 
@Entity(name="estabelecimento")
@Getter 
@Setter
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(of="cnpj")
public class Estabelecimento  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cnpj;
    private String nome_fantasia;
    private String data_situacao_cadastral;
    private String nome_cidade_exterior;
    private String data_inicio_atividade;
    private String tipo_logradouro;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String uf;
    private String ddd_1;
    private String telefone_1;
    private String ddd_2;
    private String telefone_2;
    private String ddd_fax;
    private String fax;
    private String correio_eletronico;
    private String situacao_especial;
    private String data_situacao_especial;
    private String cnae_fiscal_secundaria;

    @ManyToOne 
    @JoinColumn(name = "identificador_matriz_filial", referencedColumnName = "codigo")
    private IdentificadorMatrizFilial identificador_matriz_filial;
    
    @ManyToOne 
    @JoinColumn(name = "situacao_cadastral", referencedColumnName = "codigo")
    private SituacaoCadastral situacao_cadastral;

    @ManyToOne 
    @JoinColumn(name = "municipio", referencedColumnName = "codigo")
    private Municipio municipio;

    @ManyToOne 
    @JoinColumn(name = "cnae_fiscal_principal", referencedColumnName = "codigo")
    private Cnae cnae_fiscal_principal;

    // @OneToMany (fetch = FetchType.EAGER)
    // @JoinColumn(name = "cnpj",referencedColumnName = "cnpj")
    // private List<EstabelecimentoCnaeRelacionamento> estabelecimento_cnae_relacionamento;

    @ManyToOne 
    @JoinColumn(name = "pais", referencedColumnName = "codigo")
    private Pais pais;

    @ManyToOne 
    @JoinColumn(name = "motivo_situacao_cadastral", referencedColumnName = "codigo")
    private Motivo motivo_situacao_cadastral;

    @ManyToOne 
    @JoinColumn(name = "cnpj_basico", referencedColumnName = "cnpj_basico",insertable = false, updatable = false)
    private Empresa empresa;

    @ManyToOne 
    @JoinColumn(name = "cnpj_basico", referencedColumnName = "cnpj_basico",insertable = false, updatable = false)
    private Simples simples;
}
