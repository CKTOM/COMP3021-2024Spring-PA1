package hk.ust.comp3021.stmt;

import hk.ust.comp3021.expr.*;
import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.ArrayList;


public class ForStmt extends ASTStmt {
    //  For(expr target, expr iter, stmt* body, stmt* orelse, ...)
    private ASTExpr target;
    private ASTExpr iter;
    private ArrayList<ASTStmt> body = new ArrayList<>();
    private ArrayList<ASTStmt> orelse = new ArrayList<>();
    public ForStmt(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.stmtType = StmtType.For;
        this.target = ASTExpr.createASTExpr(node.getChildByIdx(0));
        this.iter= ASTExpr.createASTExpr(node.getChildByIdx(1));
        for (XMLNode child : node.getChildByIdx(2).getChildren())
        {
            this.body.add(ASTStmt.createASTStmt(child));
        }
        for(XMLNode child : node.getChildByIdx(3).getChildren())
        {
            this.orelse.add(ASTStmt.createASTStmt(child));
        }
    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> return_Children_list = new ArrayList<ASTElement>();
        return_Children_list.add(this.iter);
        return_Children_list.add(this.target);
        return_Children_list.addAll(this.body);
        return_Children_list.addAll(this.orelse);
        return return_Children_list;
    }
    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        int count = 4;
        count += this.iter.countChildren();
        count += this.target.countChildren();
        for (ASTStmt child : this.body)
        {
            count += child.countChildren();
        }
        for (ASTStmt child : this.orelse)
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
