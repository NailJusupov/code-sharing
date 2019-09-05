package ru.study.codesharing.converters;

import org.mapstruct.Mapper;
import ru.study.codesharing.models.domain.GistsDAO;
import ru.study.codesharing.models.dto.GistsDTO;
import ru.study.codesharing.models.dto.GistsWithStarsDTO;

import java.util.List;

@Mapper
public interface GistMapper {
    GistsDAO toDAO(GistsDTO gistsDTO);

    List<GistsWithStarsDTO> toGistsWithStars(List<GistsDAO> gistsDAOList);

    List<GistsDTO> toDTOs(List<GistsDAO> gistsDAOList);
}
