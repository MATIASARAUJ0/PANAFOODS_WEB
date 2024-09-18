package com.fia.avance2.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fia.avance2.model.dao.IPNFoodsDAO;
import com.fia.avance2.model.entity.PNFoodsEntity;

@Service
public class PNFoodsServiceImpl implements IPNFoodsService {

	@Autowired
	private IPNFoodsDAO pedidoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<PNFoodsEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<PNFoodsEntity>) pedidoDao.findAll();
	}
	
	@Override
	@Transactional
	public void save(PNFoodsEntity pedido) {
		// TODO Auto-generated method stub
		pedidoDao.save(pedido);
	}

	@Override
	@Transactional(readOnly = true)
	public PNFoodsEntity findOne(Long id) {
		// TODO Auto-generated method stub
		return pedidoDao.findById(id).orElseGet(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		pedidoDao.deleteById(id);
	}
}
