package jmu.gyh.service;

import java.util.List;

import jmu.gyh.po.Message;

public interface MessageService {
	public Message findMesByMesID(int messageID);
	
	public List<Message> findAllMes();
	
	public void insertMes(Message message);
	
	public void updateMesCountAdd(int messageID);
	
	public void updateMesCountSub(int messageID);
	
	public List<Message> findMesByLike(String string);
}
