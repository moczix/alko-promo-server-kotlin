package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.Comment
import org.springframework.data.repository.CrudRepository

interface CommentRepository : CrudRepository<Comment, Int>