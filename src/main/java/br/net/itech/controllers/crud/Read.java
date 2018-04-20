package br.net.itech.controllers.crud;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import br.net.itech.response.Response;

public interface Read<T> {
	/**
	 * Retrieve an entity by Id.
	 * 
	 * @param id
	 * @return ResponseEntity<Response<T>>
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<T>> read(@PathVariable("id") Integer id);

	public interface ReadAll<T> {

		/**
		 * Retrieves all entities associated with a table.
		 * 
		 * @param id
		 * @param page
		 * @param order
		 * @param dir
		 * @return ResponseEntity<Response<Page<T>>>
		 */
		ResponseEntity<Response<Page<T>>> readAll(@PathVariable("id") Integer id,
				@RequestParam(value = "page", defaultValue = "0") int page,
				@RequestParam(value = "order", defaultValue = "id") String order,
				@RequestParam(value = "dir", defaultValue = "DESC") String dir);
	}
}