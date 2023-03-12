package com.example.restapi.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.dao.AssetDataDAO;
import com.example.restapi.model.AssetDataModel;
import com.example.restapi.service.SequenceGeneratorService;

@RestController
@RequestMapping("/api")
@Api(value = "AssetData", description = "API's related to AssetData")
public class AssetDataController {

	@Autowired
	AssetDataDAO assetDataDAO;
	
	@Autowired
	SequenceGeneratorService seqGeneratorService;
	
	@PostMapping("/create")
	public AssetDataModel create(@RequestBody AssetDataModel newAssetDataObject) {
		newAssetDataObject.setAssetId(seqGeneratorService.generateSequence(AssetDataModel.SEQUENCE_NAME));
		return assetDataDAO.save(newAssetDataObject);
	}
	
	@GetMapping("/read")
	public List<AssetDataModel> read(){
		return assetDataDAO.findAll();
	}
	
	@GetMapping("/read/{assetId}")
	public AssetDataModel read(@PathVariable Long assetId) {
		Optional<AssetDataModel> assetDataObj = assetDataDAO.findById(assetId);
		if(assetDataObj.isPresent()) {
			return assetDataObj.get();
		}else {
			throw new RuntimeException("AssetData not found with assetId "+assetId);
		}
	}
	
	@PutMapping("/update")
	public AssetDataModel update(@RequestBody AssetDataModel modifiedAssetDataObject) {
		return assetDataDAO.save(modifiedAssetDataObject);
	}
	
	@DeleteMapping("/delete/{assetId}")
	public String delete(@PathVariable Long assetId) {
		Optional<AssetDataModel> assetDataObj = assetDataDAO.findById(assetId);
		if(assetDataObj.isPresent()) {
			assetDataDAO.delete(assetDataObj.get());
			return "AssetData deleted with assetId "+assetId;
		}else {
			throw new RuntimeException("AssetData not found for assetId "+assetId);
		}
	}
	
}
