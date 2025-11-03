package test.basic;

import java.util.Arrays;
import java.util.List;

import infra.DAO;
import models.basic.Product;

public class NewProductTest {
    public static void main(String[] args) {
        DAO<Product> productDao = new DAO<>(Product.class);

        List<Product> products = Arrays.asList(
                // --- ITENS DE ESCRITÓRIO/ESTUDO (1 a 10) ---
                new Product("Caderno Espiral A4", 19.90, 150),
                new Product("Caneta Gel Preta", 4.50, 300),
                new Product("Marca-Texto Amarelo", 7.85, 220),
                new Product("Estojo Simples", 12.00, 80),
                new Product("Mochila Reforçada", 150.00, 45),
                new Product("Grampeador Grande", 32.75, 55),
                new Product("Clipes para Papel (Cx)", 5.90, 600),
                new Product("Agenda 2026", 45.00, 70),
                new Product("Tesoura Escolar", 9.99, 210),
                new Product("Envelope Ofício (Pct 50)", 18.20, 180),

                // --- ITENS DE COZINHA (11 a 20) ---
                new Product("Jarra de Vidro 2L", 35.50, 60),
                new Product("Conjunto de Facas (6 pçs)", 125.99, 30),
                new Product("Pano de Prato Algodão", 8.20, 400),
                new Product("Liquidificador 800W", 189.90, 70),
                new Product("Jogo de Copos (4 un.)", 29.90, 110),
                new Product("Travessa de Porcelana", 58.00, 40),
                new Product("Batedeira Planetária", 399.99, 25),
                new Product("Abridor de Latas", 11.50, 90),
                new Product("Fôrma de Bolo Antiaderente", 45.90, 85),
                new Product("Tábua de Corte Bambu", 28.99, 130),

                // --- ITENS DE TECNOLOGIA (21 a 30) ---
                new Product("Cabo USB-C 1m", 15.00, 350),
                new Product("Fone de Ouvido Bluetooth", 89.90, 180),
                new Product("Suporte para Notebook", 55.00, 95),
                new Product("Carregador Portátil 10000mAh", 99.90, 120),
                new Product("Mouse Pad Ergonômico", 22.50, 250),
                new Product("Teclado Sem Fio Slim", 140.00, 65),
                new Product("Monitor Curvo 27''", 1999.00, 35),
                new Product("Webcam HD com Microfone", 79.99, 170),
                new Product("SSD Externo 500GB", 320.00, 50),
                new Product("Roteador Mesh Tri-Band", 490.50, 20),

                // --- ITENS DE HIGIENE/CUIDADOS PESSOAIS (31 a 40) ---
                new Product("Shampoo Cabelos Secos", 24.50, 190),
                new Product("Sabonete Líquido 500ml", 18.00, 210),
                new Product("Creme Dental 90g", 6.99, 450),
                new Product("Protetor Solar FPS 30", 49.90, 50),
                new Product("Escova de Dentes Macia", 10.50, 280),
                new Product("Desodorante Roll-On", 14.99, 320),
                new Product("Condicionador Reparador", 26.50, 160),
                new Product("Barbeador Elétrico", 130.00, 40),
                new Product("Fio Dental Menta", 8.70, 500),
                new Product("Loção Pós-Barba", 38.90, 75),

                // --- ITENS DIVERSOS/FERRAMENTAS (41 a 50) ---
                new Product("Kit Ferramentas Básico", 79.90, 60),
                new Product("Lanterna LED Recarregável", 45.00, 90),
                new Product("Pilha AA Recarregável (4 un.)", 60.00, 110),
                new Product("Extensão Elétrica 5m", 35.90, 140),
                new Product("Cadeado com Segredo", 25.00, 180),
                new Product("Cola Multiuso Forte", 10.99, 230),
                new Product("Fita Isolante Preta", 7.50, 310),
                new Product("Chave de Fenda Philips", 12.00, 260),
                new Product("Furadeira de Impacto", 250.00, 30),
                new Product("Trena Métrica 5m", 18.50, 155));

        products.forEach(product -> productDao.store(product));
        productDao.close();
    }
}
