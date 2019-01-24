package com.example.rviciana.inngame.data

import com.example.rviciana.inngame.data.dto.IndustryDto
import com.example.rviciana.inngame.data.dto.ResourcesDto
import com.example.rviciana.inngame.domain.bo.CraftCost
import com.example.rviciana.inngame.domain.bo.Industry
import com.example.rviciana.inngame.domain.bo.Resources

class IndustryResourcesMapper {

    fun map(industryDto: IndustryDto): Industry =
            Industry(industryDto.level,
                    CraftCost(
                            Resources(
                                    industryDto.craftCost.resourcesDto.metal,
                                    industryDto.craftCost.resourcesDto.fibre,
                                    industryDto.craftCost.resourcesDto.gasoline
                            ),
                            industryDto.craftCost.craftTime
                    ),
                    Resources(
                            industryDto.resourcesDto.metal,
                            industryDto.resourcesDto.fibre,
                            industryDto.resourcesDto.gasoline
                    )
            )

}