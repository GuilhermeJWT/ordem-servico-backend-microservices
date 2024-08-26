package br.com.systemsgs.osservice.enums;

public enum Status {

    ORCAMENTO("Orçamento"),
    ABERTO("Aberto"),
    EM_ANDAMENTO("Em andamento"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
