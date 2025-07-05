class InPlaceMatrixZeroing {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) firstColZero = true;

        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) firstRowZero = true;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (firstRowZero)
            for (int j = 0; j < n; j++) matrix[0][j] = 0;

        if (firstColZero)
            for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        new InPlaceMatrixZeroing().setZeroes(matrix);
        for (int[] row : matrix) System.out.println(Arrays.toString(row));
    }
}