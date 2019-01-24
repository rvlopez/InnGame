package com.example.rviciana.inngame.data

import com.example.rviciana.inngame.data.dto.CraftCostDto
import com.example.rviciana.inngame.data.dto.IndustryDto
import com.example.rviciana.inngame.data.dto.ResourcesDto

class IndustryDataSource {

    private var resourcesDto: ResourcesDto = ResourcesDto(1500, 600, 0)
    private var industryDto: IndustryDto =
            IndustryDto(1,
            CraftCostDto(ResourcesDto(1500, 500, 0), 30),
            resourcesDto)

    fun availableResources(): IndustryDto {
        return this.industryDto
    }

    fun addResources() {
        val resources: ResourcesDto = this.industryDto.resourcesDto
        updateResources(ResourcesDto(
                resources.metal + 2000,
                resources.fibre + 1000,
                resources.gasoline + 20))
    }

    fun removeResources(resourcesDto: ResourcesDto) {
        updateResources(resourcesDto)
    }

    private fun updateResources(resourcesDto: ResourcesDto) {
        this.industryDto.resourcesDto = resourcesDto
    }

}