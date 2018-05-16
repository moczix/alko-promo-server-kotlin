package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Rating
import org.springframework.data.repository.CrudRepository

interface RatingRepository: CrudRepository<Rating, Int>