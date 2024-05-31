package br.com.fiap.techChallenge4.usecases.pedido;


import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoUpdateData;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UpdatePedidoUseCase {
    private final PedidoGateway pedidoGateway;

    public UpdatePedidoUseCase(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public Pedido execute(Long id, PedidoUpdateData updateData) throws PedidoNotFoundException {
        Pedido pedido = pedidoGateway.findById(id).orElseThrow( PedidoNotFoundException::new);
        updatePropertyIfPresent( pedido::setNameClient, updateData::nameClient);
        updatePropertyIfPresent( pedido::setNameProduct, updateData::nameProduct);
        updateQtdefPresent( pedido::setQtde, updateData::qtde);
        updateOrderDateIfPresent( pedido::setOrderDate, updateData::orderDate);
        updateValueIfPresent( pedido::setTotalValue, updateData::totalValue );

        return this.pedidoGateway.update( pedido );
    }

    private void updatePropertyIfPresent(Consumer<String> setter, Supplier<Optional<String>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

    private void updateOrderDateIfPresent(Consumer<LocalDate> setter, Supplier<Optional<LocalDate>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

    private void updateValueIfPresent(Consumer<BigDecimal> setter, Supplier<Optional<BigDecimal>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }

    private void updateQtdefPresent(Consumer<Integer> setter, Supplier<Optional<Integer>> valueSupplier) {
        valueSupplier.get().ifPresent(setter);
    }
}
