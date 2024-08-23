package br.com.systemsgs.notificationservice.enums;

public enum StatusContas {

    EM_ABERTO("Em aberto"),
    PENDENTE("Pendente"),
    CONFIRMADA("Confirmada"),
    BAIXADA("Baixada"),
    ATRASADA("Atrasada"),
    PAUSADA("Pausada"),
    CANCELADA("Cancelada"),
    VENCIDA("Vencida"),
    INADIMPLENTE("Inadimplente"),
    AGUARDANDO_REEMBOLSO("Aguardando Reembolso");

    private final String descricao;

    StatusContas(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
