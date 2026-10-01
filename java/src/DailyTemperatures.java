class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (stack.size() > 0 && temperatures[stack.peek()] < temperatures[i]) {
                Integer peek = stack.pop();
                result[peek] = i - peek;
            }
                
            stack.add(i);

        }

        return result;
        
    }



    /*
    30,38,30,36,35,40,28

    ---------------


    [0]=30, is the answer for no one                         stack = [0]=30
    [1]=38, is the answer for [0]=30                         stack = [1]=38
    [2]=30, is the answer for no one                         stack = [2]=30,[1]=38
    [3]=36, is the answer for [2]=30, but not for [1]=38     stack = [3]=36,[1]=38


    the stack is sorted in a way that the highest values will be left at the bottom at the pile
    the peeks will have lowest values, once you can pop one, you try to keep popping it to reach the bottom
    
    

    -------------------
    tem como o t[i] não ser resposta do stack.peek, mas ser resposta de quem está embaixo do stack.peek?

    Não, pois a pilha estaria assim:

    Seja t[2]=38

    Pilha: |t[1]=39|
           |t[0]=37|

    e isso não é possível, pois t[1]=39 já seria resposta do t[0]=37
    
    */















    public int[] dailyTemperatures_brute(int[] temperatures) {

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            int count = 0;

            for (int j = i+1; j < temperatures.length; j++) {

                if (temperatures[j] <= temperatures[i]) {
                    count++;
                } else {
                    result[i] = count + 1;
                    break;
                }

            }

        }

        return result;
        
    }
}


/*


Brute force: n²

i
    j=i...n-1 count until you reach a warmer day. Then save it





*/