package mar.faszom.kivan.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

public class InMemoryAddressRepo implements AddressRepo {

	@Autowired
	private IdGenerator idGenerator;

	private Map<Long, Address> addressMap = new HashMap<Long, Address>();
	private Long selctedId;

	@PostConstruct
	public void init() {
		Address selected = add("Futo ucta 47.", "1082");
		setSelected(selected.getId());

		add("Futrinka utca", "1333");
		add("Harap utca 3.", "1888");
	}

	private Address add(String street, String zip) {
		Address next = new Address(idGenerator.nextId("Address"),street, "Budapest", zip);
		add(next);
		return next;
	}

	@Override
	public void add(Address address) {
		addressMap.put(address.getId(), address);

	}

	@Override
	public List<Address> getAllAddress() {
		ArrayList<Address> ret = new ArrayList<Address>();
		for (Address next : addressMap.values()) {
			ret.add(next);
		}
		return ret ;
	}

	@Override
	public void setSelected(Long id) {
		this.selctedId = id;
	}

	@Override
	public Address getSelected() {
		return addressMap.get(selctedId);
	}

	@Override
	public Long getSelectedId() {
		return this.selctedId;
	}

	@Override
	public void delete(Long id) {
		addressMap.remove(id);
	}

	@Override
	public Address findById(Long id) {

		return addressMap.get(id);
	}
	
	public void update(Address address) {
		delete(address.getId());
		add(address);		
	}

}
