package ex06_02;

import java.awt.print.Printable;

public class Tree {
	public int data;
	Tree lchild;
	Tree rchild;
	public Tree(int data){
		this.data=data;
		this.lchild=null;
		this.rchild=null;
	}
}
