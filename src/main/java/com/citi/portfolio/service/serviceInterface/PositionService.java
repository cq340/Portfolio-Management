package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.dto.PositionDTO;
import com.citi.portfolio.model.Position;
import com.citi.portfolio.model.PositionExample;


public interface PositionService {
    Boolean add(Position position, String type);
    Boolean sell(Position position, String type);
    PositionDTO getPositions(Integer portId, Integer from, Integer size, String... args);
    Double calValue(Position position);
    Double calInitValue(Position position);
    Double getCurPrice(Position position);
    Position getById(Integer positionId);
    PositionDTO getByExample(PositionExample positionExample);
}