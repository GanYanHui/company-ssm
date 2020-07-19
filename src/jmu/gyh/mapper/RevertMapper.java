package jmu.gyh.mapper;

import java.util.List;

import jmu.gyh.po.Revert;

public interface RevertMapper {
	public List<Revert> findRevByMesID(int messageID);
	
	public void insertRev(Revert revert);
	
	public void deleteRev(int revertID);
}
