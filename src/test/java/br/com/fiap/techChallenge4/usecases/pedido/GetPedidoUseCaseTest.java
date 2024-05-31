package br.com.fiap.techChallenge4.usecases.pedido;

import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class GetPedidoUseCaseTest {

    @Mock
    private PedidoGateway pedidoGateway;

    private GetPedidoUseCase getPedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        getPedidoUseCase = new GetPedidoUseCase(pedidoGateway);
    }

    @Test
    void shouldReturnPedido_WhenIdExists() throws PedidoNotFoundException {

        Long id = 156L;
        Pedido pedido = new Pedido();
        pedido.setId(id);
        when(pedidoGateway.findById(id)).thenReturn(Optional.of(pedido));

        Pedido result = getPedidoUseCase.execute(id);

        assertEquals(pedido, result);
    }

    @Test
    void shouldThrowException_WhenIdDoesNotExist() {

        Long id = 203L;
        when(pedidoGateway.findById(id)).thenReturn(Optional.empty());

        assertThrows(PedidoNotFoundException.class, () -> {
            getPedidoUseCase.execute(id);
        });
    }
}