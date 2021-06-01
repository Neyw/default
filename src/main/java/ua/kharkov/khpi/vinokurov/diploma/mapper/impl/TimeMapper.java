package ua.kharkov.khpi.vinokurov.diploma.mapper.impl;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.sql.Time;
import java.time.LocalTime;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public class TimeMapper {
    @Named("localToSqlTime")
    Time map(LocalTime localTime) {
        return Time.valueOf(localTime);
    }

    @Named("sqlToLocalTime")
    LocalTime map(Time time) {
        return time.toLocalTime();
    }
}
