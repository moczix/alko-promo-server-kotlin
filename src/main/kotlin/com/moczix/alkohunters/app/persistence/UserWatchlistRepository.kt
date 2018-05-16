package com.moczix.alkohunters.app.persistence

import com.moczix.alkohunters.app.model.UserWatchlist
import org.springframework.data.repository.CrudRepository

interface UserWatchlistRepository : CrudRepository<UserWatchlist, Int>