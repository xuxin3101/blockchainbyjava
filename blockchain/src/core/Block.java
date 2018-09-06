package core;
import java.util.Date;
import org.apache.tomcat.util.security.MD5Encoder;
import tool.Md5Util;
public class Block {
	//���鶨��
	long timestamp;//ʱ���
	String data;//�������򣬼�Ϊstirng
	int index;//�����index
	String hash;//������hash
	String prehash;//��һ����hash
public static Block createnewBlock(Block oldblock,String data) {
	//�½�һ������
	Block newblock=new Block();
	newblock.data=data;
	newblock.index=oldblock.index+1;
	newblock.timestamp=new Date().getTime();
	newblock.prehash=oldblock.hash;
	newblock.hash=Md5Util.getMd5(newblock.data+newblock.index+newblock.timestamp);
	return newblock;
}
public static Block createfirstblock() {
	//������һ�����飬��Ϊǰһ����hashΪ�����Ե���д��
	Block newblock=new Block();
	newblock.index=-1;
	newblock.hash="";
	return createnewBlock(newblock, "this is the first block");
}

}
