package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.PriceLike
import org.springframework.data.repository.CrudRepository

interface PriceLikeRepository : CrudRepository<PriceLike, Int>