package com.moczix.alkohunters.app.controller

import com.moczix.alkohunters.app.model.Alcohol
import com.moczix.alkohunters.app.persistence.AlcoholRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/alcohols")
class AlcoholController(val alcoholRepo: AlcoholRepository) {

    @GetMapping("/by-barcode/{barcode}")
    fun getByBarcode(@PathVariable barcode: String) = alcoholRepo.findByBarcode(barcode)

    @PostMapping
    fun addAlcohol(@RequestBody alcohol: Alcohol) =  alcoholRepo.save(alcohol)




    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/pending")
    fun getPending() = alcoholRepo.findByAccepted(0)

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/accepted")
    fun getAccepted() = alcoholRepo.findByAccepted(1)

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int) = alcoholRepo.findById(id)

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    fun updateAlcohol(@PathVariable id: Int, @RequestBody alcohol: Alcohol) {
        assert(alcohol.id == id)
        println(
                alcohol.updatedAt
        )
        alcoholRepo.save(alcohol)
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    fun removeAlcohol(@PathVariable id: Int) = alcoholRepo.deleteById(id)

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