package com.pkielbasa.accountservice.application.utils;


import com.pkielbasa.accountservice.application.criteria.UserSearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class SortUserCriteriaUtils {
    private static final Set<String> ALLOWED_SORT_FIELDS = Arrays.stream(UserSearchCriteria.class.getDeclaredFields())
            .map(Field::getName)
            .collect(Collectors.toSet());

    public static Sort buildSort(String sortBy, String direction) {
            if(sortBy == null || sortBy.isEmpty() || !ALLOWED_SORT_FIELDS.contains(sortBy)) {
                log.warn("Invalid sort field: {}, unsorted list returned.", sortBy);
                return Sort.unsorted();
            }

            Sort.Direction dir =Sort.Direction.ASC;

            if(direction != null){
                try {
                    dir = Sort.Direction.fromString(direction.toUpperCase());
                } catch (IllegalArgumentException e) {
                    log.warn("Invalid sort argument: {}. Defaulting to ASC.", direction);
                }
            }
            return Sort.by(dir, sortBy);
    }
}
