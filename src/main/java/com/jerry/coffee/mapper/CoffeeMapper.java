package com.jerry.coffee.mapper;

import com.jerry.coffee.dto.CoffeePatchDto;
import com.jerry.coffee.dto.CoffeePostDto;
import com.jerry.coffee.dto.CoffeeResponseDto;
import com.jerry.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffeePostDtoToCoffee(CoffeePostDto coffeePostDto);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDto coffeePatchDto);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);
    List<CoffeeResponseDto> coffeesToCoffeeResponseDtos(List<Coffee> coffees);
}
