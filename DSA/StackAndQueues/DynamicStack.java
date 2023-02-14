package DSA.StackAndQueues;

public class DynamicStack extends CustomStack{

    public DynamicStack(){
        super();
    }
    public DynamicStack(int size)
    {
        super(size);
    }

    @Override
    public void push(int item) {
        if (isFull())
        {
            //double size
            int [] temp = new int[data.length*2];
            for (int i = 0; i < data.length; i++) {
                temp[i]= data[i];
            }
            data = temp;
        }
        //now array not gone be full so we can push
        super.push(item);
    }

}
