package ra.edu.service;

import ra.edu.model.PaginationResult;

public interface PaginationService<T> {
    PaginationResult<T> getPaginationData(T item, int size, int current);
}
