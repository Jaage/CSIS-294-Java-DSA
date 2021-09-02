import java.util.ArrayList;

public class MerkleThread implements Runnable {
    
    public static volatile ArrayList<String> words;
    private int MerkleTreeInputs = 4;

    public void run() {
        Util util = new Util();
        words = new ArrayList<String>();

        while(true) {
            util.sleepRandomTime("MerkleThread");
            String newWord = MerkleManager.grabWord();

            if (newWord != null) {
                System.out.println("Merkle grabbed a word!");
                words.add(newWord);

                if (words.size() == MerkleTreeInputs) {
                    MerkleManager.MerkleRoot = util.getMerkleRoot(words);
                }
            }
        }
    }
}
