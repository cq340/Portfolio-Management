package com.citi.portfolio.service.serviceInterface;

import com.citi.portfolio.model.Indices;

import java.util.Date;
import java.util.List;

public interface IndicesService {
    List<Indices> get(Date date);
}
