import java.util.ArrayList;

/**
 * Binary Search Tree Class
 * 
 * The head class for a binary search tree implementation.
 * 
 * @author nat2eh
 * @param <Comparable> Type of data to store in the binary tree
 */
public class BinarySearchTree<T extends Comparable<T>> {

	/**
	 * A reference pointer to the root of the tree
	 */
	private TreeNode<T> root;

	/**
	 * Default constructor
	 * 
	 * Creates a binary tree object with null root note (empty tree)
	 */
	public BinarySearchTree() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * Creates a binary tree object with the given node as root
	 * 
	 * @param newRoot The root of the tree
	 */
	public BinarySearchTree(TreeNode<T> newRoot) {
		this.root = newRoot;
	}

	/**
	 * Get the root of the tree
	 * 
	 * @return The root of the tree
	 */
	public TreeNode<T> getRoot() {
		return root;
	}

	/**
	 * Set the root of the tree
	 * 
	 * @param root The new root of this tree
	 */
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	// size method
	public int size() {
		if (this.getRoot() == null) { // if root null the size is zero
			return 0;
		} else
			return this.root.size(); // calls size from TreeNode on the root
	}

	// height method
	public int height() {
		if (this.getRoot() == null) { // if root is null the height is zero
			return 0;
		}
		return this.root.height(); // calls height from TreeNode on the root
	}

	/**
	 * Find if an element exists
	 * 
	 * Checks to see if the value val appears in the tree (recursively). Returns
	 * true if it appears and false otherwise.
	 * 
	 * @param val The value to find
	 * @return True if the tree contains the value, false otherwise
	 */
	public boolean find(T val) {
		if (this.getRoot() == null) { // if root is null, tree is null and thus value can't be found (returns false)
			return false;
		}
		return root.find(val); // calls find from TreeNode on the root searching for val
	}

	/**
	 * Insert an element
	 * 
	 * Inserts val into the tree where it should appear, returning true on success
	 * and false otherwise
	 * 
	 * @param val The value to insert
	 * @return True on success, false otherwise
	 */
	public boolean insert(T val) {
		if (this.getRoot() == null) { // if root is null, then tree is null and empty
			this.setRoot(new TreeNode<T>(val)); // set the root to be a new node and return true
			return true;
		}
		return root.insert(val); // calls insert from TreeNode on the root
	}

	/**
	 * Delete an element from the tree
	 * 
	 * Deletes val from the tree if it appears, returning true on success and false
	 * otherwise
	 * 
	 * @param val The value to delete
	 * @return True on success, false otherwise
	 */
	public boolean delete(T val) { // optional
		return false;
	}

	/**
	 * Build from a list
	 * 
	 * Build the tree from the given list, overwriting any tree data previously
	 * stored in this tree. Should read from beginning to end of the list and
	 * repeatedly call insert() to build the tree.
	 * 
	 * @param list The list from which to build the tree
	 * @return True if successfully built, false otherwise
	 */

	public boolean buildFromList(ArrayList<T> list) {
		if (this.getRoot() == null) { // if root is null (tree is empty)
			for (T x : list) { // iterate through the values in the list
				insert(x); // call insert on the value
			}
			return true; // return true
		}
		return false; // if root is not empty return false
	}

	/**
	 * toString method
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return root.toString(); // call the toString method from TreeNode on the root
	}

	// inOrder method
	public String inOrder() {
		if (this.getRoot() == null) { // if the root is null/tree is empty then return an empty string
			return "";
		}
		return this.getRoot().inOrder(); // call inOrder from TreeNode on the root
	}

	// postOder method
	public String postOrder() {
		if (this.getRoot() == null) { // if the root is null/tree is empty then return an empty string
			return "";
		}
		return this.getRoot().postOrder(); // call postOrder from TreeNode on the root
	}

}
