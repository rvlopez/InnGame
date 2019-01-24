package com.example.rviciana.inngame.data

import com.example.rviciana.inngame.data.dto.ResourcesDto
import com.example.rviciana.inngame.domain.bo.Resources

class IndustryResourcesMapper {

    fun map(resourcesDto: ResourcesDto): Resources =
            Resources(resourcesDto.metal,
                    resourcesDto.fibre,
                    resourcesDto.gasoline)

}