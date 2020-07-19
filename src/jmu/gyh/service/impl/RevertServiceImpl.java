package jmu.gyh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmu.gyh.mapper.RevertMapper;
import jmu.gyh.po.Revert;
import jmu.gyh.service.RevertService;

@Service
@Transactional
public class RevertServiceImpl implements RevertService {

	@Resource(name = "revertMapper")
	private RevertMapper revertMapper;

	@Override
	public List<Revert> findRevByMesID(int messageID) {
		return this.revertMapper.findRevByMesID(messageID);
	}

	@Override
	public void insertRev(Revert revert) {
		this.revertMapper.insertRev(revert);
	}

	@Override
	public void deleteRev(int revertID) {
		this.revertMapper.deleteRev(revertID);
	}

}
