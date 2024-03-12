package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class AugAssignStmt extends ASTStmt {
    // AugAssign(expr target, operator op, expr value)
    private ASTExpr target;
    private ASTEnumOp op;
    private ASTExpr value;

    public AugAssignStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.target = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.op = new ASTEnumOp(node.getChildByIdx(1));
        this.value = ASTExpr.createASTExpr(node.getChildByIdx(2));
        this.stmtType = StmtType.AugAssign;
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
    	ArrayList<ASTElement> return_Children_list = new ArrayList<ASTElement>();
        return_Children_list.add(this.target);
        return_Children_list.add(this.op);
        return_Children_list.add(this.value);
        return return_Children_list;
    }
    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
    	int count = 3;
        count += this.value.countChildren();
        count += this.op.countChildren();
        count += this.target.countChildren();
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
