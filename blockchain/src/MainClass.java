import core.Block;
import core.BlockChain;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockChain blockChain=new BlockChain();
		blockChain.appendblock(Block.createnewBlock(blockChain.blocks[blockChain.length-1], "���ǲ���ĵ�һ��������"));
		blockChain.appendblock(Block.createnewBlock(blockChain.blocks[blockChain.length-1], "���ǲ���Ķ���������"));
		blockChain.show();
		
		

	}

}
