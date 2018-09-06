import core.Block;
import core.BlockChain;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockChain blockChain=new BlockChain();
		blockChain.appendblock(Block.createnewBlock(blockChain.blocks[blockChain.length-1], "这是插入的第一个区块链"));
		blockChain.appendblock(Block.createnewBlock(blockChain.blocks[blockChain.length-1], "这是插入的二个区块链"));
		blockChain.show();
		
		

	}

}
