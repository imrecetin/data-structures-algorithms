package com.problems.leetcode;

public class RotateImage {
    public static void main(String[] args) {
        int [][] matrix = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int [] row:matrix) {
            for (int number:row){
                System.out.print(number+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */
    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        reverseMatrixRows(matrix,0,matrix.length-1);
        for (int i=0;i<matrix.length;++i){
            for (int j=i + 1;j<matrix[i].length;++j){
                swapMatrixCells(matrix,i,j);
            }
        }
    }

    private static void swapMatrixCells(int[][] matrix, int i, int j) {
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    }

    private static void reverseMatrixRows(int[][] matrix, int rowNumber1,int rowNumber2) {
        int [] temp=matrix[rowNumber2];
        matrix[rowNumber2] = matrix[rowNumber1];
        matrix[rowNumber1]=temp;
    }
}
