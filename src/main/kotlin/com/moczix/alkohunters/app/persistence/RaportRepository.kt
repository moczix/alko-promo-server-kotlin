package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Raport
import org.springframework.data.repository.CrudRepository

interface RaportRepository : CrudRepository<Raport, Int>