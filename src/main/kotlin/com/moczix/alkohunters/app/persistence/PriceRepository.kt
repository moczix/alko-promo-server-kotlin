package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Price
import org.springframework.data.repository.CrudRepository

interface PriceRepository : CrudRepository<Price, Int>