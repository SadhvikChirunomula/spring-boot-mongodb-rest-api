package com.example.restapi.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.model.AssetDataModel;

@Repository
public interface AssetDataDAO extends MongoRepository<AssetDataModel, Long> {

}
