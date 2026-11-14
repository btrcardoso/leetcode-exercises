package leetcode;

public class IntegerToEnglishWords {

    private String[] LESS_THAN_20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] MORE_EQUALS_20 = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] AUXILIAR = new String[]{"", " Thousand", " Million", " Billion", " Trillion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) {
            int res = num % 1000;
            if (res > 0) {
                sb.insert(0, " " + transform(res) + AUXILIAR[i]);
            }

            num = num / 1000;
            i++;
        }

        return sb.toString().trim();
        
    }

    public String transform(int num) {
        if (num < 20) {
            return LESS_THAN_20[num];

        } else if (num >= 20 && num < 100) {
            int div = num / 10;
            int res = num % 10;
            return MORE_EQUALS_20[div] + (res > 0 ? (" " + transform(res)) : "");

        } else {
            int div = num / 100;
            int res = num % 100;
            return LESS_THAN_20[div] + " Hundred" + (res > 0 ? (" " + transform(res)) : "");
        }
    }
}

/*

1234567


res = num % 1000 = 567

division = num / 1000 = 1234;

if (division > 0)
do it again

num 1000000
res = num % 1000 = 0
division = num / 1000 = 1000;

num 1000
res = num % 1000 = 0
division = num / 1000 = 1000;




*/


/* 

    public String numberToWords(int num) {

        String str = String.valueOf(num);
        List<String> groups = new ArrayList<>();
        int end = str.length();
        for (end = str.length(); end > 0; end -= 3) {
            int start = end - 3;
            if (start < 0) {
                start = 0;
            }
            String group = str.substring(start, end);
            groups.add(group);
        }

        StringBuilder sb = new StringBuilder();

        Map<Integer, String> map = new HashMap<>();
        map.put(0,"");
        map.put(1," Thousand");
        map.put(2," Million");
        map.put(3," Billion");
        map.put(4," Trillion");

        int count = 0;
        for (String group : groups) {

            String result;
            if (group.length() == 3) {
                result = hundred(group.charAt(0), group.charAt(1), group.charAt(2));
            } else if (group.length() == 2) {
                result = ten(group.charAt(0), group.charAt(1));
            } else {
                result = unity(group.charAt(0));
            }

            if (!result.equals("")) {
                sb.insert(0, " " + result + map.get(count));
            }
            
            count++;
        }


        return sb.toString().trim();
        
    }

    public String hundred(char cen, char dec, char uni) {
        StringBuilder sb = new StringBuilder();

        if (cen != '0') {
            sb.append(unity(cen));
            sb.append(" Hundred");
        } 

        sb.append(" " + ten(dec, uni));

        return sb.toString().trim();

    }

    public String ten(char dec, char uni) {
        if (dec == '1') {
            Map<Character, String> map = new HashMap<>();
            map.put('0',"Ten"); 
            map.put('1',"Eleven"); 
            map.put('2',"Twelve");
            map.put('3',"Thirteen");
            map.put('4',"Fourteen");
            map.put('5',"Fifteen");
            map.put('6',"Sixteen");
            map.put('7',"Seventeen");
            map.put('8',"Eighteen");
            map.put('9',"Nineteen");

            return map.get(uni);
        } 

        StringBuilder sb = new StringBuilder();
        
        if (dec != '0')  {
            Map<Character, String> map = new HashMap<>();
            map.put('2',"Twenty");
            map.put('3',"Thirty");
            map.put('4',"Forty");
            map.put('5',"Fifty");
            map.put('6',"Sixty");
            map.put('7',"Seventy");
            map.put('8',"Eighty");
            map.put('9',"Ninety");

            sb.append(map.get(dec) + " ");
        }

        if (uni != '0') {
            sb.append(unity(uni));
        }

        return sb.toString().trim();

    }

    public String unity(char uni) {
        Map<Character, String> map = new HashMap<>();
        map.put('0',"Zero");
        map.put('1',"One");
        map.put('2',"Two");
        map.put('3',"Three");
        map.put('4',"Four");
        map.put('5',"Five");
        map.put('6',"Six");
        map.put('7',"Seven");
        map.put('8',"Eight");
        map.put('9',"Nine");

        return map.get(uni);
    }

*/