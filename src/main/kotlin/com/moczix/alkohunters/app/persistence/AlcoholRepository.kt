package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Alcohol
import org.springframework.data.repository.CrudRepository
import java.util.*

interface AlcoholRepository : CrudRepository<Alcohol, Int> {
    fun findByBarcode(barcode: String): Optional<Alcohol>
}