package jmu.gyh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jmu.gyh.mapper.MessageMapper;
import jmu.gyh.po.Message;
import jmu.gyh.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Resource(name = "messageMapper")
	private MessageMapper messageMapper;

	@Override
	public Message findMesByMesID(int messageID) {
		return this.messageMapper.findMesByMesID(messageID);
	}
	
	@Override
	public List<Message> findAllMes() {
		return this.messageMapper.findAllMes();
	}

	@Override
	public void insertMes(Message message) {
		this.messageMapper.insertMes(message);
	}

	@Override
	public void updateMesCountAdd(int messageID) {
		this.messageMapper.updateMesCountAdd(messageID);
	}

	@Override
	public void updateMesCountSub(int messageID) {
		this.messageMapper.updateMesCountSub(messageID);
		
	}

	@Override
	public List<Message> findMesByLike(String string) {
		return this.messageMapper.findMesByLike(string);
	}

}
