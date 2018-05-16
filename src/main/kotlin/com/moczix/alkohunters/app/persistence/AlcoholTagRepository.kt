package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.AlcoholTag
import org.springframework.data.repository.CrudRepository

interface AlcoholTagRepository : CrudRepository<AlcoholTag, Int>