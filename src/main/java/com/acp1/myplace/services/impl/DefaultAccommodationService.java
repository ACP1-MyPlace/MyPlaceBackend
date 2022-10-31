package com.acp1.myplace.services.impl;

import com.acp1.myplace.converters.impl.AccommodationConverter;
import com.acp1.myplace.converters.impl.AccommodationEntityConverter;
import com.acp1.myplace.converters.impl.AccommodationRequestConverter;
import com.acp1.myplace.domain.user.UserType;
import com.acp1.myplace.dto.accommodation.AccommodationRequest;
import com.acp1.myplace.dto.accommodation.AccommodationResponse;
import com.acp1.myplace.entities.AccommodationEntity;
import com.acp1.myplace.exceptions.AccommodationNotFoundException;
import com.acp1.myplace.exceptions.UserNotHostException;
import com.acp1.myplace.factories.QueryFactory;
import com.acp1.myplace.model.accommodation.Accommodation;
import com.acp1.myplace.model.accommodation.Query;
import com.acp1.myplace.model.user.User;
import com.acp1.myplace.repositories.AccommodationRepository;
import com.acp1.myplace.services.AccommodationService;
import com.acp1.myplace.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DefaultAccommodationService implements AccommodationService {

    @Autowired
    private AccommodationRequestConverter  accommodationRequestConverter;

    @Autowired
    private AccommodationEntityConverter accommodationEntityConverter;

    @Autowired
    private AccommodationConverter accommodationConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public AccommodationResponse createAccommodation(AccommodationRequest newAccommodation) {
        Accommodation accommodation = this.accommodationRequestConverter.apply(newAccommodation);
        User user = this.userService.getUserById(accommodation.getUser().getUserId());
        AccommodationEntity accommodationEntity = this.accommodationEntityConverter.revert(accommodation);
        if (!UserType.HOST_USER.equals(user.getType())){
            throw new UserNotHostException();
        }
        accommodationEntity.setUser(user);
        AccommodationEntity created = this.accommodationRepository.save(accommodationEntity);
        Accommodation accommodationCreated = this.accommodationEntityConverter.apply(created);
        return this.accommodationConverter.apply(accommodationCreated);
    }

    @Override
    public List<AccommodationResponse> getAccommodations(Pageable queryParams) {
        Query query = QueryFactory.create(queryParams);
        Page<AccommodationEntity> results = this.accommodationRepository.findAll(PageRequest.of(query.getPage(), query.getPageSize()));
        List<Accommodation> model = this.accommodationEntityConverter.apply(results.get().collect(Collectors.toList()));
        return this.accommodationConverter.apply(model);
    }

    @Override
    public AccommodationEntity getAccommodation(Long accommodationId) {
        return accommodationRepository.findById(accommodationId).orElseThrow(() -> new AccommodationNotFoundException());
    }

    @Override
    public AccommodationResponse updateAccommodation(Long accommodationId, AccommodationRequest update) {

        Accommodation accommodationUpdate = this.accommodationRequestConverter.apply(update);
        AccommodationEntity accommodationEntityUpdate = this.accommodationEntityConverter.revert(accommodationUpdate);
        accommodationEntityUpdate.setId(accommodationId);
        AccommodationEntity updated = this.accommodationRepository.save(accommodationEntityUpdate);
        Accommodation accommodationUpdated = this.accommodationEntityConverter.apply(updated);
        return this.accommodationConverter.apply(accommodationUpdated);
    }

    @Override
    public void deleteAccomodationById(Long accommodationId) {
        this.accommodationRepository.deleteById(accommodationId);
    }

    @Override
    public List<AccommodationResponse> getAccommodationsFromUser(User user) {
        List<Accommodation> model = this.accommodationEntityConverter.apply( this.accommodationRepository.findAll());
        model.removeIf(a -> a.getUser().getUserId() !=  user.getUserId() );
        return this.accommodationConverter.apply(model);
    }
}
