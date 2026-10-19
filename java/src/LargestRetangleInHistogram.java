import java.util.Stack;

class Solution {

    class Bar {
        int first;     // representa a posição inicial do retangulo que tem essa altura 
        int height;    

        Bar (int first, int height) {
            this.first = first;
            this.height = height;
        }

    }

    public int largestRectangleArea(int[] h) {

        Stack<Bar> increasingBars = new Stack<>();
        increasingBars.add(new Bar(0, h[0]));

        int maxArea = 0;

        for (int i = 1; i <= h.length; i++) {
            int curFirst = i;
            int curHeight = i < h.length ? h[i] : 0; // dummy

            while (increasingBars.size() > 0 && increasingBars.peek().height > curHeight) {
                Bar peekBar = increasingBars.pop();
                maxArea = Math.max(maxArea, peekBar.height * (i - peekBar.first));

                curFirst = peekBar.first;
            }

            if (i < h.length) {
                increasingBars.add(new Bar(curFirst, curHeight));
            }
        }

        return maxArea;
        
    }

}