package com.ramon.pereira.albumstore.resources.mapper.disc;

import com.ramon.pereira.albumstore.model.Disc;
import com.ramon.pereira.albumstore.resources.v1.dtos.disc.DiscResponseDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DiscMapper {

  public Optional<List<DiscResponseDto>> serializeList(@NonNull final Optional<List<Disc>> disks) {

    final var serializers = new ArrayList<DiscResponseDto>();

    disks.ifPresent(t -> t.forEach(disc -> {
      serializers.add(serialize(Optional.of(disc)).get());
    }));

    return Optional.of(serializers);
  }

  public Optional<DiscResponseDto> serialize(@NonNull final Optional<Disc> disc) {
    final Disc model = disc.get();
    return Optional.of(DiscResponseDto.builder()
        .id(model.getId())
        .name(model.getName())
        .price(model.getPrice())
        .createdAt(model.getCreatedAt())
        .build());
  }
}
