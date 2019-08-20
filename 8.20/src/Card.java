
//ArrayList 的简单应用
public class Card {
    int value;
    String color;

    public  Card(int value,String color){
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        return "{" +
                "value=" + value +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Card)) return false;
        Card other = (Card) o;
        return this.value == other.value &&
                this.color.equals(other.color);
    }



}
