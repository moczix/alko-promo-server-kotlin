package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Tag
import org.springframework.data.repository.CrudRepository

interface TagRepository : CrudRepository<Tag, Int>