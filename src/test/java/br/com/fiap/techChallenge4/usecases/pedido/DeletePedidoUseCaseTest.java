package br.com.fiap.techChallenge4.usecases.pedido;
import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DeletePedidoUseCaseTest {

    @Mock
    private PedidoGateway pedidoGateway;

    private DeletePedidoUseCase deletePedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deletePedidoUseCase = new DeletePedidoUseCase(pedidoGateway);
    }

    @Test
    void shouldDeletePedido_WhenIdIsValid() throws PedidoNotFoundException {

        Long id = 321L;
        Pedido pedido = new Pedido();
        pedido.setId(id);
        when(pedidoGateway.findById(id)).thenReturn(Optional.of(pedido));

        deletePedidoUseCase.execute(id);

        verify(pedidoGateway, times(1)).delete(id);
    }

    @Test
    void shouldThrowException_WhenPedidoNotFound() {

        Long id = 123456L;
        when(pedidoGateway.findById(id)).thenReturn(Optional.empty());

        assertThrows(PedidoNotFoundException.class, () -> {
            deletePedidoUseCase.execute(id);
        });
        verify(pedidoGateway, never()).delete(id);
    }
}