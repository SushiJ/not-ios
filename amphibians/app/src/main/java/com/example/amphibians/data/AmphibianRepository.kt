package com.example.amphibians.data

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.AmphibianApiService

interface AmphibianRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class DefaultAmphibianRepository(
    private val amphibianApiService: AmphibianApiService
): AmphibianRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibianApiService.getAmphibians()
}
