package com.example.rviciana.inngame.data

import com.example.rviciana.inngame.data.dto.ResourcesDto

class IndustryDataSource {

    private var resourcesDto: ResourcesDto = ResourcesDto(1500, 600, 20)

    fun availableResources(): ResourcesDto {
        return this.resourcesDto
    }

    fun addResources() {
        val resources: ResourcesDto = this.resourcesDto
        updateResources(ResourcesDto(resources.metal, resources.fibre, resources.gasoline))

    }

    fun removeResources(resourcesDto: ResourcesDto) {
        updateResources(resourcesDto)
    }

    private  fun updateResources(resourcesDto: ResourcesDto) {
        this.resourcesDto = resourcesDto
    }

}