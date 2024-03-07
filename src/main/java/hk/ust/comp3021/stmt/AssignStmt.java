package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class AssignStmt extends ASTStmt {
    // Assign(expr* targets, expr value, ...)
    private ArrayList<ASTExpr> targets = new ArrayList<>();
    private ASTExpr value;

    public AssignStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTStmt.
        super(node);
        targets = node.getChildren().get(0); // variable
        value = node.getChildren().get(1);	// the expr class working
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
    	ArrayList<ASTElement> return_Children_list = new ArrayList<ASTElemnt>;
    	for (ASTElement Children : this.node.getChildren())
    	{
    		return_Children_list.add(Children);
    	}
        return return_Children_list;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
    	int count = 0;
    	for (ASTElement Children : this.node.getChildren())
    	{
    		count ++;
    	}
        return count;
    }
    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
    }

    /**
     * Attention: You may need to define more methods to update or access the field
     * of the class ASTStmt, i.e., getters or setters Feel free to define more
     * method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private"
     * to "public"
     */
    @Override
    public void yourMethod() {
    }

}
