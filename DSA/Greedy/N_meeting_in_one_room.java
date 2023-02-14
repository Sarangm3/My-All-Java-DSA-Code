package DSA.Greedy;

import java.util.*;

class Solution
{
    class meeting{
        int start;
        int end;
        int pos;

        public meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }

        @Override
        public String toString() {
            return "("+start+","+end+","+pos+")";

        }
    }

    class meetingComparator implements Comparator<meeting>
    {
        @Override
        public int compare(meeting o1, meeting o2) {
            if (o1.end > o2.end) //ascending
                return 1;
            else if (o1.end == o2.end && o1.pos > o2.pos)
                return 1;
            return -1;
        }
    }
    public int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meeting> list = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            list.add(new meeting(start[i],end[i],i+1));
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        Collections.sort(list,new meetingComparator());
        for (int i = 0; i < start.length; i++) {
            System.out.print(list.get(i)+" ");
        }
        int prevend = list.get(0).end;
        int count = 1;
        ArrayList<Integer> index = new ArrayList<>();
        index.add(0);
        for (int i = 1; i < list.size(); i++) {
            int currstart = list.get(i).start;
            int currend = list.get(i).end;
            if(prevend<currstart)
            {
                count++;
                index.add(i);
                prevend = currend;
            }
        }
        for (int i = 0; i < index.size(); i++) {
            System.out.print("( "+list.get(index.get(i)).start+", ");
            System.out.print(list.get(index.get(i)).end+", ");
            System.out.print(list.get(index.get(i)).pos+"),");
            System.out.println(list.get(index.get(i)).start-list.get(index.get(i)).end);
        }
        return count;
    }
}
public class N_meeting_in_one_room  {
    public static void main(String[] args) {
        Solution s = new Solution();
        int start[] = {86,32,31,98,37,65,98,71,99,58,59,32,52,69,15,75,4,86,57,36,83,18,58,50,43,29,98,53,80,5,89,73,8,97,17,100,9,21,55,55,32,74,60,32,87,72,54};
        int end[] =  {126, 112 ,134 ,138, 89, 118, 107, 124, 126, 83 ,133 ,64, 124, 109 ,108 ,132 ,111 ,95 ,82 ,106 ,86 ,118 ,82 ,78 ,92 ,55 ,128 ,121 ,118 ,95 ,94 ,110 ,111, 146, 124, 148, 95 ,146 ,109 ,61 ,93 ,126 ,74, 76, 110, 78 ,91};
        System.out.println(s.maxMeetings(start,end,start.length));

    }
}
