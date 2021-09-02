public class MonitorThread implements Runnable {
    public void run() {
        Util util = new Util();
        while(true) {
            if (MerkleManager.MerkleRoot != null) {
                if (MerkleManager.MerkleRoot.equals(MerkleManager.expectedMerkleRoot)) {
                    System.out.println("You win: " + MerkleManager.MerkleRoot);
                    System.exit(0);
                } 
                else {
                    System.out.println("Your merkle root is different than expected");
                    System.out.println("Expected: " + MerkleManager.expectedMerkleRoot + " vs Yours: " + MerkleManager.MerkleRoot);
                    System.out.println("You lose");
                    System.exit(0);
                }
            } 
            else {
                if (MerkleManager.strikes == 3) {
                    System.out.println("3 strikes: You're outta here!");
                    System.exit(0);
                }
            }
            util.sleep(1);
        }
    }
}