package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{0,0},{12,15},{0,7}};
        intervals = merge(intervals);
        for(int[] interval:intervals){
            System.out.println(Arrays.toString(interval));
        }

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] newInterval = intervals[0];
        result.add( newInterval);
        for(int[] interval:intervals){
            if(interval[0]<=newInterval[1]){
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }else{
                newInterval = interval;
                result.add( newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
    
}
