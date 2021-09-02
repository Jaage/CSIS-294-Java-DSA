import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Util {

    public String getMerkleRoot(ArrayList<String> words) {

        MerkleNode node1 = new MerkleNode();
        MerkleNode node2 = new MerkleNode();
        MerkleNode node3 = new MerkleNode();
        MerkleNode node4 = new MerkleNode();
        MerkleNode node5 = new MerkleNode();
        MerkleNode node6 = new MerkleNode();
        MerkleNode node7 = new MerkleNode();

        node1.hash = generateHash(words.get(0));
        node2.hash = generateHash(words.get(1));
        node3.hash = generateHash(words.get(2));
        node4.hash = generateHash(words.get(3));

        populateMerkleNode(node5, node1, node2);
        populateMerkleNode(node6, node3, node4);
        populateMerkleNode(node7, node5, node6);

        return node7.hash;
    }

    private void populateMerkleNode(MerkleNode parent, MerkleNode leftChild, MerkleNode rightChild) {
        parent.left = leftChild;
        parent.right = rightChild;
        parent.hash = generateHash(parent.left.hash + parent.right.hash);
    }

    public synchronized String generateHash(String sOriginal) {
        
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(sOriginal.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
        
            for (int i = 0; i < btEncodedhash.length; i++) {
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();

        }
        
        catch(Exception ex) {
            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

    public String promptUser(String prompt) {
        String answer = JOptionPane.showInputDialog(prompt);
        return answer;
    }

    public void sleepRandomTime(String sThreadName) {
        // Gets random number between 0 and 5 and then adds 3, meaning between 3 and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;
        
        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch(Exception e) {}
    }

}