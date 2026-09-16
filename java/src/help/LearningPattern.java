package help;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearningPattern {
    public static void main(String[] args) {

        /*
        String input1 = "GFGFGFG";
        Pattern p1 = Pattern.compile("GFG");
        Matcher m1 = p1.matcher(input1);

        while (m1.find()) {
            System.out.println(m1.group());
            System.out.println(m1.start());
            System.out.println(m1.end());
        }
            */


        // -----------------------------------

        String line = 
        // "<Amee>safat codes like a ninja</amee>";
        // "<SA premium>Imtiaz has a secret crash</SA premium>";
        // "<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        "qqoNVOmJDG@6IBDZoEmk9337LswEL&TQnLCuR`04XD%1t{G)Jmi_iNEXKwp&<iBKMbDGtF4v@coLsF1_LqgTJ3cSp& 3a~I&Q(j0h_w~Vk(oBZCL#vhYY9%c><wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>bMUGux)5n7L={M}e^`0xlSm5ce}ehiE}CJ6y0KPd~~B~ak5$PTdPGv}QnXpw6n9V8wVCVaTRTgLKkeF</wkjkTvAuA8Zk}n_l7Si\"-pfm`M8YE3F}4`YQyChgC3uRbyTvu>haZQKlWPxlRqXXkKHo=FDofc6$_S-GWA&m0zT*D~uorf_nAF^ym*U&6hGAI)s<XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><FbTSC#F104{py9Xl6s{yi-R~}k5Fv4i1kCgmBY7P=vVj-j48xUg8x9BCxl~Y><lyxRRMqnMBGj1_d7Qqh5Ebn7 aMb{Q0Dm){9~I0DTS8BZ7+bui~)rQ\"2Yb4f>EeZWvJvHIk</XshvNhnnNbeVDuxRcQAgTpWZ-kqIps-@@}Uwq0J3Z06Y5mZgB9><BkkZV631Pnj}#%TWhZn@Y><kXjDpTvLA^tnXYb`h+cA J2";

        /*   \\1 serve pra verificar se repetiu quem está no primeiro parenteses (1° grupo) */
        Pattern p2 = Pattern.compile("<(.+)>([^<>]+)</\\1>"); 
            Matcher m2 = p2.matcher(line);
            
            if (!m2.find()) {
                System.out.println("None");
            } else {
                do {                    
                    String result = m2.group(2); // vai printar o 2° grupo, dentro do 2 parenteses
                    System.out.println(result.equals("") ? "None" : result);
                } while (m2.find());
            }


    }
}
