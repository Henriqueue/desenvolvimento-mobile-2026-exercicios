data class Produto(
    val nome: String,
    var preco: Double,
    var estoque: Int
) {

    fun vender(quantidade: Int) {
        if (quantidade <= 0) {
            println("❌ Quantidade inválida para venda: $quantidade")
            return
        }

        if (estoque >= quantidade) {
            estoque -= quantidade
            println("✅ Venda realizada: $quantidade unidade(s) de $nome")
        } else {
            println("⚠️ Estoque insuficiente para $nome. Disponível: $estoque")
        }
    }

    fun repor(quantidade: Int) {
        if (quantidade <= 0) {
            println("❌ Quantidade inválida para reposição: $quantidade")
            return
        }

        estoque += quantidade
        println("📦 Reposição realizada: +$quantidade unidade(s) de $nome")
    }

    fun exibirInfo() {
        println("🛒 Produto: $nome | Preço: R$ ${"%.2f".format(preco)} | Estoque: $estoque")
    }
}

fun main() {

    val produtos = listOf(
        Produto("Mouse Gamer", 129.90, 10),
        Produto("Teclado Mecânico", 349.99, 5),
        Produto("Headset", 199.50, 8),
        Produto("Monitor 24\"", 899.00, 3),
        Produto("Mousepad", 39.90, 20)
    )

    println("📋 ESTOQUE INICIAL")
    produtos.forEach { it.exibirInfo() }

    println("\n💸 TESTANDO VENDAS")
    produtos[0].vender(2)    // Mouse Gamer
    produtos[1].vender(10)   // Estoque insuficiente
    produtos[2].vender(1)

    println("\n📦 TESTANDO REPOSIÇÃO")
    produtos[1].repor(5)     // Teclado Mecânico
    produtos[3].repor(2)     // Monitor

    println("\n📋 ESTOQUE FINAL")
    produtos.forEach { it.exibirInfo() }
}