package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;

public class BinOpExpr extends ASTExpr {
    // BinOp(expr left, operator op, expr right)
    private ASTExpr left;
    private ASTEnumOp op;
    private ASTExpr right;

    public BinOpExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ExprType.BinOp;
        this.left = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.op = new ASTEnumOp(node.getChildByIdx(1));
        this.right = ASTExpr.createASTExpr(node.getChildByIdx(2));
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> return_child_list = new ArrayList<ASTElement>();
        return_child_list.add(this.left);
        return_child_list.add(this.right);
        return return_child_list;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        int count = 2;
        count += this.left.countChildren();
        count += this.right.countChildren();
        return count;
    }

    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
    }

    /**
     * Attention: You may need to define more methods to update or access the field of the class `User`
     * Feel free to define more method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private" to "public"
     */
    public ASTEnumOp returnop() {
        return this.op;
    }

}
