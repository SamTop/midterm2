package com.example.midterm2.retrofit

import com.example.midterm2.repository.User
import com.example.midterm2.repository.UsersResponse
import retrofit2.http.GET

interface UsersApiService {
    @GET("/users")
    suspend fun fetchUsers(): List<User>
}
