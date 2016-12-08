package DynamicProgramming;

public class LCS {

	public final static int UP = 0;
	public final static int UPLEFT = 1;
	public final static int LEFT = 2;
	int m, n;
	int[][] b, c;
	char[] x, y;
	// final lcs string
	private StringBuilder lcsString = new StringBuilder();

	/**
	 * constructor
	 * 
	 * @param x
	 * @param y
	 */
	public LCS(char[] x, char[] y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * build 2 table b and c
	 * 
	 * @param x
	 * @param y
	 */
	public void findLCS(char[] x, char[] y) {

		m = x.length;
		n = y.length;
		b = new int[m + 1][n + 1];
		c = new int[m + 1][n + 1];
		for (int i = 1; i < m; i++)
			c[i][0] = 0;
		for (int i = 0; i < n; i++)
			c[0][i] = 0;

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (x[i - 1] == y[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					b[i][j] = UPLEFT;
				} else if (c[i - 1][j] >= c[i][j - 1]) {
					c[i][j] = c[i - 1][j];
					b[i][j] = UP;
				} else {
					c[i][j] = c[i][j - 1];
					b[i][j] = LEFT;
				}
			}
		}
		//get lcs string
		printLCS(b, x, m, n);
		System.out.println(getLCSString());

	}

	/**
	 * find and print out lcs Strinh
	 * 
	 * @param b
	 * @param x
	 * @param i
	 * @param j
	 * @return
	 */
	public String printLCS(int[][] b, char[] x, int i, int j) {
		// base case
		if (i == 0 || j == 0) {
			return lcsString.toString();
		}
		if (b[i][j] == UPLEFT) {
			lcsString.insert(0, x[i - 1]);
			printLCS(b, x, i - 1, j - 1);
		} else if (b[i][j] == UP) {
			printLCS(b, x, i - 1, j);
		} else {
			printLCS(b, x, i, j - 1);
		}
		return lcsString.toString();
	}

	/**
	 * print c table
	 */
	public void printLCSTable() {
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				System.out.print(c[i][j] + "  ");
			}
			System.out.println();
		}
	}

	/**
	 * get lcs string
	 * 
	 * @return
	 */
	public String getLCSString() {
		return lcsString.toString();
	}

	/**
	 * get X
	 * 
	 * @return x[]
	 */
	public char[] getX() {
		return this.x;
	}

	/**
	 * get y
	 * 
	 * @return y[]
	 */
	public char[] getY() {
		return this.y;
	}
}
