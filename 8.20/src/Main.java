import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Main {

    private static void swap(ArrayList<Card> list, int i, int j) {
        Card tmpI = list.get(i);
        Card tmpJ = list.get(j);
        list.set(i, tmpJ);
        list.set(j, tmpI);
    }

    private static Card getCard(ArrayList<Card> list){
        Random random = new Random(20190830);
        return list.remove(random.nextInt(list.size()-1));

    }

    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>(52);
        String[] colors = {"♥", "♦", "♠", "♣"};

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                Card card = new Card(j, colors[i]);
                cards.add(card);
            }
        }


        Random random = new Random(20190830);//随机数洗牌
        for (int i = 51; i > 0; i--) {
            int j = random.nextInt(i);
            swap(cards, i, j);
        }
        //三人抽卡，一人五张
        ArrayList<Card> A = new ArrayList<>();
        ArrayList<Card> B = new ArrayList<>();
        ArrayList<Card> C = new ArrayList<>();
        System.out.println(cards);

        for (int i = 0; i < 5; i++) {
            A.add(getCard(cards));
            B.add(getCard(cards));
            C.add(getCard(cards));
        }
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);


        //验证A手里是否有特定的牌
        Card redHeartA = new Card(13,"♠");
        for(Card card:A){
            if(card.equals(redHeartA)){
                System.out.println("yes");
            }
        }

        //如果A手里有特定的牌，删除它，如果没有则返回无
        Card redHeart = new Card(13,"♠");
        Iterator<Card> it = A.iterator();
        while (it.hasNext()){
            Card o = it.next();
            if(o.equals(redHeart)){
                System.out.println("yes");
                it.remove();
            }
        }
    }
}









