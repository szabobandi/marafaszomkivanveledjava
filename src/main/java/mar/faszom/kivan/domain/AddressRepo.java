package mar.faszom.kivan.domain;

import java.util.List;

public interface AddressRepo {

	public void add(Address address);
	public List<Address> getAllAddress();
	public void setSelected(Long id);
	public Address getSelected();
	public Long getSelectedId();
	public void delete(Long id);
	public Address findById(Long id);
	public void update(Address address);
}