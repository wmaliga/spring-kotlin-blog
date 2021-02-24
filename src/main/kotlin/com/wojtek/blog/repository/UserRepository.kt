package com.wojtek.blog.repository

import com.wojtek.blog.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>
