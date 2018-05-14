package com.moczix.alkohunters.app.controller

import com.moczix.alkohunters.app.model.Alcohol
import com.moczix.alkohunters.app.persistence.AlcoholRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/alcohols")
class AlcoholController(val alcoholRep: AlcoholRepository) {

    @GetMapping("/by-barcode/{barcode}")
    fun getById(@PathVariable barcode: String) = alcoholRep.findByBarcode(barcode)

    @PostMapping
    fun addAlcohol(@RequestBody alcohol: Alcohol)
            =  alcoholRep.save(alcohol)

    @GetMapping("/test")
    fun test() = {

    }
/*
    @PostMapping
    fun addCustomer(@RequestBody customer: Customer)
            = repository.save(customer)

    @PutMapping("/{id}")
    fun updateCustomer(@PathVariable id: Long, @RequestBody customer: Customer) {
        assert(customer.id == id)
        repository.save(customer)
    }

    @DeleteMapping("/{id}")
    fun removeCustomer(@PathVariable id: Long)
            = repository.delete(id)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long)
            = repository.findOne(id)

            */
}