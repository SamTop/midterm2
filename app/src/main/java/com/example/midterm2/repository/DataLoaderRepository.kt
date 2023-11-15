package com.example.midterm2.repository

import com.example.midterm2.retrofit.UsersApiService
import com.example.midterm2.retrofit.RetrofitHelper

class DataLoaderRepository {
    suspend fun loadUsers(): List<User> {
        val apiService = RetrofitHelper.getRetrofit().create(UsersApiService::class.java)
        return apiService.fetchUsers()
    }

}
