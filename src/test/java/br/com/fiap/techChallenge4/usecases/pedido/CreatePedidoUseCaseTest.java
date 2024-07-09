package br.com.fiap.techChallenge4.usecases.pedido;

import br.com.fiap.techChallenge4.entities.pedido.gateway.PedidoGateway;
import br.com.fiap.techChallenge4.entities.pedido.model.Pedido;
import br.com.fiap.techChallenge4.usecases.pedido.dto.IPedidoRegistrationData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CreatePedidoUseCaseTest {

    @Mock
    private PedidoGateway pedidoGateway;

    private CreatePedidoUseCase createPedidoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createPedidoUseCase = new CreatePedidoUseCase(pedidoGateway );
    }

    @Test
    void shouldCreatePedido_WhenRegistrationDataIsValid() {
        // Arrange
        IPedidoRegistrationData registrationData = mock(IPedidoRegistrationData.class);
        when(registrationData.client()).thenReturn( Long.valueOf( 1 ) );
        when(registrationData.orderDate()).thenReturn( LocalDate.from( LocalDate.now()));
        when(registrationData.totalValue()).thenReturn( BigDecimal.valueOf(100.0));

        Pedido pedido = new Pedido(Long.valueOf( 1 ) , Long.valueOf( 1 ) , 15,LocalDate.now(), BigDecimal.valueOf( 100.0 ));
        when(pedidoGateway.create(any())).thenReturn(pedido);

        // Act
        Pedido createdPedido = createPedidoUseCase.execute(registrationData);

        // Assert
        assertEquals(pedido, createdPedido);
        verify(pedidoGateway, times(1)).create(any());
    }

    //@Test
    void shouldThrowException_WhenRegistrationDataIsInvalid() {
        // Arrange
        MockitoAnnotations.openMocks(this);
        createPedidoUseCase = new CreatePedidoUseCase(pedidoGateway );
        IPedidoRegistrationData registrationData = mock(IPedidoRegistrationData.class);
        when(registrationData.client()).thenReturn(null);
        when(registrationData.orderDate()).thenReturn(LocalDate.from( LocalDate.now()));
        when(registrationData.totalValue()).thenReturn(BigDecimal.valueOf(100.0));

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            createPedidoUseCase.execute(registrationData);
        });
    }
}