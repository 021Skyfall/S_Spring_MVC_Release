package com.jerry.slice.controller.order;

import com.jerry.exception.BusinessLogicException;
import com.jerry.helper.StubData;
import com.jerry.order.entity.Order;
import com.jerry.order.repository.OrderRepository;
import com.jerry.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class OrderServiceHomeworkTest {
    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    public void cancelOrderTest() {
        // given
        long orderId = 1L;
        Order order = StubData.MockOrder.getSingleResponseBody(orderId);

        // Stubbing by Mockito
        given(orderRepository.findById(orderId)).willReturn(Optional.of(order));

        // when
        Executable executable = () -> orderService.cancelOrder(orderId);

        // then
        assertThrows(BusinessLogicException.class, executable);
    }
}
