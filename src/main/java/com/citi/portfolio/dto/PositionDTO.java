package com.citi.portfolio.dto;

import com.citi.portfolio.model.Position;

import java.util.List;

public class PositionDTO {
    private List<Position> positions;
    private Long size;
    private Double currentCash;

    public Double getCurrentCash() {
        return currentCash;
    }

    public void setCurrentCash(Double currentCash) {
        this.currentCash = currentCash;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
