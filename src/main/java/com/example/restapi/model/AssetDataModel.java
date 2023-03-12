package com.example.restapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "assetDatas")
public class AssetDataModel {

    public static final String SEQUENCE_NAME = "assetDatas_sequence";

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    @Id
    private Long assetId;
    private String description;
    private List<String> subJobs;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getSubJobs() {
        return subJobs;
    }

    public void setSubJobs(List<String> subJobs) {
        this.subJobs = subJobs;
    }



    @Override
    public String toString() {
        return "AssetDataModel [assetId=" + assetId + ", description=" + description + ", subJobs=" + subJobs + "]";
    }

}
