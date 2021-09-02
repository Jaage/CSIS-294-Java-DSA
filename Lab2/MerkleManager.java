public class MerkleManager {

    public static volatile String userWord;
    public static String expectedMerkleRoot;
    public static String MerkleRoot = null;
    public static int strikes = 0;

    Util util = new Util();

    public void manage() {
        expectedMerkleRoot = util.promptUser("Please enter your expected merkle root: ");

        MerkleThread merkle = new MerkleThread();
        Thread merkleThread = new Thread(merkle);
        merkleThread.start();


        RogueThread rogue = new RogueThread();
        Thread rogueThread = new Thread(rogue);
        rogueThread.start();

        MonitorThread monitor = new MonitorThread();
        Thread monitorThread = new Thread(monitor);
        monitorThread.start();

        while(true) {
            userWord = util.promptUser("Please enter a word: ");
        }
    }
    public static synchronized String grabWord() {
        String temp = userWord;
        userWord = null;
        return temp;
    }
}