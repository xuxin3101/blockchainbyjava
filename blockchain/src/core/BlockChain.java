package core;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
public class BlockChain {
	//����������
public 	Block[] blocks;//�������ڵ�
public	int length;//���鳤�ȣ�
public boolean appendblock(Block block) {//��block��ӵ���������
	if(length!=0) {//������ǵ�һ��������֤����ӣ�����ֱ�����
	if(yz(block)) {
		blocks[length++]=block;
	return true;
	}
	else {
		return false;
	}
	}
	else {
		blocks[length++]=block;
		return true;
	}
	
}
public BlockChain() {
	// TODO Auto-generated constructor stub
	blocks=new Block[1000];
	length=0;
	appendblock(Block.createfirstblock());
	
}
public void show(){
	for(int i=0;i<length;i++) {
	
		System.out.println("timestamp:"+blocks[i].timestamp+"\nindex:"+blocks[i].index+"\nhash:"+blocks[i].hash+"\nprehash:"+blocks[i].prehash+"\ndata:"+blocks[i].data+"\n");
	}
	
	
}
public boolean yz(Block block) {//��֤��ǰ�����Ƿ�Ϸ�
	if(block.index != blocks[length-1].index+1) {
		return false;
	}
	if(block.prehash !=blocks[length-1].hash) {
		return false;
	}
	return true;
}
public String netshow() {
	String result="";
	for(int i=0;i<length;i++) {
	result=result+"timestamp:"+blocks[i].timestamp+"<br />index:"+blocks[i].index+"<br />hash:"+blocks[i].hash+"<br />prehash:"+blocks[i].prehash+"<br />data:"+blocks[i].data+"<br />";
	}
	
return result;
}
	

}
