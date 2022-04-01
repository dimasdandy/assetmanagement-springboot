package com.springboot.assetmanagement.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_detail_transactions_in")
public class DetailTransactionIn extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "id_transaction_in", referencedColumnName = "id")
	@ManyToOne
	private TransactionIn transactionIn;
	
	@JoinColumn(name = "id_asset", referencedColumnName = "id")
	@ManyToOne	
	private Asset asset;

	@JoinColumn(name = "id_asset_condition", referencedColumnName = "id")
	@ManyToOne	
	private AssetCondition assetCondition;

	public TransactionIn getTransactionIn() {
		return transactionIn;
	}

	public void setTransactionIn(TransactionIn transactionIn) {
		this.transactionIn = transactionIn;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public AssetCondition getAssetCondition() {
		return assetCondition;
	}

	public void setAssetCondition(AssetCondition assetCondition) {
		this.assetCondition = assetCondition;
	}
	
}
