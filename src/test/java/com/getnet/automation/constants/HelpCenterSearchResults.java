package com.getnet.automation.constants;

public enum HelpCenterSearchResults {
    BOLETO("Eu concluí a negociação, de que forma receberei meu boleto?", "https://site.getnet.com.br/duvidas/solucao-de-dividas/?modal_open=692"),
    CONTA("Posso ter um cartão com a minha Conta?", "https://site.getnet.com.br/duvidas/get-conta/?modal_open=38668");

    private final String searchText;
    private final String url;

    HelpCenterSearchResults(String searchText, String url) {
        this.searchText = searchText;
        this.url = url;
    }

    public String getSearchText() {
        return searchText;
    }

    public String getUrl() {
        return url;
    }

    public static String getUrlForText(String searchText) {
        for (HelpCenterSearchResults result : values()) {
            if (result.getSearchText().equals(searchText)) {
                return result.getUrl();
            }
        }
        throw new IllegalArgumentException("Erro: Valor invalido para resultado da pesquisa: " + searchText);
    }
}
