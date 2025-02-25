package com.nat.shorturl.url.internal;

import com.nat.shorturl.url.UrlCreateRequestDto;
import com.nat.shorturl.url.UrlDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
interface UrlMapper {
    Url toEntity(UrlDto urlInfoDto);

    UrlDto toDto(Url url);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Url partialUpdate(UrlDto urlInfoDto, @MappingTarget Url url);

    Url toEntity(UrlCreateRequestDto urlCreateRequestDto);

    UrlCreateRequestDto toDto1(Url url);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Url partialUpdate(UrlCreateRequestDto urlCreateRequestDto, @MappingTarget Url url);
}