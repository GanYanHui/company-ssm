package jmu.gyh.service;

import java.util.List;

import jmu.gyh.po.Revert;

public interface RevertService {
	public List<Revert> findRevByMesID(int messageID);
	
	public void insertRev(Revert revert);
	
	public void deleteRev(int revertID);
}
