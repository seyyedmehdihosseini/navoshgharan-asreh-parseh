package com.example_parseh.entity.mapper;

import java.util.List;

public interface BaseMapper<E, D> {
    E toEntity(D d);

    D toModel(E e);

    List<E> toListEntity(List<D> d);

    List<D> toListModel(List<E> e);
}
