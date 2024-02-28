package estudos.java.testesRabbitMQ.dto;

public class PagamentoDto {

    private String numeroPedido;
    private int valor;
    private String produto;

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = String.valueOf(numeroPedido);
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public int getValor() {
        return valor;
    }

    public String getProduto() {
        return produto;
    }
}
