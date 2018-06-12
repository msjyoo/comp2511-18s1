package q4;

class Item implements Component
{
    private int price;

    Item(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
