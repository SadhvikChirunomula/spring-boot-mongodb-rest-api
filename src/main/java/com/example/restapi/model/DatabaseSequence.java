package com.example.restapi.model;

import org.springframework.data.annotation.Id;

public class DatabaseSequence {
	
	@Id
    private String assetId;
 
    private long seq;

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "DatabaseSequence [assetId=" + assetId + ", seq=" + seq + "]";
	}
    
}
