package br.com.fiap.techChallenge4.usecases.pedido;

import br.com.fiap.techChallenge4.entities.pedido.exception.PedidoNotFoundException;
import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.infraestructure.pedido.dto.PedidoUpdateData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UpdatePedidoUseCaseTest {

    @Mock
    private PedidoGateway pedidoGateway;

    private UpdatePedidoUseCase updatePedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updatePedidoUseCase = new UpdatePedidoUseCase(pedidoGateway);
    }

    //@Test
    void shouldUpdatePedido_WhenIdExists() throws PedidoNotFoundException {

        Long id = 5986L;
        Pedido existingPedido = new Pedido();
        existingPedido.setId(id);
        PedidoUpdateData updateData = new PedidoUpdateData( Optional.of( Long.valueOf( 1 ) ), Optional.of( Long.valueOf( 1 ) ), Optional.of( 15 ) ,Optional.ofNullable( LocalDate.from( LocalDate.now() ) ), Optional.of( BigDecimal.valueOf( 100.0 ) ) );
//        updateData.setNameClient(Optional.of("New Client"));
//        updateData.setOrderDate(Optional.of(LocalDate.now()));
//        updateData.setTotalValue(Optional.of(BigDecimal.valueOf(150)));
        updateData.client();

        when(pedidoGateway.findById(id)).thenReturn(Optional.of(existingPedido));

        Pedido updatedPedido = updatePedidoUseCase.execute(id, updateData);

        assertEquals(Long.valueOf( 1 ) , updatedPedido.getClient());
        assertEquals(LocalDate.now(), updatedPedido.getOrderDate());
        assertEquals(BigDecimal.valueOf(100), updatedPedido.getTotalValue());
        verify(pedidoGateway, times(1)).update(existingPedido);
    }

    @Test
    void shouldThrowException_WhenIdDoesNotExist() {

        Long id = 964L;
        PedidoUpdateData updateData = new PedidoUpdateData( Optional.of( Long.valueOf( 1 )  ), Optional.of( Long.valueOf( 1 ) ), Optional.of( 15 ) ,Optional.ofNullable( LocalDate.from( LocalDate.now() ) ), Optional.of( BigDecimal.valueOf( 100.0 ) ) );
//        updateData.setNameClient(Optional.of("New Client"));
//        updateData.setOrderDate(Optional.of(LocalDate.now()));
//        updateData.setTotalValue(Optional.of(BigDecimal.valueOf(100)));

        when(pedidoGateway.findById(id)).thenReturn(Optional.empty());

        assertThrows(PedidoNotFoundException.class, () -> {
            updatePedidoUseCase.execute(id, updateData);
        });
        verify(pedidoGateway, never()).update(any());
    }
}