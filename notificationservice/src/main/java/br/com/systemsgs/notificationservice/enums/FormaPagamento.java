package br.com.systemsgs.notificationservice.enums;

public enum FormaPagamento {

    DINHEIRO("Dinheiro"),
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    BOLETO("Boleto Bancário"),
    PIX("Pix"),
    TRANSFERENCIA_BANCARIA("Transferência Bancária"),
    CARTEIRA_DIGITAL("Carteira Digital"),
    CHEQUE("Cheque"),
    OUTRO("Outro");

    private final String descricao;

    FormaPagamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
