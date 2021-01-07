package com.dsdeliver.services;

import com.dsdeliver.dto.OrderDTO;
import com.dsdeliver.dto.ProductDTO;
import com.dsdeliver.entity.Order;
import com.dsdeliver.entity.Product;
import com.dsdeliver.enumerator.OrderStatus;
import com.dsdeliver.repository.OrderRepository;
import com.dsdeliver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)//Apenas leitura
    public List<OrderDTO> findAll() {
        List<Order> list = orderRepository.findOrdersWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        //Instanciando um novo Order
        Order order = new Order(null,dto.getAddress(),dto.getLatitude(),dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
        //Percorrendo cada Product recebido
        for (ProductDTO p : dto.getProducts()) {
            Product product = productRepository.getOne(p.getId());//Pegar a referencia da entidade.
            order.getProducts().add(product);
        }
        //Salvando
        order = orderRepository.save(order);
        //Convertendo e retornando como DTO
        return new OrderDTO(order);
    }

}
