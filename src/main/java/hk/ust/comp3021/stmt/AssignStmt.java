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
        for(XMLNode child : node.getChildByIdx(0).getChildren())
        {
            this.targets.add(ASTExpr.createASTExpr(child));
        }
        this.value = ASTExpr.createASTExpr(node.getChildByIdx(1));
        this.stmtType = ASTStmt.StmtType.Assign;
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
    	ArrayList<ASTElement> return_Children_list = new ArrayList<>();
        // how to get the children
        return_Children_list.addAll(this.targets);
        return_Children_list.add(this.value);
        return return_Children_list;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        int count = 1;
        count += this.value.countChildren();
        count += this.targets.size();
        for(ASTExpr child : this.targets)
        {
            count += child.countChildren();
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
