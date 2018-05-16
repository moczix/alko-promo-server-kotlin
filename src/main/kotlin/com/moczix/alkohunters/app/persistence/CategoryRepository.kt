package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Category
import org.springframework.data.repository.CrudRepository

interface CategoryRepository : CrudRepository<Category, Int>