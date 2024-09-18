package com.fia.avance2.models.service;

import java.util.List;

import com.fia.avance2.model.entity.PNFoodsEntity;

public interface IPNFoodsService {

	public List<PNFoodsEntity> findAll();

    public void save(PNFoodsEntity pedido);
	
	public PNFoodsEntity findOne(Long id);
	
	public void delete(Long id); 
}
