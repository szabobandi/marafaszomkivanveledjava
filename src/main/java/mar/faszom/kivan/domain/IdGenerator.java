package mar.faszom.kivan.domain;

import org.springframework.stereotype.Service;

@Service
public class IdGenerator {

	static Long id = 0l;

	public Long nextId(String entity) {
		return id++;
	}
}
