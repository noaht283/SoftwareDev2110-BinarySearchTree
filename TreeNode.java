
/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 * 
 * @author nat2eh
 * @param <Comparable> The type of data this tree node stores
 */
public class TreeNode<T extends Comparable<T>> {

	/**
	 * Reference pointer to the left subtree
	 */
	private TreeNode<T> left;

	/**
	 * Reference pointer to the right subtree
	 */
	private TreeNode<T> right;

	/**
	 * Data stored at this node
	 */
	private T data;

	/**
	 * Default Constructor
	 * 
	 * Creates a binary tree node with null data and null children
	 */
	public TreeNode() {
		this(null, null, null);
	}

	/**
	 * Data-only Constructor
	 * 
	 * Creates a binary tree node with the given data and null children
	 * 
	 * @param theData The data to store at this node
	 */
	public TreeNode(T theData) {
		this(theData, null, null);
	}

	/**
	 * Full Constructor
	 * 
	 * Creates a binary tree node with the given data and child reference pointers
	 * 
	 * @param theData    The data to store at this node
	 * @param leftChild  A reference pointer to the left subtree
	 * @param rightChild A reference pointer to the right subtree
	 */
	public TreeNode(T theData, TreeNode<T> leftChild, TreeNode<T> rightChild) {
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	/**
	 * Left Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the left subtree
	 */
	public TreeNode<T> getLeft() {
		return left;
	}

	/**
	 * Left Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new left subtree's root node
	 */
	public void setLeft(TreeNode<T> left) {
		this.left = left;
	}

	/**
	 * Right Child/Subtree getter
	 * 
	 * @return A reference pointer to the root of the right subtree
	 */
	public TreeNode<T> getRight() {
		return right;
	}

	/**
	 * Right Child/Subtree Setter
	 * 
	 * @param left A reference pointer to the new right subtree's root node
	 */
	public void setRight(TreeNode<T> right) {
		this.right = right;
	}

	/**
	 * Get the data at this node
	 * 
	 * @return The data stored at this node
	 */
	public T getData() {
		return data;
	}

	/**
	 * Set the data at this node
	 * 
	 * @param data The data to be stored at this node
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * toString method
	 */
	@Override
	public String toString() {
		return this.inOrder(); // toString calls inOrder method
	}

	// size method
	public int size() {
		if (this.getData() == null) { // return zero for the base case size
			return 0;
		} else if (this.getLeft() == null && this.getRight() != null) {
			return (1 + this.getRight().size()); // if the node is not null but the node only has a right child, return
													// 1 and then call size again on the right child
		} else if (this.getLeft() != null && this.getRight() == null) {
			return (1 + this.getLeft().size()); // if the node is not null but the node only has a left child, return 1
												// and then call size on the left child
		} else if (this.getLeft() == null && this.getRight() == null) {
			return 1; // if the node is not null but the node has no children return 1
		}
		return (this.getLeft().size() + 1 + this.getRight().size()); // if the node has both a right and a left child,
																		// return 1 and recall size on both children
	}

	// height method
	public int height() {
		if (this.getData() == null) { // if the node is null, then return zero for the base case height
			return 0;
		}
		if (this.getData() != null && this.getLeft() != null && this.getRight() != null) { // if the node is not null
																							// and it has a left and
																							// right child
			int leftHeight = this.getLeft().height(); // get the height of the left child and store it as an int
			int rightHeight = this.getRight().height(); // get the height of the right child and store it as an int
			if (leftHeight > rightHeight) { // if leftHeight is greater than rightHeight, return leftHeight + 1 for the
											// previous node
				return leftHeight + 1;
			} else
				return rightHeight + 1; // else return rightHeight + 1 for the previous node
		}
		if (this.getData() != null && this.getLeft() != null && this.getRight() == null) { // if the node only has a
																							// left child
			int leftHeight = this.getLeft().height(); // get the height of the left side
			return leftHeight + 1; // return that height plus one for the previous node
		}
		if (this.getData() != null && this.getLeft() == null && this.getRight() != null) { // if the node only has a
																							// right child
			int rightHeight = this.getRight().height(); // get the height of the left side
			return rightHeight + 1; // return that height plus one for the previous node
		} else
			return 1; // if the node has no children, return 1 for that node
	}

	// find method
	public boolean find(T val) {
		if (this.getData() == null) { // if node is null, then return false because value can't be found in a null
										// tree
			return false;
		}
		if (this.getData() == val) { // if node is the value, then return true for the base case because it has been
										// found!
			return true;
		}
		if (this.getData().compareTo(val) > 0 && this.getLeft() != null) { // compare the node to the value, and if the
																			// value is less and there is a left child
			return this.getLeft().find(val); // call find on the left child and continue
		} else if (this.getData().compareTo(val) < 0 && this.getRight() != null) { // compare the node to the value, and
																					// if the value is greater and there
																					// is a right child
			return this.getRight().find(val); // call find on the right child and continue
		} else if (this.getData().compareTo(val) == 0) { // compare the node to the value, and if they are equal, return
															// true becuase it has been found!
			return true;
		}
		return false; // if not any of the above, return false because you did not find the value
	}

	// insert method
	public boolean insert(T val) {
		if (this.getData() == null) { // if node is null
			this.setData(val); // set the data of the node to the value and return true
			return true;
		}
		if (this.getData().compareTo(val) > 0) { // compare the value to the data, and if the value is less then
			if (this.getLeft() == null) { // check to see if there is a left child, if not
				this.setLeft(new TreeNode<T>(val)); // create a new node, set it as the left child, and return true
				return true;
			}
			return this.getLeft().insert(val); // if there is a left child then call insert on the left child and
												// continue
		}
		if (this.getData().compareTo(val) < 0) { // compare the value to the data, and if the value is greater then
			if (this.getRight() == null) { // check to see if there is a right child, if not
				this.setRight(new TreeNode<T>(val)); // create a new node, set it as the right child, and return true
				return true;
			}
			return this.getRight().insert(val); // if there is a right child then call insert on the right child and
												// continue
		}
		if (this.getData() == val) { // if the node is equal to the value, then return false because no need to
										// insert and create a duplicate
			return false;
		}
		if (this.getData().compareTo(val) == 0) { // if the node is equal to the value when compared, then return false
													// because no need to insert and create a duplicate
			return false;
		}

		return false; // if not any of the above, return false
	}

	// inOrder method
	public String inOrder() {
		String s = ""; // create an empty string
		if (this.getLeft() != null) { // if there is a left child
			s += this.getLeft().inOrder(); // call inOrder on the left child and add that to the string
		}
		if (this.getData() != null) { // if the current node is not null
			s += "(" + this.getData() + ")"; // enclose it in parenthesis and add it to the string
		}
		if (this.getRight() != null) { // if there is a right child
			s += this.getRight().inOrder(); // call inOrder on the right child and add that to the string
		}
		return s; // return the string
	}

	// postOrder method
	public String postOrder() {
		String s = ""; // create an empty string
		if (this.getLeft() != null) { // if there is a left child
			s += this.getLeft().postOrder(); // call postOrder on the left child and add that to the string
		}
		if (this.getRight() != null) { // if there is a right child
			s += this.getRight().postOrder(); // call postOrder on the right child and add that to the string
		}
		if (this.getData() != null) { // if the current node is not null
			s += "(" + this.getData() + ")"; // enclose is in parenthesis and add it to the string
		}
		return s; // return the string
	}

}

