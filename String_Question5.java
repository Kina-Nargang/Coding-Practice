public setZeros(int[][]  matrix){
	// if matrix is null then return
	if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return;
	
	/* if there are zeros on the first row and first column 
	   we dont set the first entire row and the first entire column to zeros at first,
	   we use a boolean variable to store it and set zeros later
	*/
	boolean row = false;
	boolean col = false;
	
	int row_len = matrix.length;
	int col_len = matrix[0].length;
	
	// if there is a zero we set matrix[i][0] = 0 and matrix[0][j] = 0
	for (int i = 0;i < row_len;i++){
		for (int j = 0;j < col_ren;j++){
			if (matrix[i][j] == 0){
				matrix[i][0] = 0;
				matrix[0][j] = 0;
				if (i == 0) row = true;
				if (j == 0) col = true;
			}
		}
	}
	
	// if there is a zero on the first column then set the entire row to zeros
	// the loop start from matrix[1][1]
	for (int i = 1; i < row_len; i++){
		if (matrix[i][0] == 0){
			for (int j = 1;j < col_len;j++){
				matrix[i][j] = 0;
			}
		}
	}
	// if there is a zero on the first row then set the entire column to zeros
	// the loop start from matrix[1][1]
	for (int j = 1; j < col_len; j++){
		if (matrix[0][j] == 0){
			for (int i = 1; i < row_len;i++){
				matrix[j][i] = 0;
			}
		}
	}
	
	// if there is a zero on the first row the set the first row to zeros
	if (row) {
		for (int j = 0; j < col_len; j++){
			matrix[0][j] = 0;
		}
	}
	// if there is a zero on the first column the set the first column to zeros
	if (col) {
		for (int i = 0;i < row_len;i++){
			matirx[i][0] = 0;
		}
	}
}