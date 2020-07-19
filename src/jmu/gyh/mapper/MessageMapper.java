package jmu.gyh.mapper;

import java.util.List;

import jmu.gyh.po.Message;

public interface MessageMapper {
	public Message findMesByMesID(int messageID);
	
	public List<Message> findAllMes();
	
	public void insertMes(Message message);
	
	public void updateMesCountAdd(int messageID);
	
	public void updateMesCountSub(int messageID);
	
	public List<Message> findMesByLike(String string);
}
