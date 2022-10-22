package br.com.market.demands.service;

import br.com.market.demands.listener.UserListener;
import br.com.market.demands.model.Demand;
import br.com.market.demands.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemandService {

    private final DemandRepository demandRepository;

    private final UserListener userListener;

    @Autowired
    public DemandService(DemandRepository demandRepository, UserListener userListener) {
        this.demandRepository = demandRepository;
        this.userListener = userListener;
    }

    public Demand findDemandById(Long id) {
        return new Demand();
    }
}
