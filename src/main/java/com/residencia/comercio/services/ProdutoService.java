package com.residencia.comercio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.comercio.entities.Produto;
import com.residencia.comercio.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> findAllProduto(){
		return produtoRepository.findAll();
	}
	
	public Produto findProdutoById(Integer id) {
		return produtoRepository.findById(id).isPresent() ?
				produtoRepository.findById(id).get() : null;
	}

	/*public ProdutoDTO findProdutoDTOById(Integer id) {
		Produto produto = produtoRepository.findById(id).isPresent() ?
				produtoRepository.findById(id).get() : null;
		
		ProdutoDTO produtoDTO = new ProdutoDTO();
		if(null != produto) {
			produtoDTO = converterEntidadeParaDto(produto);
		}
		return produtoDTO;
	}*/
	
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	/*public ProdutoDTO saveProdutoDTO(ProdutoDTO produtoDTO) {
			
		Produto produto = new Produto();
		
		produto.setIdProduto(produtoDTO.getIdProduto());
		Produto novoProduto = produtoRepository.save(produto);
		
		return converterEntidadeParaDto(novoProduto);
	}*/
	
	public Produto updateProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void deleteProduto(Integer id) {
		Produto inst = produtoRepository.findById(id).get();
		produtoRepository.delete(inst);
	}
	
	public void deleteProduto(Produto produto) {
		produtoRepository.delete(produto);
	}
	
	/*private Produto convertDTOToEntidade(ProdutoDTO produtoDTO){
		Produto produto = new Produto();
		
		produto.setIdProduto(produtoDTO.getIdProduto());
		return produto;
	}
		
	private ProdutoDTO converterEntidadeParaDto(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setIdProduto(produto.getIdProduto());
		return produtoDTO;
	}*/
}
