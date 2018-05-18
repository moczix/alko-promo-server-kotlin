package com.moczix.alkohunters.app.controller

import com.moczix.alkohunters.app.persistence.CategoryRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/categories")
class CategoryController(val categoryRepo: CategoryRepository) {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    fun getAll() = categoryRepo.findAll()

}