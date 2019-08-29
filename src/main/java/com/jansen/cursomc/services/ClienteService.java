package com.jansen.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jansen.cursomc.domain.Cliente;
import com.jansen.cursomc.dto.ClienteDTO;
import com.jansen.cursomc.repositories.ClienteRepository;
import com.jansen.cursomc.services.exceptions.DataIntegrityException;
import com.jansen.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	//Atualiza Cliente a partir do ID
		public Cliente update(Cliente obj) {
			Cliente newObj = find(obj.getId());
			updateData(newObj,obj);
			return repo.save(newObj);
		}
		
		//Deleta Cliente a partir do ID
		public void delete(Integer id) {
			find(id);
			
			try {
			repo.deleteById(id);
			}
			catch (DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
			} 
		}
		
		//Lista todas as Clientes
		public List<Cliente> findAll(){
			return repo.findAll();
		}
		
		//Serviço de paginação
		public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
		}
		
		public Cliente fromDTO(ClienteDTO objDTO) {
			return new Cliente(objDTO.getId(), objDTO.getNome(), objDTO.getEmail(), null, null);
		}
		
		private void updateData(Cliente newObj, Cliente obj) {
			newObj.setNome(obj.getNome());
			newObj.setEmail(obj.getEmail());
		}
}
