public class ArrayOfAddress {
    private static Address[] data;
    private int size;
    private int capacity;

    public ArrayOfAddress(){
        this.capacity = 10;
        this.data = new Address[capacity];
        this.size = 0;
    }

    public ArrayOfAddress(int capacity){
        this.capacity = capacity;
        this.data = new Address[capacity];
        this.size = 0;
    }

    private void extendArray(){
        int newCapacity = capacity + 10;
        Address[] newData = new Address[newCapacity];

        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }

        data = newData;
        capacity = newCapacity;
    }

    public void addAddress(Address address){
        if(size == capacity){
            extendArray();
        }
        data[size] = address;
        size++;
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean contains(Address address){
        for (int i = 0; i < size; i++) {
            Address current = data[i];
            if (address.getStreet().equals(current.getStreet()) &&
                    address.getCity().equals(current.getCity()) &&
                    address.getCoordinate().getX() == current.getCoordinate().getX() &&
                    address.getCoordinate().getY() == current.getCoordinate().getY()) {
                return true;
            }
        }
        return false;
    }

    public void remove(Address address){
        for(int i = 0; i < size; i++){
            Address current = data[i];
            if (address == current){
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[size - 1] = null;
                size--;
            }
        }
        System.out.println("Был удалён адрес: " + address);
    }

    public int returnIndex(Address address){
        for (int i = 0; i < size; i++) {
            Address current = data[i];
            if (address.getStreet().equals(current.getStreet()) &&
                    address.getCity().equals(current.getCity()) &&
                    address.getCoordinate().getX() == current.getCoordinate().getX() &&
                    address.getCoordinate().getY() == current.getCoordinate().getY()) {
                return i;
            }
        }
        return -1;
    }

    public void removeByIndex(int index){
        Address current = data[index];
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[size - 1] = null;
        size--;
        System.out.println("Был удалён адрес: " + current);
    }

    public Address getIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс: " + index + ", Размер: " + size);
        }
        return data[index];
    }
}
