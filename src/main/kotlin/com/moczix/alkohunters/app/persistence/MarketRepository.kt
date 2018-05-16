package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Market
import org.springframework.data.repository.CrudRepository

interface MarketRepository : CrudRepository<Market, Int>