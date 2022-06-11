package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value="SELECT products.name " +
            "FROM products " +
            "INNER JOIN providers on products.id_providers = providers.id " +
            "WHERE products.amount between :min AND :max " +
            "AND providers.name LIKE CONCAT(:beginName, '%') ")
    List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

    @Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) " +
            "FROM Product obj " +
            "WHERE obj.amount between :min AND :max " +
            "AND obj.provider.name LIKE CONCAT(:beginName, '%') ")
    List<ProductMinDTO> search2(Integer min, Integer max, String beginName);

}
