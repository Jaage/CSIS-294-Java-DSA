public class RogueThread implements Runnable {
    public void run() {
        Util util = new Util();

        while(true) {
            util.sleepRandomTime("RogueThread");
            String newWord = MerkleManager.grabWord();

            if (newWord != null) {
                MerkleManager.strikes += 1;
                System.out.println("STRIKE!");
                System.out.println("Rogue grabbed a thread!");
            }
        }
    }
}
