package core;
import java.util.Date;
import org.apache.tomcat.util.security.MD5Encoder;
import tool.Md5Util;
public class Block {
	//区块定义
	long timestamp;//时间戳
	String data;//数据区域，简化为stirng
	int index;//区块的index
	String hash;//本区块hash
	String prehash;//上一区块hash
public static Block createnewBlock(Block oldblock,String data) {
	//新建一个区块
	Block newblock=new Block();
	newblock.data=data;
	newblock.index=oldblock.index+1;
	newblock.timestamp=new Date().getTime();
	newblock.prehash=oldblock.hash;
	newblock.hash=Md5Util.getMd5(newblock.data+newblock.index+newblock.timestamp);
	return newblock;
}
public static Block createfirstblock() {
	//创建第一个区块，因为前一区块hash为空所以单独写出
	Block newblock=new Block();
	newblock.index=-1;
	newblock.hash="";
	return createnewBlock(newblock, "this is the first block");
}

}
