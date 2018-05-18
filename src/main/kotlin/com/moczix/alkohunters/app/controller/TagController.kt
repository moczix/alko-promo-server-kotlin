package com.moczix.alkohunters.app.controller

import com.moczix.alkohunters.app.persistence.TagRepository
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("tags")
class TagController(val tagRepo: TagRepository) {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    fun getAll() = tagRepo.findAll()
}