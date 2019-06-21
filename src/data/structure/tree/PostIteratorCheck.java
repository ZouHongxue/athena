package data.structure.tree;

/**
 * @Author: coffee
 */
public class PostIteratorCheck {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return verify(sequence, 0, sequence.length - 1, true);
    }

    private boolean verify(int[] sequence, int head, int tail, boolean flag) {
        if(head >= tail) {
            return true;
        }
        int index = tail - 1;
        while (index > 0 && sequence[index] >= sequence[tail]) {
            index--;
        }
        for(int i = 0; i < index; i++) {
            if (sequence[i] > sequence[tail]) {
                return false;
            }
        }
        //verify left
        flag = flag && verify(sequence, 0, index, flag);
        //verify right
        flag = flag && verify(sequence, index + 1, tail - 1, flag);
        return flag;
    }

    public static void main(String[] args) {
        PostIteratorCheck p = new PostIteratorCheck();
        p.VerifySquenceOfBST(new int[]{5,4,3,2,1});
    }
}
