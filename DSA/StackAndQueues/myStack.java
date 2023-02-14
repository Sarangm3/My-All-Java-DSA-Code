package DSA.StackAndQueues;

class myStack {
    protected int[] data; //array pointer
    private static final int DEFAULT_SIZE = 10;
    //private use in class//static don't required object to use and final not change at all

    int tope=-1; //for pointing current index

    public myStack(){
        this(DEFAULT_SIZE);//calling anther constructor of class
    }

    public myStack(int size)
    {
        this.data = new int[size];//make new array
    }

    public void push(int item){
        if (isFull()) {
            System.out.println("Stack is full");
        }
        tope++;
        data[tope] = item;
    }
    public int peek() throws Exception{
        if (isEmpty())
        {
            throw new Exception("Empty Stack exception for peek");
        }
        return data[tope];
    }
    public int pop() throws Exception { // check exception video you can make your own exception class
        if (isEmpty())
        {
            throw new Exception("Empty Stack exception for pop");
        }
        int removeData = data[tope];
        tope--;
        return removeData;
    }

    public boolean isFull() {
        return tope==data.length-1;
    }
    public boolean isEmpty(){
        return tope==-1;
    }
}
