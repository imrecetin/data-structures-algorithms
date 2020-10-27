package com.problems.leetcode.easy.array;

public class CellsWithOddValuesInAMatrix {
    public static void main(String[] args) {
        final int oddCellCount = oddCells(3, 4, new int[][]{{0, 1}, {1, 1}});
        System.out.println(oddCellCount);
    }

    public static int oddCells(int n, int m, int[][] indices) {
        int[] row=new int[n];
        int[] column=new int[m];
        int oddCount=0;
        for (int i=0;i<indices.length;++i){
            row[indices[i][0]]++;
            column[indices[i][1]]++;
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++) {
                if((row[i]+column[j])%2!=0)
                    oddCount++;
            }
        return oddCount;
    }

    /**
     * The idea is following: since we increment whole rows/columns at once there is no need
     * to keep the matrix model and insted we can have 2 separate arrays for rows[n] and columns[m].
     *
     * By iterating through the indices array we'll be incrementing corresponding values for rows and columns in
     * their dedicated arrays.
     *
     * The second important thing - how to interpret those and see which numbers we'll have? For those purposes we'll
     * be using several things:
     * 0. Imagine our matrix as a linear array where all the rows go one after another (quite common practice to
     *    display multi-dimensional data structures) so that n=0 would mean first m elements, then n=1 -> next m
     *    elemenst and so on.
     * 1. overall matrix size (or number of numbers if you like) -> n*m
     * 2. the fact that by updating the row array by 1, we're updating the whole row to 1
     *    e.g. if we have n=2 and m=3, then 1 row updated to 1 would mean first 3 numbers in the matrix are 1s
     * 3. Similar goes for the columns -> +1 to columns at a specific index means we're updating every m-th element in
     *    that imaginary matrix to +1
     */
    public int oddCellsWithEducationalPart(int n, int m, int[][] indices) {
        int[] rows = new int[n];
        int[] columns = new int [m];

        //Updating the corresponding arrays in O(n)
        //here we'll keep track of the updates for each row and column
        //based on indices array
        for(int ind=0; ind<indices.length; ind++){
            rows[indices[ind][0]] ++;
            columns[indices[ind][1]] ++;
        }


        //Now the fun part - interpreting which numbers we have in result.
        //Starting from rows array. As you remember, it shows which rows were incremented and how many times.
        //e.g. [2, 1] would say `first row was incremented twice so we now have all dueces there and
        // the second one we've incremented only once - so all the elements will be 1s`

        int oddNumbers = 0;
        int matrixSize = n*m;
        for(int i=0; i<matrixSize; i++){

            int rowsIncrementIndex = i/m; //e.g. 0,0,0,1,1,1
            int colsIncrementIndex = i%m; //e.g. 0,1,2,0,1,2

            //then we'll be iterating through n*m numbers in total
            //the rows[0] would display how we should update our first `n` numbers
            //the cols[0] - how we additionally should update every `m`-th number
            //so in order to get the information on how to update this particular number by its index
            //we can use such calculations (notice how we don't really need n value there):
            //if i is the current index, then `i/m` would let us get the value from rows array
            //and the `i%m` - for the columns. Then we just sum those 2 values to get the current number in
            //the matrix which, in turn, we don't really need to put anything and just increment our oddNumbers
            //if it is actuall odd.
            //
            //e.g. let's go over some example iterations
            //     consider our rows are [2, 1] and columns are [1,0,1]
            //i=0  ->  row_index = i/3 = 0;  col_index = i%3 =0; -> 2 + 1 = 3; -> oddNumbers++
            //i=1  ->  row_index = i/3 = 0;  col_index = i%3 =1; -> 2 + 0 = 2;
            //i=2  ->  row_index = i/3 = 0;  col_index = i%3 =2; -> 2 + 1 = 3; -> oddNumbers++
            //i=3  ->  row_index = i/3 = 1;  col_index = i%3 =0; -> 1 + 1 = 2;
            //i=4  ->  row_index = i/3 = 1;  col_index = i%3 =1; -> 1 + 2 = 1; -> oddNumbers++
            //i=5  ->  row_index = i/3 = 1;  col_index = i%3 =2; -> 1 + 1 = 2;
            //
            //and the result: oddNumbers==3
            if((rows[rowsIncrementIndex] + columns[colsIncrementIndex]) %2 == 1) {
                oddNumbers++;
            }
        }
        return oddNumbers;
    }

}
